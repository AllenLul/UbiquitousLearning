package just.learn.common.utils;

/**
 * @author Ethanp
 * @version V1.0
 * @Package com.pxc.learn.common.utils
 * @Description: TODO
 * @date 2018/4/11 21:53
 */
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by yt on 2016/12/21.
 */
public class CreateCode  {

    static final  String controllerStr="F:\\java_2018\\learn\\src\\main\\java\\just\\learn" +
            "\\controller\\";
    static final String serviceStr="F:\\java_2018\\learn\\src\\main\\java\\just\\learn" +
            "\\service\\";

    public static void main(String[] args) throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "F:\\java_2018\\learn\\src\\main\\java");
        ve.setProperty("input.encoding", "utf-8");
        ve.setProperty("output.encoding", "utf-8");
        ve.init();

        String[]strsUp={"UserCourse"};
        String[]strsLow=new String[strsUp.length];
        for (int i = 0; i < strsUp.length; i++) {
            strsLow[i]=(strsUp[i].substring(0,1).toLowerCase()+strsUp[i].substring(1,strsUp[i].length()));
        }

        Template controller = ve.getTemplate("just\\learn\\common\\utils\\controller.vm");
        Template service =ve.getTemplate("just\\learn\\common\\utils\\service.vm");
        Template serviceImpl =ve.getTemplate("just\\learn\\common\\utils\\serviceImpl.vm");
        for (int i = 0; i <strsLow.length ; i++) {
            VelocityContext ctx = new VelocityContext();
            ctx.put("modelUp", strsUp[i]);
            ctx.put("modelLow",strsLow[i]);
            StringWriter conw = new StringWriter();
            StringWriter serw=new StringWriter();
            StringWriter serImplw=new StringWriter();
            controller.merge(ctx, conw);
            service.merge(ctx,serw);
            serviceImpl.merge(ctx,serImplw);
            writer(controllerStr+strsUp[i]+"Controller.java",conw);
            writer(serviceStr+strsUp[i]+"Service.java",serw);
            writer(serviceStr+strsUp[i]+"ServiceImpl.java",serImplw);
        }
    }

    static void writer(String des,StringWriter sw){
        FileOutputStream of = null;
        try {
            of = new FileOutputStream(des);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            of.write(sw.toString().getBytes("UTF-8"));
            of.flush();
            of.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}