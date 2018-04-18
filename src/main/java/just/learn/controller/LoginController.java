package just.learn.controller;

import just.learn.common.resp.ApiResult;
import just.learn.common.utils.CookieUtil;
import just.learn.common.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import just.learn.entity.User;
import just.learn.service.LoginServiceImpl;
import just.learn.service.jwt.AuthService;
import just.learn.vo.jwt.JwtAuthenticationRequest;
import just.learn.vo.jwt.JwtAuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.expiration}")
    private Long expiration;
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginServiceImpl loginService;
    @Autowired
    @Qualifier("authServiceImpl")
    private AuthService authService;

    @ApiOperation(value = "登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login( @RequestBody JwtAuthenticationRequest authenticationRequest,
                            HttpServletResponse response) throws UnsupportedEncodingException {
//        User user = loginService.login(number, password);
        final String token = authService.login(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());
        // Return the token
        addAuthCookie(response,token);
       return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @ApiOperation(value = "登出", notes = "用户登出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult logout(HttpServletResponse httpResponse) {
        CookieUtil.deleteCookie(tokenHeader, httpResponse);
        return ResultUtil.success("退出成功");
    }


    private void addAuthCookie(HttpServletResponse response,String token)throws UnsupportedEncodingException{
        CookieUtil.addCookie(response,tokenHeader,token,Math.toIntExact(expiration));
    }

}
