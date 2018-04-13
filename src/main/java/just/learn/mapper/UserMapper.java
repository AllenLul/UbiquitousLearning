package just.learn.mapper;

import just.learn.entity.User;
import just.learn.vo.QueryCondition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String name, String password);

    int countByCondition(QueryCondition condition);

    List<User> selectLimitObjects(QueryCondition condition);
}