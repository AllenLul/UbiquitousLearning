package just.learn.common.enums;

/**
 * Created by llf on 2018/4/13.
 */
public enum RoleEnum {

    STUDENT("student","学生"),TEACHER("teacher","老师"),MANAGER("manager","管理员");
    private String  value;
    private String description;
    RoleEnum(String value,String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }
    public static String getDescription(String value) {
        if (value==null||value.isEmpty()){
            return  null;
        }
        for (RoleEnum role:RoleEnum.values()) {
            if (value.equals(role.value)){
                return role.description;
            }
        }
        return null;
    }

}
