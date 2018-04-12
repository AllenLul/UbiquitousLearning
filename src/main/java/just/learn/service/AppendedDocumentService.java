package just.learn.service;
import just.learn.entity.AppendedDocument;

public interface AppendedDocumentService{


public AppendedDocument insert(AppendedDocument appendedDocument);

public boolean delete(Integer id);

public int update(AppendedDocument appendedDocument);

public AppendedDocument getById(Integer id);

//public   List<AppendedDocument> getAll();
}