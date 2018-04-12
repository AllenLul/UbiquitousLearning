package just.learn.common.execption;


import just.learn.common.enums.ResultEnum;

/**
 * @author Ethanp
 * @version V1.0
 * @Package cn.jihangyu.glowworm.execption
 * @Description: TODO 自定义异常
 * @date 2018/1/29 10:20
 */
public class CustomException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public CustomException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }
}
