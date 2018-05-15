package just.learn.mapper;

import just.learn.entity.AppendedDocument;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AppendedDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppendedDocument record);

    int insertSelective(AppendedDocument record);

    AppendedDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppendedDocument record);

    int updateByPrimaryKey(AppendedDocument record);
    List<AppendedDocument> selectAll();
}