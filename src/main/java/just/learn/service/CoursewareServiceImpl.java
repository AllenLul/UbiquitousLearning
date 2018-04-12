package just.learn.service;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.mapper.CoursewareMapper;
import just.learn.entity.Courseware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CoursewareServiceImpl implements CoursewareService{

@Resource
CoursewareMapper mapper;

@Override
public Courseware insert(Courseware courseware){
if(courseware==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
mapper.insertSelective(courseware);
return courseware;
}
@Override
public boolean delete(Integer id){
if(getById(id)==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.deleteByPrimaryKey(id) > 0;
}
@Override
public int update(Courseware courseware){
if(courseware==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
if(getById(courseware.getId())==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.updateByPrimaryKeySelective(courseware);
}

@Override
public Courseware getById(Integer id){
if (id == null) {
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
Courseware courseware=mapper.selectByPrimaryKey(id);
if (courseware == null) {
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return courseware;
}
/*    @Override
public List<Courseware> getAll() {
    return mapper.selectAll();
    }*/
}