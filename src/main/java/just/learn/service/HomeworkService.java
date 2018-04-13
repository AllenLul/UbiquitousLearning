package just.learn.service;

import just.learn.entity.Homework;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

public interface HomeworkService {


    public Homework insert(Homework homework);

    public boolean delete(Integer id);

    public int update(Homework homework);

    public Homework getById(Integer id);

    PageQueryBean getLimitObjects(QueryCondition condition);
//public   List<Homework> getAll();
}