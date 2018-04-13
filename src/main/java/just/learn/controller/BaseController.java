package just.learn.controller;

import just.learn.common.resp.ApiResult;
import just.learn.common.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn.controller
 * @Description: TODO
 * @date 2018/4/4 16:25
 */
@RestController
@RequestMapping("/")
public class BaseController {
    @ApiOperation(value = "获取语言信息", notes = "获取语言信息")
    @RequestMapping(value = "/lang", method = RequestMethod.GET)
    public ApiResult getLanguage() {
        return ResultUtil.success();
    }

    //处理日期
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
