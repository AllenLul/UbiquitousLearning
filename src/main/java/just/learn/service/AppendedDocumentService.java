package just.learn.service;
import just.learn.entity.AppendedDocument;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;
public interface AppendedDocumentService{


public AppendedDocument insert(AppendedDocument appendedDocument);

public boolean delete(Integer id);

public int update(AppendedDocument appendedDocument);

public AppendedDocument getById(Integer id);
PageQueryBean getLimitObjects(QueryCondition condition);
//public   List<AppendedDocument> getAll();
}