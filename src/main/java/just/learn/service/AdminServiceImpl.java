package just.learn.service;

import just.learn.common.utils.ExcelUtil;
import just.learn.entity.User;
import just.learn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    @Transactional
    @Override
    public String importInfo(MultipartFile file) throws Exception {
        List<List<Map<String, String>>> outer= ExcelUtil.readExcelWithTitle(file);
        List<Map<String,String>> result=outer.get(0);
        for (Map<String,String> map:result) {
            User user=new User();
            user.setHeadpic(map.get("headPic"));
            user.setDepartment(map.get("department"));
            user.setGender(map.get("gender").substring(0,1));
            user.setPassword(map.get("password"));
            user.setName(map.get("name"));
            user.setNickname(map.get("nickname"));
            user.setNote(map.get("note"));
            user.setRole(map.get("role").substring(0,1));
            user.setStuNum(map.get("stuNum"));
            user.setTeaNum(map.get("teaNum"));
            user.setPhone(map.get("phone"));
            userMapper.insertSelective(user);
        }
        return "success";
    }
}
