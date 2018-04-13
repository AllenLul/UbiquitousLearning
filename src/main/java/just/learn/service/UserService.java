package just.learn.service;

import just.learn.entity.PageQueryBean;
import just.learn.entity.User;
import just.learn.vo.QueryCondition;

public interface UserService {


    public User insert(User user);

    public boolean delete(Long id);

    public int update(User user);

    public User getById(Long id);

    PageQueryBean getLimitObjects(QueryCondition condition);
//public   List<User> getAll();
}