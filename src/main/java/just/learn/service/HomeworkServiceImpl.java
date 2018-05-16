package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.FileUtil;
import just.learn.entity.Homework;
import just.learn.entity.SubmitHomework;
import just.learn.mapper.HomeworkMapper;
import just.learn.mapper.SubmitHomeworkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

import static com.google.common.io.Files.copy;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Resource
    HomeworkMapper mapper;
    @Autowired
    SubmitHomeworkMapper submitHomeworkMapper;
    @Override
    public Homework insert(Homework homework) {
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(homework);
        return homework;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(Homework homework) {
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(homework.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(homework);
    }

    @Override
    public Homework getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        Homework homework = mapper.selectByPrimaryKey(id);
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return homework;
    }

    @Override
    public List<Homework> findStudentsInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }

    @Override
    public List<Homework> getHomework(Homework homework) {
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.getHomework(homework);
    }

    @Override
    public String batchDownload(Integer id,HttpServletResponse response) throws Exception {
        SubmitHomework submitHomework=new SubmitHomework();
        submitHomework.setHomeworkId(id);
        List<SubmitHomework> submitHomeworkList=submitHomeworkMapper.selectSubmitHomeworkByObject(submitHomework);
        String dirName="E:\\temp";
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        for (SubmitHomework s: submitHomeworkList) {
            File oldFile=new File(s.getUrl());
            if (!oldFile.exists()){
                throw new CustomException(ResultEnum.FILE_EMPTY);
            }
            FileUtil.copy(oldFile, dir);
        }
        File zipResult=FileUtil.zip(dirName);
        String fileName = "all";
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName+".zip");// 设置文件名
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(zipResult);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "success";
    }


}