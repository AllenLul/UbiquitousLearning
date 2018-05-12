package just.learn.mapper;

import java.util.List;
import just.learn.entity.AppendedDocument;
import just.learn.entity.AppendedDocumentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface AppendedDocumentMapper {
    int countByExample(AppendedDocumentExample example);

    int deleteByExample(AppendedDocumentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppendedDocument record);

    int insertSelective(AppendedDocument record);

    List<AppendedDocument> selectByExample(AppendedDocumentExample example);

    AppendedDocument selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppendedDocument record, @Param("example") AppendedDocumentExample example);

    int updateByExample(@Param("record") AppendedDocument record, @Param("example") AppendedDocumentExample example);

    int updateByPrimaryKeySelective(AppendedDocument record);

    int updateByPrimaryKey(AppendedDocument record);

    List<AppendedDocument> selectAll();
}