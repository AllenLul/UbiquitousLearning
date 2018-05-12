package just.learn.controller;

import just.learn.common.resp.ApiResult;
import just.learn.common.utils.CookieUtil;
import just.learn.common.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import just.learn.service.LoginServiceImpl;
import just.learn.vo.LoginElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn.controller
 * @Description: TODO
 * @date 2018/4/11 16:10
 */
@RestController
@RequestMapping("user")
public class LoginController {

    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginServiceImpl loginService;


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestBody LoginElement loginElement) throws IOException {
        String token=loginService.login(loginElement.getUsername(),loginElement.getPassword());
        return ResultUtil.success("token",token);
    }




}
