package just.learn.service;

import just.learn.entity.PageQueryBean;
import just.learn.entity.User;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface UserService {


    public User insert(User user);

    public boolean delete(Integer id);

    public int update(User user);

    public User getById(Integer id);



    User getByNumber(String number);

    List<User> findStudentsInfo(Integer pageNum, Integer pageSize);
}