package just.learn.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;


/**
 * 实现Web层的日志切面
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * 定义一个切入点.
     *
     */

    @Pointcut("execution(public * com.pxc.ubiquitouslearning.*.controller..*.*(..))")

    public void webLog() {
    }

    @Before("webLog()")

    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        log.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容

        log.info("URL : " + request.getRequestURL().toString());

        log.info("HTTP_METHOD : " + request.getMethod());

        log.info("IP : " + request.getRemoteAddr());

        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：

        Enumeration<String> enu = request.getParameterNames();

        while (enu.hasMoreElements()) {

            String paraName = (String) enu.nextElement();

            System.out.println(paraName + ": " + request.getParameter(paraName));

        }

    }


    @AfterReturning("webLog()")

    public void doAfterReturning(JoinPoint joinPoint) {

        // 处理完请求，返回内容
        log.info("WebLogAspect.doAfterReturning()");

        log.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));

    }


}