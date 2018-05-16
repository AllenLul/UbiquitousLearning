package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Video;
import just.learn.mapper.VideoMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    VideoMapper mapper;

    @Override
    public Video insert(Video video) {
        if (video == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(video);
        return video;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(Video video) {
        if (video == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(video.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(video);
    }

    @Override
    public Video getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        Video video = mapper.selectByPrimaryKey(id);
        if (video == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        video.setTimes(video.getTimes()+1);
        mapper.updateByPrimaryKeySelective(video);
        return video;
    }

    @Override
    public List<Video> findStudentsInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }

    @Override
    public List<Video> getVideo(Video video) {
        if (video == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.getVideo(video);
    }


}