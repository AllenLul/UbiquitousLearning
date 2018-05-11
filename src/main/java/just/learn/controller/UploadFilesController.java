package just.learn.controller;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.UploadFiles;
import just.learn.entity.UserElement;
import just.learn.service.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/uploadFilesService")
public class UploadFilesController extends BaseController{

    @Autowired
    @Qualifier("uploadFilesServiceImpl")
    private UploadFilesService uploadFilesService;

    @ApiOperation(value = "删除", notes = "根据主键删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ApiResult delete(@PathVariable Integer id) {
        UserElement ue=getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        uploadFilesService.delete(id);
        return ResultUtil.success("删除成功");
    }

    @ApiOperation(value = "上传单个活动图片", notes = "上传单个活动图片")
    @RequestMapping(value = "/upload",consumes = "multipart/*",headers = "content-type=multipart/form-data",method = RequestMethod.POST)
    public ApiResult upload(@ApiParam("上传轮播图图片") @RequestParam("file") MultipartFile file, @RequestParam Integer id) throws IOException {
        UserElement ue=getCurrentUser();
        if(RoleEnum.MANAGER.getValue().equals(ue.getRole())){
            String resultFileName=uploadFilesService.upload(file,id);
            return ResultUtil.success("上传成功",resultFileName);
        }else {
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }

    }


    @ApiOperation(value = "添加", notes = "添加对象")
    @ApiImplicitParam(name = "video", value = "实体对象", required = true, dataType = "Video")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ApiResult add(@RequestBody  UploadFiles uploadFiles) {
        UserElement ue=getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        uploadFilesService.insert(uploadFiles);
        return ResultUtil.success("增加成功");
    }

    @ApiOperation(value = "更新", notes = "更新对象")
    @ApiImplicitParam(name = "video", value = "实体对象", required = true, dataType = "Video")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ApiResult update(@RequestBody UploadFiles uploadFiles) {
        UserElement ue=getCurrentUser();
        if(!RoleEnum.MANAGER.getValue().equalsIgnoreCase(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }
        uploadFilesService.update(uploadFiles);
        return ResultUtil.success("更新成功");
    }

    @ApiOperation(value = "查询", notes = "根据主键查询对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键",
            required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApiResult getById(@PathVariable Integer id) {
        return ResultUtil.success("查询成功", this.uploadFilesService.getById(id));
    }
    @ApiOperation(value = "查询所有", notes = "查询所有")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ApiResult getAll() {
        List<UploadFiles> uploadFilesList=this.uploadFilesService.getAll();

        return ResultUtil.success("查询成功",uploadFilesList );
    }


}