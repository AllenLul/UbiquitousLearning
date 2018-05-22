package just.learn.service;

import just.learn.entity.Video;
import just.learn.vo.QueryCondition;

import java.util.List;


public interface VideoService {


    public Video insert(Video video);

    public boolean delete(Integer id);

    public int update(Video video);

    public Video getById(Integer id);

    List<Video> findStudentsInfo(QueryCondition<Video> queryCondition);

    List<Video>  getVideo(Video video);
}