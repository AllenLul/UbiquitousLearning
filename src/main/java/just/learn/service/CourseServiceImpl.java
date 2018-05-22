package just.learn.service;

import com.github.pagehelper.PageHelper;
import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.entity.Course;
import just.learn.mapper.CourseMapper;
import org.springframework.stereotype.Service;
import just.learn.vo.QueryCondition;
import just.learn.entity.PageQueryBean;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper mapper;

    @Override
    public Course insert(Course course) {
        if (course == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        mapper.insertSelective(course);
        return course;
    }

    @Override
    public boolean delete(Integer id) {
        if (getById(id) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public int update(Course course) {
        if (course == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        if (getById(course.getId()) == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return mapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public Course getById(Integer id) {
        if (id == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        Course course = mapper.selectByPrimaryKey(id);
        if (course == null) {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
        return course;
    }

    @Override
    public List<Course> getRecommend() {
        return mapper.getRecommend();
    }

    @Override
    public List<Course> findStudentsInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }

    @Override
    public List<Course> getCourse(Course course) {
        return mapper.getCourse(course);
    }

    @Override
    public String uploadCoursePic(MultipartFile file) throws IOException {
        String path="e:\\img\\course\\"+file.getOriginalFilename();
        file.transferTo(new File(path));
        return path;
    }


}