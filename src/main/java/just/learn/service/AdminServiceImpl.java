package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.ExcelUtil;
import just.learn.entity.Course;
import just.learn.entity.Courseware;
import just.learn.entity.User;
import just.learn.mapper.CourseMapper;
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
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;

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

    @Override
    public void review(String type, List list) {
        if (type == null || list == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        List pass = new ArrayList();
        List noPass = new ArrayList();

        if ("course".equals(type)) {
            for (int i = 0; i < list.size(); i++) {
                Course course = (Course) list.get(i);
                if ("1".equals(course.getHandleType())) {
                    courseMapper.pass(pass);
                } else if ("2".equals(course.getHandleType())) {
                    courseMapper.noPass(noPass);
                } else {
                    return;
                }
            }

        } else if ("courseware".equals(type)) {
            for (int i = 0; i < list.size(); i++) {
                Courseware courseware = (Courseware) list.get(i);
                if ("1".equals(courseware.getHandleType())) {
                    courseMapper.pass(pass);
                } else if ("2".equals(courseware.getHandleType())) {
                    courseMapper.noPass(noPass);
                } else {
                    return;
                }
            }
        } else {
            throw new CustomException(ResultEnum.OBJECT_FIND_NULL);
        }
    }
}
