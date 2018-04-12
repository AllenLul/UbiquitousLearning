package just.learn.controller;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Video;
import just.learn.service.VideoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/video")
public class VideoController {

@Autowired
@Qualifier("videoServiceImpl")
private VideoService videoService;


/*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
List<Video> videos = this.videoService.getAll();
return ResultUtil.success("查询所有对象成功",videos);
}*/
@ApiOperation(value = "删除", notes = "根据主键删除对象")
@ApiImplicitParam(paramType = "path", name = "id", value = "主键",
required = true, dataType = "String")
@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
public ApiResult delete(@PathVariable Integer id) {
videoService.delete(id);
return ResultUtil.success("删除成功");
}
@ApiOperation(value = "添加", notes = "添加对象")
@ApiImplicitParam(name = "video", value = "实体对象", required = true, dataType = "Video")
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ApiResult add(@RequestBody Video video) {
videoService.insert(video);
return ResultUtil.success("增加成功");
}
@ApiOperation(value = "更新", notes = "更新对象")
@ApiImplicitParam(name = "video", value = "实体对象", required = true, dataType = "Video")
@RequestMapping(value = "/update", method = RequestMethod.POST)
public ApiResult update(@RequestBody Video video) {
videoService.update(video);
return ResultUtil.success("更新成功");
}
@ApiOperation(value = "查询", notes = "根据主键查询对象")
@ApiImplicitParam(paramType = "path", name = "id", value = "主键",
required = true, dataType = "String")
@RequestMapping(value="/{id}",method= RequestMethod.GET)
public ApiResult getById(@PathVariable Integer id) {
return ResultUtil.success("查询成功",this.videoService.getById(id));
}


}