package just.learn.controller;

import just.learn.common.resp.ApiResult;
import just.learn.common.utils.CookieUtil;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import just.learn.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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

    @ApiOperation(value = "登录", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", required = true, dataType =
                    "String")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestParam String name, @RequestParam String password, HttpServletResponse httpResponse) throws UnsupportedEncodingException {
        User user = loginService.login(name, password);
        String jsonStr=CookieUtil.transformJSONString(CookieUtil.ObjectTransformMap(user));
        jsonStr=jsonStr.replaceAll(" ","");
        jsonStr=jsonStr.replaceAll("\"","'");
        jsonStr=jsonStr.replaceAll(",","#");
        CookieUtil.addCookie(httpResponse,"user",jsonStr,259200);
        System.out.println(jsonStr);
        return ResultUtil.success("登录成功");
    }

    @ApiOperation(value = "登出", notes = "用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult logout(HttpServletResponse httpResponse) {
        CookieUtil.deleteCookie("user", httpResponse);
        return ResultUtil.success("退出成功");
    }

}
