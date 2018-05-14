package just.learn.mapper;

import java.util.List;
import just.learn.entity.Courseware;
import just.learn.entity.CoursewareExample;
import org.apache.ibatis.annotations.Param;

public interface CoursewareMapper {
    int countByExample(CoursewareExample example);

    int deleteByExample(CoursewareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Courseware record);

    int insertSelective(Courseware record);

    List<Courseware> selectByExample(CoursewareExample example);

    Courseware selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Courseware record, @Param("example") CoursewareExample example);

    int updateByExample(@Param("record") Courseware record, @Param("example") CoursewareExample example);

    int updateByPrimaryKeySelective(Courseware record);

    int updateByPrimaryKey(Courseware record);

    void pass(List<Courseware> pass);

    void noPass(List<Courseware> noPass);

    List<Courseware> selectAll();

    List<Courseware> getCourseware(Courseware courseware);
}