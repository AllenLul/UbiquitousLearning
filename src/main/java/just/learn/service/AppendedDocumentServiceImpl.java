package just.learn.service;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.mapper.AppendedDocumentMapper;
import just.learn.entity.AppendedDocument;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;
import javax.annotation.Resource;
import java.util.List;

@Service
public class AppendedDocumentServiceImpl implements AppendedDocumentService{

@Resource
AppendedDocumentMapper mapper;

@Override
public AppendedDocument insert(AppendedDocument appendedDocument){
if(appendedDocument==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
mapper.insertSelective(appendedDocument);
return appendedDocument;
}
@Override
public boolean delete(Integer id){
if(getById(id)==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.deleteByPrimaryKey(id) > 0;
}
@Override
public int update(AppendedDocument appendedDocument){
if(appendedDocument==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
if(getById(appendedDocument.getId())==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.updateByPrimaryKeySelective(appendedDocument);
}

@Override
public AppendedDocument getById(Integer id){
if (id == null) {
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
AppendedDocument appendedDocument=mapper.selectByPrimaryKey(id);
if (appendedDocument == null) {
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return appendedDocument;
}
@Override
public PageQueryBean getLimitObjects(QueryCondition condition) {
//根据条件查询count记录数
int count=mapper.countByCondition(condition);
//如果有记录才去查询分页数据
if (count<0){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
PageQueryBean result=new PageQueryBean();
List<AppendedDocument> list=mapper.selectLimitObjects(condition);
    result.setCurrentPage(condition.getCurrentPage());
    result.setTotalRows(count);
    result.setPageSize(condition.getPageSize());
    result.setItems(list);
    return result;
    }
/*    @Override
public List<AppendedDocument> getAll() {
    return mapper.selectAll();
    }*/
}