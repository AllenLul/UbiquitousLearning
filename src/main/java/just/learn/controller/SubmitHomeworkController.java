package just.learn.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import just.learn.common.enums.ResultEnum;
import just.learn.common.enums.RoleEnum;
import just.learn.common.execption.CustomException;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Homework;
import just.learn.entity.SubmitHomework;
import just.learn.entity.UserElement;
import just.learn.service.SubmitHomeworkService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.controller
 * @Description: TODO
 * @date 2018/5/15 14:59
 */
@RestController
@RequestMapping("/SubmitHomework")
public class SubmitHomeworkController extends BaseController{
    @Autowired
    @Qualifier("submitHomeworkServiceImpl")
    private SubmitHomeworkService service;
    @ApiOperation(value = "提交作业（只需要传入userId和homeworkId这两个字段，以及文件）", notes = "提交作业（只需要传入userId和homeworkId这两个字段，以及文件）")
    @PostMapping(value = "/submitHomework")
    public ApiResult submitHomework(@ApiParam(value = "上传的文件", required = true) MultipartFile file, @ApiParam(value = "对象", required = true) SubmitHomework submitHomework) throws IOException {
        //UserElement ue= getCurrentUser();
        String url= service.submitHomework(file,submitHomework);
        return ResultUtil.success("上传成功",url);
    }

    @ApiOperation(value = "条件查询对象", notes = "条件查询对象")
    @ApiImplicitParam(name = "submitHomework", value = "条件查询对象", required = true, dataType = "SubmitHomework")
    @RequestMapping(value = "/getSubmitHomwork", method = RequestMethod.POST)
    public ApiResult getSubmitHomwork(@RequestBody SubmitHomework submitHomework) {
        //UserElement ue= getCurrentUser();
        return ResultUtil.success("查询成功",  service.getSubmitHomwork(submitHomework));
    }
    @ApiOperation(value = "给作业打分(传入提交作业记录的id和分数)", notes = "给作业打分（传入提交作业记录的id和分数）")
    @GetMapping(value = "/grade/{submitHomeworkId}/{score}")
    public ApiResult grade(@PathVariable Integer submitHomeworkId,@PathVariable String score ){
     /*   UserElement ue= getCurrentUser();
        if(!RoleEnum.TEACHER.getValue().equals(ue.getRole())){
            throw new CustomException(ResultEnum.NO_AUTHORITY);
        }*/
        String info= service.grade(submitHomeworkId,score);
        return ResultUtil.success("打分成功",info);
    }
    @ApiOperation(value = "下载提交的作业", notes = "下载提交的作业")
    @RequestMapping(value = "/download/{submitHomeworkId}", method = RequestMethod.GET)
    public ApiResult getHomework(@PathVariable Integer submitHomeworkId, HttpServletResponse response) {
        //UserElement ue= getCurrentUser();
        service.download(submitHomeworkId,response);

        return null;
    }

}
