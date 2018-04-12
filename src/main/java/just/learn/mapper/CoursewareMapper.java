package just.learn.mapper;

import just.learn.entity.Courseware;
import org.springframework.stereotype.Component;

@Component
public interface CoursewareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Courseware record);

    int insertSelective(Courseware record);

    Courseware selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Courseware record);

    int updateByPrimaryKey(Courseware record);
}