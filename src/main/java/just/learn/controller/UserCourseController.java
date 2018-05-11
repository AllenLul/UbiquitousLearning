package just.learn.controller;

import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.UserCourse;
import just.learn.entity.UserElement;
import just.learn.service.UserCourseService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import just.learn.vo.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import just.learn.entity.PageQueryBean;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/userCourse")
public class UserCourseController extends BaseController{

    @Autowired
    @Qualifier("userCourseServiceImpl")
    private UserCourseService userCourseService;


    /*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
    List<UserCourse> userCourses = this.userCourseService.getAll();
    return ResultUtil.success("查询所有对象成功",userCourses);
    }*/
    @ApiOperation(value = "学生取消选课", notes = "学生取消选课")
    @ApiImplicitParam(name = "userCourses", value = "实体对象", required = true, dataType = "List")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ApiResult delete(@RequestBody UserCourse[] userCourses) {
        UserElement ue= getCurrentUser();
        userCourseService.deleteUserCourses(userCourses);
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "学生选课", notes = "学生选课")
    @ApiImplicitParam(name = "userCourse", value = "实体对象", required = true, dataType = "UserCourse")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody UserCourse userCourse) {
        UserElement ue= getCurrentUser();
        userCourse.setGmtCreate(new Date());
        userCourseService.insert(userCourse);
        return ResultUtil.success("增加成功");
    }

    @ApiOperation(value = "更新", notes = "更新对象")
    @ApiImplicitParam(name = "userCourse", value = "实体对象", required = true, dataType = "UserCourse")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult update(@RequestBody UserCourse userCourse) {
        UserElement ue= getCurrentUser();
        userCourseService.update(userCourse);
        return ResultUtil.success("更新成功");
    }

    @ApiOperation(value = "查询", notes = "根据主键查询对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getById(@PathVariable Integer id) {
        UserElement ue= getCurrentUser();
        return ResultUtil.success("查询成功", this.userCourseService.getById(id));
    }

/*    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", paramType = "query", required = true, dataType =
                    "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数目", paramType = "query", required = true, dataType =
                    "Integer")
    })
    @RequestMapping(value = "/findLimitObjects", method = RequestMethod.POST)
    public ApiResult getLimitObjects(QueryCondition condition) {
        UserElement ue= getCurrentUser();
        PageQueryBean pageQueryBean = this.userCourseService.getLimitObjects(condition);
        return ResultUtil.success("查询成功", pageQueryBean);
    }*/
    @ApiOperation(value = "查询一个用户的选课情况", notes = "查询一个用户的选课情况")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "Long")
    @RequestMapping(value = "/getCoursesByUserId/{id}", method = RequestMethod.GET)
    public ApiResult getCoursesById(@PathVariable Long id) {
        UserElement ue= getCurrentUser();
        return ResultUtil.success("查询成功", this.userCourseService.getCoursesById(id));
    }
    @ApiOperation(value = "查询一个课程的所有选课的同学", notes = "查询一个课程的所有选课的同学")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "Integer")
    @RequestMapping(value = "/getUsersByCourseId/{id}", method = RequestMethod.GET)
    public ApiResult getUsersByCourseId(@PathVariable Integer id) {
        UserElement ue= getCurrentUser();
        return ResultUtil.success("查询成功", this.userCourseService.getUsersByCourseId(id));
    }

}