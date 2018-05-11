package just.learn.service;

import just.learn.entity.Course;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface CourseService {


    public Course insert(Course course);

    public boolean delete(Integer id);

    public int update(Course course);

    public Course getById(Integer id);

    PageQueryBean getLimitObjects(QueryCondition condition);


    List<Course> getRecommend();
}