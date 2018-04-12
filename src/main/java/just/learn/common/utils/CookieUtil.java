package just.learn.common.utils;

import com.alibaba.fastjson.JSONObject;
import just.learn.entity.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn.common.utils
 * @Description: TODO
 * @date 2018/4/11 16:38
 */
public class CookieUtil {
    /**
     * 设置cookie
     * @param response
     * @param name  cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");//可在同一应用服务器内共享方法
        if(maxAge>0)  cookie.setMaxAge(maxAge);
        URLDecoder.decode(cookie.getName(),"utf-8");
        response.addCookie(cookie);
    }

    /**
     * 根据名字获取cookie
     * @param request
     * @param name cookie名字
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            return (Cookie)cookieMap.get(name);
        }else{
            return null;
        }
    }



    /**
     * 将cookie封装到Map里面
     * @param request
     * @return
     */
    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
    public static void deleteCookie(String key,HttpServletResponse response){
        Cookie cookie = new Cookie(key, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

    }
    public static String transformJSONString(Map map){
        JSONObject json =new JSONObject();
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            json.put((String) entry.getKey(), entry.getValue());
        }
        return json.toJSONString();
    }
    public static Map ObjectTransformMap(Object obj){
        Map<String, String> map = new HashMap<String, String>();
        // System.out.println(obj.getClass());
        // 获取f对象对应类中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            String varName = fields[i].getName();
            varName = varName.toLowerCase();//将key置为小写，默认为对象的属性
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o = fields[i].get(obj);
                if (o != null)
                    map.put(varName, o.toString());
                // System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
    public static void main(String[] args) {
        User user=new User();
        user.setDepartment("dasd");
        user.setGender("das");
        System.out.println(transformJSONString(ObjectTransformMap(user)));
    }
}
