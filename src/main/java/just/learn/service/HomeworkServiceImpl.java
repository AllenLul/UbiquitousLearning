package just.learn.service;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.mapper.HomeworkMapper;
import just.learn.entity.Homework;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService{

@Resource
HomeworkMapper mapper;

@Override
public Homework insert(Homework homework){
if(homework==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
mapper.insertSelective(homework);
return homework;
}
@Override
public boolean delete(Integer id){
if(getById(id)==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.deleteByPrimaryKey(id) > 0;
}
@Override
public int update(Homework homework){
if(homework==null){
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
if(getById(homework.getId())==null){
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return mapper.updateByPrimaryKeySelective(homework);
}

@Override
public Homework getById(Integer id){
if (id == null) {
throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
}
Homework homework=mapper.selectByPrimaryKey(id);
if (homework == null) {
throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
}
return homework;
}
/*    @Override
public List<Homework> getAll() {
    return mapper.selectAll();
    }*/
}