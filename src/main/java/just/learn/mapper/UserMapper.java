package just.learn.mapper;

import just.learn.entity.User;
import just.learn.vo.QueryCondition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String number, String password);

    List<User> selectLimitObjects(QueryCondition condition);

    int countByCondition(QueryCondition condition);


    List<User> getUsersByCourseId(Integer id);
}