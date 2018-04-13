package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.ExcelUtil;
import just.learn.entity.Course;
import just.learn.entity.Courseware;
import just.learn.entity.User;
import just.learn.mapper.CourseMapper;
import just.learn.mapper.CoursewareMapper;
import just.learn.mapper.PostMapper;
import just.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.service
 * @Description: TODO
 * @date 2018/4/12 20:23
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CoursewareMapper coursewareMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public String importInfo(MultipartFile file) throws Exception {
        List<List<Map<String, String>>> outer = ExcelUtil.readExcelWithTitle(file);
        List<Map<String, String>> result = outer.get(0);
        for (Map<String, String> map : result) {
            User user = new User();
            user.setHeadpic(map.get("headPic"));
            user.setDepartment(map.get("department"));
            user.setGender(map.get("gender").substring(0, 1));
            user.setPassword(map.get("password"));
            user.setName(map.get("name"));
            user.setNickname(map.get("nickname"));
            user.setNote(map.get("note"));
            user.setRole(map.get("role").substring(0, 1));
            user.setNumber(map.get("number"));
            user.setPhone(map.get("phone"));
            userMapper.insertSelective(user);
        }
        return "success";
    }
    @Transactional
    @Override
    public void reviewCourse(Course courses[]) {
        if (courses == null||courses.length==0) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        List<Course> pass = new ArrayList<Course>();
        List<Course>  noPass = new ArrayList<Course>();

        for (int i = 0; i < courses.length; i++) {
            Course course = (Course) courses[i];
            if ("1".equals(course.getHandleType())) {
                pass.add(course);
            } else if ("2".equals(course.getHandleType())) {
                noPass.add(course);
            }
        }
        if(!pass.isEmpty()){
            courseMapper.pass(pass);
        }
        if(!noPass.isEmpty()){
            courseMapper.noPass(noPass);
        }


    }

    @Override
    @Transactional
    public void reviewCourseware(Courseware[] coursewares) {
        if (coursewares == null||coursewares.length==0) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        List<Courseware> pass = new ArrayList<Courseware>();
        List<Courseware>  noPass = new ArrayList<Courseware>();

        for (int i = 0; i < coursewares.length; i++) {
            Courseware courseware = (Courseware) coursewares[i];
            if ("1".equals(courseware.getHandleType())) {
                pass.add(courseware);
            } else if ("2".equals(courseware.getHandleType())) {
                noPass.add(courseware);
            }
        }
        if(!pass.isEmpty()){
            coursewareMapper.pass(pass);
        }
        if(!noPass.isEmpty()){
            coursewareMapper.noPass(noPass);
        }

    }
}
