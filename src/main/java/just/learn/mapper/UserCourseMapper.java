package just.learn.mapper;

import just.learn.entity.UserCourse;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface UserCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);

    int countByCondition(QueryCondition condition);

    List<UserCourse> selectLimitObjects(QueryCondition condition);

    int deleteUserCourseByObject(UserCourse u);
}