package just.learn.service.jwt;

import just.learn.common.enums.RoleEnum;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by yt on 2017/5/1.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Autowired
    public JwtUserDetailsServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        /**
         * TODO
         * */
       User user = userMapper.selectByNumber(number);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with number '%s'.", number));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
