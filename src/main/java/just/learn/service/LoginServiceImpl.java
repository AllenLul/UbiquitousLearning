
package just.learn.service;



import just.learn.cache.CommonCacheUtil;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.User;
import just.learn.entity.UserElement;
import just.learn.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommonCacheUtil cacheUtil;
    @Override
    public String login(String number, String password) {

        //查找用户是否存在
        User user=userMapper.selectByNumberAndPassword(number,password);
        if(user==null){
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        String token= generateToken(number);//生成token
        UserElement ue=new UserElement();
        ue.setToken(token);
        ue.setUserNumber(number);
        ue.setRole(user.getRole());//管理员权限直接在数据库去修改，默认都是普通用户
        cacheUtil.putTokenWhenLogin(ue);//把token 存入缓存
        return token;
    }
    /**
     * 生成token
     * @param number
     * @return
     */
    private String generateToken(String number) {
        String source = number +":" + System.currentTimeMillis();
        return DigestUtils.md5Hex(source);
    }
}


