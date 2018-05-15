package just.learn.common.enums;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn
 * @Description: TODO
 * @date 2018/1/29 10:30
 */
public enum ResultEnum {
    UNKONW_ERROR(500,"未知错误"),
    SUCCSEE(200,"成功"),

    OBJECT_NULL_ERROR(501,"对象不能为空"),
    OBJECT_ADD_ERROR(502,"添加对象失败"),
    OBJECT_ALL_Field_NULL(503,"对象所有属性为空"),
    OBJECT_FIND_ERROR(504,"查询对象失败"),
    OBJECT_DELETE_ERROR(505,"删除对象失败"),
    OBJECT_UPDATE_ERROR(506,"更新对象失败"),
    OBJECT_FIND_NULL(507,"查询结果不存在" ),
    NO_USER(507,"用户不存在"),
    NO_ACTIVITY(508,"活动不存在"),
    REDIS_INITIALIZATION_ERROR(507,"redis初始化失败"),
    NO_LOGIN(508,"未登录"),
    FILE_ERROR(509,"上传文件异常" ),
    FILE_FORMAT_ERROR(510,"文件格式错误" ), FILE_TOO_BIG(511,"文件过大" ),
    CURRENT_USER_ERROR(511,"获取当前用户失败"),
    NO_AUTHORITY(512,"没有权限"),
    NO_ID(513, "缺少id"),
    PROPERTY_NULL_ERROR(514,"值是空"),
    LOGIN_FAIL(515, "登录失败"),
    TYPE_ERROR(516,"类型异常" ),
    EXECIL_NULL(517,"Excel数据为空" ), FILE_EMPTY(518,"文件不存在" ), IMG_HAS_EXISTED(519,"图片已经存在" ), HOMEWORK_FIND_NULL(520,"作业不存在" ), HOMEWORK_IS_END(521,"已截止提交" ), SUBMITHOMWORK_FIND_NULL(522,"作业提交记录不存在" );
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
