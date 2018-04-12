package just.learn.controller;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.AppendedDocument;
import just.learn.service.AppendedDocumentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/appendedDocument")
public class AppendedDocumentController {

@Autowired
@Qualifier("appendedDocumentServiceImpl")
private AppendedDocumentService appendedDocumentService;


/*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
List<AppendedDocument> appendedDocuments = this.appendedDocumentService.getAll();
return ResultUtil.success("查询所有对象成功",appendedDocuments);
}*/
@ApiOperation(value = "删除", notes = "根据主键删除对象")
@ApiImplicitParam(paramType = "path", name = "id", value = "主键",
required = true, dataType = "String")
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public ApiResult delete(@PathVariable Integer id) {
appendedDocumentService.delete(id);
return ResultUtil.success("删除成功");
}
@ApiOperation(value = "添加", notes = "添加对象")
@ApiImplicitParam(name = "appendedDocument", value = "实体对象", required = true, dataType = "AppendedDocument")
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ApiResult add(@RequestBody AppendedDocument appendedDocument) {
appendedDocumentService.insert(appendedDocument);
return ResultUtil.success("增加成功");
}
@ApiOperation(value = "更新", notes = "更新对象")
@ApiImplicitParam(name = "appendedDocument", value = "实体对象", required = true, dataType = "AppendedDocument")
@RequestMapping(value = "/update", method = RequestMethod.POST)
public ApiResult update(@RequestBody AppendedDocument appendedDocument) {
appendedDocumentService.update(appendedDocument);
return ResultUtil.success("更新成功");
}
@ApiOperation(value = "查询", notes = "根据主键查询对象")
@ApiImplicitParam(paramType = "path", name = "id", value = "主键",
required = true, dataType = "String")
@RequestMapping(value="/{id}",method= RequestMethod.GET)
public ApiResult getById(@PathVariable Integer id) {
return ResultUtil.success("查询成功",this.appendedDocumentService.getById(id));
}


}