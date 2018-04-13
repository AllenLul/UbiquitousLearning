package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Post;
import just.learn.mapper.PostMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    PostMapper mapper;

    @Override
    public Post insert(Post post) {
        if (post == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(post);
        return post;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(Post post) {
        if (post == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(post.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(post);
    }

    @Override
    public Post getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        Post post = mapper.selectByPrimaryKey(id);
        if (post == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return post;
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
        List<Post> list = mapper.selectLimitObjects(condition);
        result.setCurrentPage(condition.getCurrentPage());
        result.setTotalRows(count);
        result.setPageSize(condition.getPageSize());
        result.setItems(list);
        return result;
    }
/*    @Override
public List<Post> getAll() {
    return mapper.selectAll();
    }*/
}