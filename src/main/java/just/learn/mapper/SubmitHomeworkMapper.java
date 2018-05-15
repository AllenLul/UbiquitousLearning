package just.learn.mapper;

import just.learn.entity.SubmitHomework;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubmitHomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubmitHomework record);

    int insertSelective(SubmitHomework record);

    SubmitHomework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubmitHomework record);

    int updateByPrimaryKey(SubmitHomework record);

    List<SubmitHomework> selectSubmitHomeworkByHomeworkId(Integer homeworkId);

    SubmitHomework selectSubmitHomeworkByUserId(Integer userId);

    List<SubmitHomework> selectSubmitHomworkByObject(SubmitHomework submitHomework);
}