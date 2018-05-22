package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.GetTypeByHead;
import just.learn.entity.*;
import just.learn.mapper.HomeworkMapper;
import just.learn.mapper.SubmitHomeworkMapper;
import just.learn.mapper.UserCourseMapper;
import just.learn.mapper.UserMapper;
import just.learn.vo.QueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/5/15 15:01
 */
@Service
public class SubmitHomeworkServiceImpl implements SubmitHomeworkService {
    @Autowired
    private SubmitHomeworkMapper submitHomeworkMapper;
    @Autowired
    private HomeworkMapper homeworkMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCourseMapper userCourseMapper;

    @Override
    public String submitHomework(MultipartFile file, SubmitHomework submitHomework, UserElement ue) throws IOException {

        if (submitHomework == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (file == null || file.isEmpty()) {
            throw new CustomException(ResultEnum.FILE_EMPTY);
        }
        Homework homework = homeworkMapper.selectByPrimaryKey(submitHomework.getHomeworkId());
        if (homework == null) {//先查询作业是否存在
            throw new CustomException(ResultEnum.HOMEWORK_FIND_NULL);
        }
        User user=userMapper.selectByNumber(ue.getUserNumber());
        UserCourse userCourse=userCourseMapper.selectByUserIdAndCourseId(user.getId(),homework.getCourseId());
        if(userCourse==null){
            throw new CustomException(ResultEnum.NO_SELECT_COURSE);
        }
        if (homework.getEndTime().before(new Date())) {//验证截止日期
            throw new CustomException(ResultEnum.HOMEWORK_IS_END);
        }



        if ("docx".equals(GetTypeByHead.getFileType(file))) {
            String url = "E:\\" + file.getOriginalFilename();
            file.transferTo(new File(url));//保存文件
            //重复提交
            SubmitHomework repeatSubmitHomework1 = submitHomeworkMapper.selectSubmitHomeworkByUserId(submitHomework
                    .getUserId());
            if (repeatSubmitHomework1 != null) {//重复提交,更新记录
                repeatSubmitHomework1.setGmtUpdate(new Date());
                repeatSubmitHomework1.setUrl(url);
                submitHomeworkMapper.updateByPrimaryKey(repeatSubmitHomework1);
            } else {//不重复提交,直接插入
                submitHomework.setUrl(url);
                submitHomework.setGmtCreate(new Date());
                submitHomework.setGmtUpdate(new Date());
                submitHomeworkMapper.insertSelective(submitHomework);
            }
            return url;
        } else {
            throw new CustomException(ResultEnum.FILE_FORMAT_ERROR);
        }
    }

    @Override
    public List<SubmitHomework> getSubmitHomeworkByHomeworkId(Integer homeworkId) {
        if (homeworkId == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        return submitHomeworkMapper.selectSubmitHomeworkByHomeworkId(homeworkId);
    }

    @Override
    public String grade(Integer submitHomeworkId, String score) {
        if (submitHomeworkId == null || score == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        SubmitHomework submitHomework = submitHomeworkMapper.selectByPrimaryKey(submitHomeworkId);
        if (submitHomework == null) {
            throw new CustomException(ResultEnum.SUBMITHOMWORK_FIND_NULL);
        }
        submitHomework.setScore(score);

        return submitHomeworkMapper.updateByPrimaryKeySelective(submitHomework) + "";
    }

    @Override
    public void download(Integer submitHomeworkId, HttpServletResponse response) {
        if (submitHomeworkId == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        SubmitHomework submitHomework = submitHomeworkMapper.selectByPrimaryKey(submitHomeworkId);
        if (submitHomework == null) {
            throw new CustomException(ResultEnum.SUBMITHOMWORK_FIND_NULL);
        }
        File file = new File(submitHomework.getUrl());
        if (file.exists()) {
            String fileName = submitHomework.getUrl().split("\\\\")[submitHomework.getUrl().split("\\\\").length - 1];
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
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
        } else {
            throw new CustomException(ResultEnum.FILE_EMPTY);
        }


    }

    @Override
    public List<SubmitHomework> getSubmitHomwork(SubmitHomework submitHomework) {
        if (submitHomework == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        return submitHomeworkMapper.selectSubmitHomeworkByObject(submitHomework);
    }

    @Override
    public List<SubmitHomework> findSubmitHomeworkInfo(QueryCondition<SubmitHomework> queryCondition) {
        PageHelper.startPage(queryCondition.getPageNum(),queryCondition.getPageSize());
        return submitHomeworkMapper.selectSubmitHomeworkByObject(queryCondition.getObject());
    }

/*    private boolean isValid(String typesString,MultipartFile file) throws IOException {
        String []types=typesString.split(",");
        for (String type:types) {
            if(type.equals(GetTypeByHead.getFileType(file))){
                return true;
            }
        }
        return false;
    }*/
}
