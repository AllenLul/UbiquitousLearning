package just.learn.service;
import just.learn.entity.Homework;

public interface HomeworkService{


public Homework insert(Homework homework);

public boolean delete(Integer id);

public int update(Homework homework);

public Homework getById(Integer id);

//public   List<Homework> getAll();
}