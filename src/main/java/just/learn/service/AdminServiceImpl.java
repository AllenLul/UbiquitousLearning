package just.learn.service;

import just.learn.common.enums.ResultEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.utils.ExcelUtil;
import just.learn.entity.User;
import just.learn.mapper.CourseMapper;
import just.learn.mapper.CoursewareMapper;
import just.learn.mapper.UserMapper;
import just.learn.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
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
        if(outer.isEmpty()){
            throw new CustomException(ResultEnum.EXECIL_NULL);
        }

        List<Map<String, String>> result = outer.get(0);
        if(result.isEmpty()){
            throw new CustomException(ResultEnum.EXECIL_NULL);
        }
        BCryptPasswordEncoder util = new BCryptPasswordEncoder();
        for (Map<String, String> map : result) {
            User user = new User();
            String number=getNumber(map.get("编号"));
            user.setNumber(getNumber(map.get("编号")));
            user.setHeadpic(map.get("头像路径"));
            user.setDepartment(map.get("学院"));
            user.setGender(map.get("性别"));
            user.setPassword(util.encode(map.get("密码")));
            user.setName(map.get("姓名"));
            user.setNickname(map.get("昵称"));
            user.setNote(map.get("说明"));
            user.setRole(map.get("角色"));
            user.setPhone(getNumber(map.get("手机"))+"");
            if(userMapper.selectByNumber(number)==null){
                userMapper.insertSelective(user);
            }else {
                System.out.println("用户已存在");
                userMapper.updateByPrimaryKeySelective(user);
            }

        }
        return "success";
    }

    public static String getNumber(String value){
        BigDecimal bd1 = new BigDecimal(Double.parseDouble(value));
        return bd1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString().split("\\.")[0];
    }
    @Override
    @Transactional
    public void review(ReviewVO reviewVO) {
        if (reviewVO == null) {
            throw new CustomException(ResultEnum.OBJECT_NULL_ERROR);
        }
        List pass = new ArrayList();
        List  noPass = new ArrayList();
        for (int i = 0; i < reviewVO.getReviews().length; i++) {
            if ("1".equals(reviewVO.getReviews()[i].getHandleType())) {
                pass.add(reviewVO.getReviews()[i]);
            } else if ("2".equals(reviewVO.getReviews()[i].getHandleType())) {
                noPass.add(reviewVO.getReviews()[i]);
            }
        }
        if("course".equals(reviewVO.getType())){
            if(!pass.isEmpty()){
                courseMapper.pass(pass);
            }
            if(!noPass.isEmpty()){
                courseMapper.noPass(noPass);
            }
        }else if("courseware".equals(reviewVO.getType())){
            if(!pass.isEmpty()){
                coursewareMapper.pass(pass);
            }
            if(!noPass.isEmpty()){
                coursewareMapper.noPass(noPass);
            }
        }else {
            throw new CustomException(ResultEnum.TYPE_ERROR);
        }
    }

}
