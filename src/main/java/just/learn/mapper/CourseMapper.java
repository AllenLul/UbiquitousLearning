package just.learn.mapper;

import just.learn.entity.Course;
import just.learn.vo.QueryCondition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    void pass(List list);

    void noPass(List list);


    List<Course> getCoursesByUserId(Long id);

    List<Course> getRecommend();

    List<Course> selectAll();

    List<Course> getCourse(Course course);
}