package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Course;
import just.learn.entity.User;
import just.learn.mapper.CourseMapper;
import just.learn.mapper.UserCourseMapper;
import just.learn.entity.UserCourse;
import just.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Resource
    UserCourseMapper mapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;
    @Override
    public UserCourse insert(UserCourse userCourse) {
        if (userCourse == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(userCourse);
        return userCourse;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(UserCourse userCourse) {
        if (userCourse == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(userCourse.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(userCourse);
    }

    @Override
    public UserCourse getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        UserCourse userCourse = mapper.selectByPrimaryKey(id);
        if (userCourse == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return userCourse;
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
        List<UserCourse> list = mapper.selectLimitObjects(condition);
        result.setCurrentPage(condition.getCurrentPage());
        result.setTotalRows(count);
        result.setPageSize(condition.getPageSize());
        result.setItems(list);
        return result;
    }

    @Override
    @Transactional
    public void deleteUserCourses(UserCourse[] userCourses) {
        if(userCourses==null||userCourses.length==0){
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        for (UserCourse u: userCourses) {
            mapper.deleteUserCourseByObject(u);
        }

    }


    @Override
    public List<Course> getCoursesById(Long id) {
        if(id==null){
            throw  new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }

        return courseMapper.getCoursesByUserId(id);
    }

    @Override
    public List<User>  getUsersByCourseId(Integer id) {
        if(id==null){
            throw  new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }

        return userMapper.getUsersByCourseId(id);
    }
/*    @Override
public List<UserCourse> getAll() {
    return mapper.selectAll();
    }*/
}