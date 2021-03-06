package just.learn.controller;

import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Homework;
import just.learn.entity.UserElement;
import just.learn.service.HomeworkService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import just.learn.vo.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import just.learn.entity.PageQueryBean;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/homework")
public class HomeworkController extends BaseController{

    @Autowired
    @Qualifier("homeworkServiceImpl")
    private HomeworkService homeworkService;


    /*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
    List<Homework> homeworks = this.homeworkService.getAll();
    return ResultUtil.success("查询所有对象成功",homeworks);
    }*/
    @ApiOperation(value = "删除", notes = "根据主键删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ApiResult delete(@PathVariable Integer id) {
        UserElement ue= getCurrentUser();
        homeworkService.delete(id);
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "老师布置作业接口", notes = "学生交作业")
    @ApiImplicitParam(name = "homework", value = "实体对象", required = true, dataType = "Homework")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody Homework homework) {
        UserElement ue= getCurrentUser();
        homeworkService.insert(homework);
        return ResultUtil.success("增加成功");
    }

    @ApiOperation(value = "更新", notes = "更新对象")
    @ApiImplicitParam(name = "homework", value = "实体对象", required = true, dataType = "Homework")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult update(@RequestBody Homework homework) {
        UserElement ue= getCurrentUser();
        homeworkService.update(homework);
        return ResultUtil.success("更新成功");
    }

    @ApiOperation(value = "查询", notes = "根据主键查询对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getById(@PathVariable Integer id) {
        UserElement ue= getCurrentUser();
        return ResultUtil.success("查询成功", this.homeworkService.getById(id));
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")


    @PostMapping(value = "/findLimitObjects")
    public ApiResult getLimitObjects(@RequestBody QueryCondition<Homework> queryCondition) {
        return ResultUtil.success("查询成功", homeworkService.findStudentsInfo(queryCondition));
    }


    @ApiOperation(value = "批量下载提交的作业", notes = "批量下载提交的作业")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/batchDownload/{id}", method = RequestMethod.GET)
    public ApiResult batchDownload(@PathVariable Integer id,HttpServletResponse response) throws Exception {
        //UserElement ue= getCurrentUser();
        return ResultUtil.success("下载成功", this.homeworkService.batchDownload(id,response));
    }


}