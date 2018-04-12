package just.learn.service;
import just.learn.entity.Courseware;

public interface CoursewareService{


public Courseware insert(Courseware courseware);

public boolean delete(Integer id);

public int update(Courseware courseware);

public Courseware getById(Integer id);

//public   List<Courseware> getAll();
}