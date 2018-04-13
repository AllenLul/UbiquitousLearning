package just.learn.service;

import just.learn.entity.Video;
import just.learn.entity.PageQueryBean;
import just.learn.vo.QueryCondition;

public interface VideoService {


    public Video insert(Video video);

    public boolean delete(Integer id);

    public int update(Video video);

    public Video getById(Integer id);

    PageQueryBean getLimitObjects(QueryCondition condition);
//public   List<Video> getAll();
}