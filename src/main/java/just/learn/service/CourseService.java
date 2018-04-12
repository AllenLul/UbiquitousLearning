package just.learn.service;
import just.learn.entity.Course;

public interface CourseService{


public Course insert(Course course);

public boolean delete(Integer id);

public int update(Course course);

public Course getById(Integer id);

//public   List<Course> getAll();
}