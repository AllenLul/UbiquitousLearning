package just.learn.mapper;

import just.learn.entity.AppendedDocument;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface AppendedDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppendedDocument record);

    int insertSelective(AppendedDocument record);

    AppendedDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppendedDocument record);

    int updateByPrimaryKey(AppendedDocument record);

    int countByCondition(QueryCondition condition);

    List<AppendedDocument> selectLimitObjects(QueryCondition condition);
}