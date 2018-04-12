package just.learn.mapper;

import just.learn.entity.Video;
import just.learn.vo.QueryCondition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    int countByCondition(QueryCondition condition);

    List<Video> selectLimitObjects(QueryCondition condition);
}