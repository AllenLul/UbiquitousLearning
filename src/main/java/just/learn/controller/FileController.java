package just.learn.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Courseware;
import just.learn.entity.UserElement;
import just.learn.entity.Video;
import just.learn.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.controller
 * @Description: TODO 文件操作
 * @date 2018/4/14 11:54
 */
@RestController
@RequestMapping("file")
public class FileController extends BaseController{
    @Autowired
    @Qualifier("fileServiceImpl")
    private FileService fileService;
    @ApiOperation(value = "上传课件", notes = "上传课件")
    @PostMapping(value = "/uploadCourseware")
    public ApiResult uploaCourseware(@ApiParam(value = "上传的文件", required = true) MultipartFile file, @ApiParam(value = "对象", required = true) Courseware courseware) throws IOException {
        UserElement ue= getCurrentUser();

       String url= fileService.uploaCourseware(file,courseware);
        return ResultUtil.success("上传成功",url);
    }
    @ApiOperation(value = "上传视频", notes = "上传视频")
    @PostMapping(value = "/uploaVideo", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ApiResult uploaVideo(@ApiParam(value = "上传的文件", required = true) MultipartFile file,@ApiParam(value = "对象", required = true) Video video) throws IOException {
        UserElement ue= getCurrentUser();
        String url= fileService.uploaVideo(file,video);
        return ResultUtil.success("上传成功",url);
    }
}
