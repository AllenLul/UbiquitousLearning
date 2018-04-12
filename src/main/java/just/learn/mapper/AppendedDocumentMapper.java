package just.learn.mapper;

import just.learn.entity.AppendedDocument;

public interface AppendedDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppendedDocument record);

    int insertSelective(AppendedDocument record);

    AppendedDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppendedDocument record);

    int updateByPrimaryKey(AppendedDocument record);
}