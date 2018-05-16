package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.FileUtil;
import just.learn.entity.Homework;
import just.learn.entity.SubmitHomework;
import just.learn.mapper.HomeworkMapper;
import just.learn.mapper.SubmitHomeworkMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

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
    public String batchDownload(Integer id) throws IOException {
        SubmitHomework submitHomework=new SubmitHomework();
        submitHomework.setHomeworkId(id);
        List<SubmitHomework> submitHomeworkList=submitHomeworkMapper.selectSubmitHomeworkByObject(submitHomework);
        String dirName="E:\\temp";
        File dir = new File(dirName);
        if (dir.exists()) {
            dir.mkdirs();
        }
        for (SubmitHomework s: submitHomeworkList) {
            FileUtils.copyFile(new File(s.getUrl()), dir);
        }
        FileUtil.zip(dirName);

        return "success";
    }


}