package just.learn.service;

import just.learn.entity.Course;
import just.learn.entity.Courseware;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/12 20:22
 */
public interface AdminService {
    public String importInfo(MultipartFile file) throws Exception;

    void reviewCourse(Course[] courses);
    void reviewCourseware(Courseware []coursewares);
}
