package just.learn.controller;

import io.swagger.annotations.ApiParam;
import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.User;
import just.learn.entity.UserElement;
import just.learn.service.UserService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import just.learn.vo.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import just.learn.entity.PageQueryBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    private User currentUser;

    public UserController() {
        currentUser = new User();
        currentUser.setRole("admin");
    }

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    /*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
    List<User> users = this.userService.getAll();
    return ResultUtil.success("查询所有对象成功",users);
    }*/
    @ApiOperation(value = "删除", notes = "根据主键删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "Integer")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ApiResult delete(@PathVariable Integer id) {
        UserElement ue= getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "添加", notes = "添加对象")
    @ApiImplicitParam(name = "user", value = "实体对象", required = true, dataType = "User")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody User user) {
        UserElement ue= getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        userService.insert(user);
        return ResultUtil.success("增加成功");
    }

    @ApiOperation(value = "更新", notes = "更新对象")
    @ApiImplicitParam(name = "user", value = "实体对象", required = true, dataType = "User")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult update(@RequestBody User user) {
        //UserElement ue= getCurrentUser();

        return ResultUtil.success("更新成功",userService.update(user));
    }

    @ApiOperation(value = "查询", notes = "根据主键查询对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getById(@PathVariable Integer id) {
        //UserElement ue= getCurrentUser();
        User user=this.userService.getById(id);
        user.setPassword(null);
        return ResultUtil.success("查询成功", user);
    }
    @ApiOperation(value = "根据编号查询对象", notes = "根据编号查询对象")
    @ApiImplicitParam(paramType = "path", name = "number", value = "编号",
            required = true, dataType = "String")
    @RequestMapping(value = "/getByNumber/{number}", method = RequestMethod.GET)
    public ApiResult getByNumber(@PathVariable String number) {
        //UserElement ue= getCurrentUser();
        User user=this.userService.getByNumber(number);
        user.setPassword(null);
        return ResultUtil.success("查询成功", user);
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @PostMapping(value = "/findLimitObjects")
    public ApiResult getLimitObjects(@RequestBody QueryCondition<User> queryCondition) {

        return ResultUtil.success("查询成功", userService.findStudentsInfo(queryCondition));
    }


    @ApiOperation(value = "上传头像", notes = "上传头像")
    @PostMapping(value = "/uploadUserPic", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ApiResult uploadUserPic(@ApiParam(value = "上传头像", required = true) MultipartFile file) throws IOException {
        //UserElement ue= getCurrentUser();
        String url= userService.uploadUserPic(file);
        return ResultUtil.success("上传成功",url);
    }

}