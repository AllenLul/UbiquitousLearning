package just.learn.mapper;

import just.learn.entity.Homework;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKey(Homework record);

    int countByCondition(QueryCondition condition);

    List<Homework> selectLimitObjects(QueryCondition condition);
}