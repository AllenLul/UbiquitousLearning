package just.learn.controller;

import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Course;
import just.learn.entity.UserElement;
import just.learn.service.CourseService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import just.learn.vo.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import just.learn.entity.PageQueryBean;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController{

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService courseService;


    /*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
    List<Course> courses = this.courseService.getAll();
    return ResultUtil.success("查询所有对象成功",courses);
    }*/
    @ApiOperation(value = "删除", notes = "根据主键删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ApiResult delete(@PathVariable Integer id) {
        UserElement ue= getCurrentUser();
        if(RoleEnum.STUDENT.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        courseService.delete(id);
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "添加", notes = "添加对象")
    @ApiImplicitParam(name = "course", value = "实体对象", required = true, dataType = "Course")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody Course course) {
        UserElement ue= getCurrentUser();
        if(RoleEnum.STUDENT.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        courseService.insert(course);
        return ResultUtil.success("增加成功");
    }

    @ApiOperation(value = "更新", notes = "更新对象")
    @ApiImplicitParam(name = "course", value = "实体对象", required = true, dataType = "Course")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult update(@RequestBody Course course) {

        courseService.update(course);
        return ResultUtil.success("更新成功");
    }

    @ApiOperation(value = "查询", notes = "根据主键查询对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getById(@PathVariable Integer id) {
        return ResultUtil.success("查询成功", this.courseService.getById(id));
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage", value = "当前页", paramType = "query", required = true, dataType =
                    "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数目", paramType = "query", required = true, dataType =
                    "Integer")
    })
    @RequestMapping(value = "/findLimitObjects", method = RequestMethod.POST)
    public ApiResult getLimitObjects(QueryCondition condition) {
        PageQueryBean pageQueryBean = this.courseService.getLimitObjects(condition);
        return ResultUtil.success("查询成功", pageQueryBean);
    }

}