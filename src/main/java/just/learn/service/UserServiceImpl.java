package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public User insert(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(user);
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(user.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user = mapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
    }



    @Override
    public User getByNumber(String number) {
        if (number == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user = mapper.selectByNumber(number);
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
    }

    @Override
    public List<User> findStudentsInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }

    @Override
    public List<User> getUser(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        return mapper.getUser(user);
    }
/*    @Override
public List<User> getAll() {
    return mapper.selectAll();
    }*/
}