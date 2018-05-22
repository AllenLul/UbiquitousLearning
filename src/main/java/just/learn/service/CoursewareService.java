package just.learn.service;

import just.learn.entity.Courseware;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface CoursewareService {


    public Courseware insert(Courseware courseware);

    public boolean delete(Integer id);

    public int update(Courseware courseware);

    public Courseware getById(Integer id);

    List<Courseware> findStudentsInfo(QueryCondition<Courseware> queryCondition);

    List<Courseware> getCourseware(Courseware courseware);
}