package just.learn.service;

import just.learn.entity.User;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/12 10:44
 */
public interface LoginService {

    User login(String name, String password);
}
