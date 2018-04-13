package just.learn.common.enums;

/**
 * Created by llf on 2018/4/13.
 */
public enum GenderEnum {

    MALE("male","男"),FEMALE("female","女");
    private String  value;
    private String description;
    GenderEnum(String value,String description) {
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
        for (GenderEnum ge:GenderEnum.values()) {
            if (value.equals(ge.value)){
                return ge.description;
            }
        }
        return null;
    }
}
