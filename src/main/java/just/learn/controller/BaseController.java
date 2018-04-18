package just.learn.controller;

import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import just.learn.common.utils.WebUtils;
import just.learn.service.jwt.JwtUser;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn.controller
 * @Description: TODO
 * @date 2018/4/4 16:25
 */
@RestController
@RequestMapping("/")
public class BaseController {


    //处理日期
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    void isManager(){
        boolean flag=false;
        JwtUser jwtUser= WebUtils.getCurrentUser();
        List roles= (List) jwtUser.getAuthorities();
        for (Object role: roles) {
            if(RoleEnum.MANAGER.getValue().equals(role.toString())){
                    flag=true;
            }
        }
        if(!flag){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }

    }
    void isManagerOrTeacher(){
        boolean flag=false;
        JwtUser jwtUser= WebUtils.getCurrentUser();
        List roles= (List) jwtUser.getAuthorities();
        for (Object role: roles) {
            if(RoleEnum.MANAGER.getValue().equals(role.toString())||RoleEnum.TEACHER.getValue().equals(role.toString())){
                flag=true;
            }
        }
        if(!flag){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }

    }
}
