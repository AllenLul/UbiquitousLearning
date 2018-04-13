package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public User insert(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(user);
        return user;
    }

    @Override
    public boolean delete(Long id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(User user) {
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(user.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getById(Long id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        User user = mapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return user;
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
        List<User> list = mapper.selectLimitObjects(condition);
        result.setCurrentPage(condition.getCurrentPage());
        result.setTotalRows(count);
        result.setPageSize(condition.getPageSize());
        result.setItems(list);
        return result;
    }
/*    @Override
public List<User> getAll() {
    return mapper.selectAll();
    }*/
}