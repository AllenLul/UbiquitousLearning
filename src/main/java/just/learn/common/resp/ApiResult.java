package just.learn.common.resp;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn.common.resp
 * @Description: TODO
 * @date 2018/4/4 18:27
 */
import lombok.Data;
@Data
public class ApiResult<T> {
    private int code;
    private String msg;
    private T data;
}

