package just.learn.service;

import just.learn.entity.Post;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

import java.util.List;

public interface PostService {


    public Post insert(Post post);

    public boolean delete(Integer id);

    public int update(Post post);

    public Post getById(Integer id);


    List<Post> findStudentsInfo(Integer pageNum, Integer pageSize);
}