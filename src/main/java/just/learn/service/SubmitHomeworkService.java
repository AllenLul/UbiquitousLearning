package just.learn.service;

import just.learn.entity.SubmitHomework;
import just.learn.entity.UserElement;
import just.learn.vo.QueryCondition;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/5/15 15:01
 */
public interface SubmitHomeworkService {
    /**
     * 提交作业
     * @param file
     * @param submitHomework
     * @param ue
     * @return
     */
    String submitHomework(MultipartFile file, SubmitHomework submitHomework, UserElement ue) throws Exception;

    List<SubmitHomework> getSubmitHomeworkByHomeworkId(Integer homeworkId);

    String grade(Integer submitHomeworkId, String score);

    void download(Integer submitHomeworkId, HttpServletResponse response);

    List<SubmitHomework> getSubmitHomwork(SubmitHomework submitHomework);

    List<SubmitHomework> findSubmitHomeworkInfo(QueryCondition<SubmitHomework> queryCondition);
}
