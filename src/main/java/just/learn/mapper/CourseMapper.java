package just.learn.mapper;

import java.util.List;
import just.learn.entity.Course;
import just.learn.entity.CourseExample;
import just.learn.vo.QueryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CourseMapper {
    int countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    void pass(List list);

    void noPass(List list);

    int countByCondition(QueryCondition condition);

    List<Course> selectLimitObjects(QueryCondition condition);


    List<Course> getCoursesByUserId(Long id);

    List<Course> getRecommend();

    List<Course> selectAll();

    List<Course> getCourse(Course course);
}