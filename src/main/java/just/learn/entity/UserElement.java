package just.learn.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethanp
 * @version V1.0
 * @Package cn.jihangyu.glowworm.user.entity
 * @Description: TODO
 * @date 2018/2/7 12:03
 */
@Data
public class UserElement {

    private String userNumber;
    private String token;
    private String role;

    /**
     * 转 map
     *
     * @return
     */
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userNumber", this.userNumber + "");
        map.put("token", token);
        map.put("role",role);
        return map;
    }

    /**
     * map转对象
     *
     * @param map
     * @return
     */
    public static UserElement fromMap(Map<String, String> map) {
        UserElement ue = new UserElement();
        ue.setToken(map.get("token"));
        ue.setUserNumber(map.get("userNumber"));
        ue.setRole(map.get("role"));
        return ue;
    }
}