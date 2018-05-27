package just.learn.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.User;
import just.learn.entity.UserElement;
import just.learn.service.AdminService;
import just.learn.service.UserService;
import just.learn.vo.ReviewVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.controller
 * @Description: TODO
 * @date 2018/4/12 20:20
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController{

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @ApiOperation(value = "导入用户信息", notes = "导入用户信息")
    @PostMapping(value = "/importUser", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ApiResult importUser(@ApiParam(value = "上传的文件", required = true) MultipartFile file) throws Exception {
      /*  UserElement ue= getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }*/
        return ResultUtil.success("导入成功", adminService.importInfo(file));
    }

    @ApiOperation(value = "管理员审核", notes = "管理员审核 handletype只能是1或者2 id表示课程或者课件的id")
    @ApiImplicitParam(name = "reviewVO", value = "审核对象（type course或者courseware）", required = true, dataType = "ReviewVO")
    @PostMapping(value = "/review")
    public ApiResult review(@RequestBody ReviewVO reviewVO) throws Exception {
      /*  UserElement ue= getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }*/
        adminService.review(reviewVO);
        return ResultUtil.success("success");
    }

    @ApiOperation(value = "添加", notes = "添加对象")
    @ApiImplicitParam(name = "user", value = "实体对象", required = true, dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody User user) {
        /*UserElement ue= getCurrentUser();
        if(RoleEnum.STUDENT.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }*/
        user.setRole(RoleEnum.MANAGER.getValue());
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userService.insert(user);
        return ResultUtil.success("增加成功");
    }
    @ApiOperation(value = "管理员导出用户信息", notes = "管理员导出用户信息")

    @GetMapping(value = "/exportUserInfo")
    public ApiResult exportUserInfo(HttpServletResponse response) throws IOException {
         /*UserElement ue= getCurrentUser();
        if(RoleEnum.STUDENT.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }*/
         adminService.exportUserInfo(response);
         return null;
    }


}
