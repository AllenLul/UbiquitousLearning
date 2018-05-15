package just.learn.controller;

import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.UserElement;
import just.learn.entity.Video;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import just.learn.service.VideoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import just.learn.vo.QueryCondition;
import io.swagger.annotations.ApiImplicitParam;
import just.learn.entity.PageQueryBean;

@RestController
@RequestMapping("/video")
public class VideoController extends BaseController{

    @Autowired
    @Qualifier("videoServiceImpl")
    protected VideoService videoService;


    /*@RequestMapping(value="/getAll",method= RequestMethod.GET) ApiResult getAll() {
    List<Video> videos = this.videoService.getAll();
    return ResultUtil.success("查询所有对象成功",videos);
    }*/
    @ApiOperation(value = "删除", notes = "根据主键删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ApiResult delete(@PathVariable Integer id) {
        UserElement ue=getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        videoService.delete(id);
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "添加", notes = "添加对象")
    @ApiImplicitParam(name = "video", value = "实体对象", required = true, dataType = "Video")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody Video video) {
        UserElement ue=getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        videoService.insert(video);
        return ResultUtil.success("增加成功");
    }

    @ApiOperation(value = "更新", notes = "更新对象")
    @ApiImplicitParam(name = "video", value = "实体对象", required = true, dataType = "Video")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult update(@RequestBody Video video) {
        UserElement ue=getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        videoService.update(video);
        return ResultUtil.success("更新成功");
    }

    @ApiOperation(value = "查询", notes = "根据主键查询对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getById(@PathVariable Integer id) {

        return ResultUtil.success("查询成功", this.videoService.getById(id));
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", paramType = "path", required = true, dataType =
                    "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数目", paramType = "path", required = true, dataType =
                    "Integer")
    })
    @GetMapping(value = "/findLimitObjects/{pageNum}/{pageSize}")
    public ApiResult getLimitObjects(@PathVariable Integer pageNum,@PathVariable Integer pageSize) {

        return ResultUtil.success("查询成功", videoService.findStudentsInfo(pageNum,pageSize));
    }
    @ApiOperation(value = "条件查询对象", notes = "条件查询对象")
    @ApiImplicitParam(name = "video", value = "条件查询对象", required = true, dataType = "Video")
    @RequestMapping(value = "/getVideo", method = RequestMethod.POST)
    public ApiResult getVideo(@RequestBody Video video) {
        //UserElement ue= getCurrentUser();

        return ResultUtil.success("查询成功",  videoService.getVideo(video));
    }

}