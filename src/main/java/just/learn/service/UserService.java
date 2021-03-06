package just.learn.service;

import just.learn.entity.PageQueryBean;
import just.learn.entity.User;
import just.learn.vo.QueryCondition;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {


    public User insert(User user);

    public boolean delete(Integer id);

    public User update(User user);

    public User getById(Integer id);



    User getByNumber(String number);

    List<User> findStudentsInfo(QueryCondition<User> queryCondition);

    List<User> getUser(User user);

    String uploadUserPic(MultipartFile file) throws IOException;
}