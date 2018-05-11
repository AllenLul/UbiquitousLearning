package just.learn.service;
import just.learn.entity.Course;
import just.learn.entity.User;
import just.learn.entity.UserCourse;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface UserCourseService{


public UserCourse insert(UserCourse userCourse);

public boolean delete(Integer id);

public int update(UserCourse userCourse);

public UserCourse getById(Integer id);

    void deleteUserCourses(UserCourse[] userCourses);


    List<Course> getCoursesById(Long id);

    List<User> getUsersByCourseId(Integer id);

}