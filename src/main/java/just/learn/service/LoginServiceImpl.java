package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/12 10:46
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper mapper;
    @Override
    public User login(String name, String password) {
        if(name==null||password==null){
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user=mapper.login(name,password);
        if (user==null){
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
    }
}
