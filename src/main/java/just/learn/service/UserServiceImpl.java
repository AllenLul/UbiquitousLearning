package just.learn.service;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.mapper.UserMapper;
import just.learn.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

@Resource
UserMapper mapper;

@Override
public User insert(User user){
if(user==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
mapper.insertSelective(user);
return user;
}
@Override
public boolean delete(Integer id){
if(getById(id)==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.deleteByPrimaryKey(id) > 0;
}
@Override
public int update(User user){
if(user==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
if(getById(user.getId())==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.updateByPrimaryKeySelective(user);
}

@Override
public User getById(Integer id){
if (id == null) {
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
User user=mapper.selectByPrimaryKey(id);
if (user == null) {
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return user;
}
/*    @Override
public List<User> getAll() {
    return mapper.selectAll();
    }*/
}