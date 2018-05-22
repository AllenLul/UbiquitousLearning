package just.learn.service;

import just.learn.entity.Course;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseService {


    public Course insert(Course course);

    public boolean delete(Integer id);

    public int update(Course course);

    public Course getById(Integer id);


    List<Course> getRecommend();

    List<Course> findStudentsInfo(int pageNum, int pageSize);

    List<Course> getCourse(Course course);

    String uploadCoursePic(MultipartFile file,Integer id) throws IOException;
}