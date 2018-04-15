package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Homework;
import just.learn.mapper.HomeworkMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Resource
    HomeworkMapper mapper;

    @Override
    public Homework insert(Homework homework) {
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(homework);
        return homework;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(Homework homework) {
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(homework.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(homework);
    }

    @Override
    public Homework getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        Homework homework = mapper.selectByPrimaryKey(id);
        if (homework == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return homework;
    }

    @Override
    public PageQueryBean getLimitObjects(QueryCondition condition) {
//根据条件查询count记录数
        int count = mapper.countByCondition(condition);
//如果有记录才去查询分页数据
        if (count < 0) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        PageQueryBean result = new PageQueryBean();
        List<Homework> list = mapper.selectLimitObjects(condition);
        result.setCurrentPage(condition.getCurrentPage());
        result.setTotalRows(count);
        result.setPageSize(condition.getPageSize());
        result.setItems(list);
        return result;
    }
/*    @Override
public List<Homework> getAll() {
    return mapper.selectAll();
    }*/
}