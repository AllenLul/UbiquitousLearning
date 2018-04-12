package just.learn.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import just.learn.common.resp.ApiResult;
import just.learn.service.PostService;
import just.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ethanp
 * @version V1.0
 * @Package just.learn.controller
 * @Description: TODO
 * @date 2018/4/12 12:40
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("postServiceImpl")
    private PostService postService;
    @ApiOperation(value = "删除对象", notes = "删除对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query", required = true, dataType =
                    "Integer")
    })
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ApiResult delete(String type,int id) throws Exception {
        Class<?> cls=Class.forName("just.learn.service."+type+"ServiceImpl");
        Object object=cls.newInstance();

        return null;
//        if(type.equals("user")){
//            userService.delete(id);
//        }else if(type.equals("post")){
//            postService.delete(id);
//        }
    }
}
