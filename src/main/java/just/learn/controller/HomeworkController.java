package just.learn.controller;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Homework;
import just.learn.service.HomeworkService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/homework")
public class HomeworkController {

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
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public ApiResult delete(@PathVariable Integer id) {
homeworkService.delete(id);
return ResultUtil.success("删除成功");
}
@ApiOperation(value = "添加", notes = "添加对象")
@ApiImplicitParam(name = "homework", value = "实体对象", required = true, dataType = "Homework")
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ApiResult add(@RequestBody Homework homework) {
homeworkService.insert(homework);
return ResultUtil.success("增加成功");
}
@ApiOperation(value = "更新", notes = "更新对象")
@ApiImplicitParam(name = "homework", value = "实体对象", required = true, dataType = "Homework")
@RequestMapping(value = "/update", method = RequestMethod.POST)
public ApiResult update(@RequestBody Homework homework) {
homeworkService.update(homework);
return ResultUtil.success("更新成功");
}
@ApiOperation(value = "查询", notes = "根据主键查询对象")
@ApiImplicitParam(paramType = "path", name = "id", value = "主键",
required = true, dataType = "String")
@RequestMapping(value="/{id}",method= RequestMethod.GET)
public ApiResult getById(@PathVariable Integer id) {
return ResultUtil.success("查询成功",this.homeworkService.getById(id));
}


}