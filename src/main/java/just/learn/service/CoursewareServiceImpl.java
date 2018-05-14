package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Courseware;
import just.learn.mapper.CoursewareMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CoursewareServiceImpl implements CoursewareService {

    @Resource
    CoursewareMapper mapper;

    @Override
    public Courseware insert(Courseware courseware) {
        if (courseware == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(courseware);
        return courseware;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(Courseware courseware) {
        if (courseware == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(courseware.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(courseware);
    }

    @Override
    public Courseware getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        Courseware courseware = mapper.selectByPrimaryKey(id);
        if (courseware == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return courseware;
    }

    @Override
    public List<Courseware> findStudentsInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }

    @Override
    public List<Courseware> getCourseware(Courseware courseware) {
        if (courseware == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.getCourseware(courseware);
    }


}