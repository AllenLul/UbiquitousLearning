package just.learn.common.utils;


import just.learn.common.resp.ApiResult;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.db.fiftysql.common.utils
 * @Description: TODO
 * @date 2018/1/28 19:53
 */
public class ResultUtil {
    public static ApiResult success(){
      return   success(null,null);
    }
    public static ApiResult success(String msg,Object data){
        ApiResult apiResult=new ApiResult();
        apiResult.setCode(200);
        apiResult.setMsg(msg);
        apiResult.setData(data);
        return apiResult;
    }
    public static ApiResult success(String msg){
        return success(msg,null);
    }
    public static ApiResult error(Integer code, String msg){
        ApiResult apiResult=new ApiResult();
        apiResult.setCode(code);
        apiResult.setMsg(msg);
        return apiResult;
    }


}
