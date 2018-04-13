package just.learn.mapper;

import just.learn.entity.Courseware;
import just.learn.vo.QueryCondition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoursewareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Courseware record);

    int insertSelective(Courseware record);

    Courseware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Courseware record);

    int updateByPrimaryKey(Courseware record);

    int countByCondition(QueryCondition condition);

    List<Courseware> selectLimitObjects(QueryCondition condition);

    void pass(List<Courseware> pass);

    void noPass(List<Courseware> noPass);
}