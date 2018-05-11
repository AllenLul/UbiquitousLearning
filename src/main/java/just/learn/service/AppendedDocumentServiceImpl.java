package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.AppendedDocument;
import just.learn.mapper.AppendedDocumentMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppendedDocumentServiceImpl implements AppendedDocumentService {

    @Resource
    AppendedDocumentMapper mapper;

    @Override
    public AppendedDocument insert(AppendedDocument appendedDocument) {
        if (appendedDocument == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(appendedDocument);
        return appendedDocument;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(AppendedDocument appendedDocument) {
        if (appendedDocument == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(appendedDocument.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(appendedDocument);
    }

    @Override
    public AppendedDocument getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        AppendedDocument appendedDocument = mapper.selectByPrimaryKey(id);
        if (appendedDocument == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return appendedDocument;
    }


}