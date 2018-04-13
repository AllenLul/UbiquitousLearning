
package just.learn.service;


import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper mapper;

    @Override
    public User login(String number, String password) {
        if (number == null || password == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user = mapper.login(number, password);
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
    }
}


