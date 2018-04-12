package just.learn.service;
import just.learn.entity.User;

public interface UserService{


public User insert(User user);

public boolean delete(Integer id);

public int update(User user);

public User getById(Integer id);

//public   List<User> getAll();
}