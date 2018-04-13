package just.learn.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import just.learn.entity.Course;
import just.learn.entity.Courseware;
import just.learn.service.AdminService;
import just.learn.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.controller
 * @Description: TODO
 * @date 2018/4/12 20:20
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @ApiOperation(value = "导入用户信息", notes = "导入用户信息")
    @PostMapping(value = "/importUser", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ApiResult getLimitObjects(@ApiParam(value = "上传的文件", required = true) MultipartFile file) throws Exception {
        return ResultUtil.success("查询成功", adminService.importInfo(file));
    }

    @ApiOperation(value = "管理员审核课件", notes = "管理员审核课件")
    @ApiImplicitParam(name = "reviewVO", value = "审核对象", required = true, dataType = "ReviewVO")
    @PostMapping(value = "/review")
    public ApiResult review(@RequestBody ReviewVO reviewVO) throws Exception {
        adminService.review(reviewVO);
        return ResultUtil.success("success");
    }
}
