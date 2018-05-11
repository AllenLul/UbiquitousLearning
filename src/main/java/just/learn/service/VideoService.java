package just.learn.service;

import just.learn.entity.Video;


public interface VideoService {


    public Video insert(Video video);

    public boolean delete(Integer id);

    public int update(Video video);

    public Video getById(Integer id);

}