package hzc.com.aspect;

import com.alibaba.fastjson.JSONObject;
import hzc.com.mapper.SysLogsMapper;
import hzc.com.model.SysLogs;
import hzc.com.utils.IpUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 描述：系统访问日志AOP切面类
 * @auther: HuangZhiCheng
 * @date: 2018/7/16 13:56
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger=Logger.getLogger(WebLogAspect.class);

/*  使用@Aspect注解将一个java类定义为切面类
    使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
    根据需要在切入点不同位置的切入内容
    使用@Before在切入点开始处切入内容
    使用@After在切入点结尾处切入内容
    使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
    使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
    使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑*/

 /*   在@Before中优先执行@Order(5)的内容，再执行@Order(10)的内容
    在@After和@AfterReturning中优先执行@Order(10)的内容，再执行@Order(5)的内容*/
    @Autowired
    private SysLogsMapper sysLogsMapper;

    @Pointcut("execution(public *  hzc.com.controller.*.*(..))")
    public void methed() {}


    @Before("methed()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容
       // logger.info("WebLogAspect.doBefore()--接收请求");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容

        /*logger.info("URL : " + request.getRequestURL().toString());//请求地址
        logger.info("HTTP_METHOD : " + request.getMethod());//请求方式
        logger.info("IP : " + request.getRemoteAddr());//请求ip
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());//请求方法
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs())); //请求参数*/


        JSONObject obj=new JSONObject();
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            System.out.println(paraName + ": " + request.getParameter(paraName));
            obj.put(paraName,request.getParameter(paraName));
        }
        String params=obj.toJSONString();
        //创建日志对象
        SysLogs syslog=new SysLogs();
        syslog.setHttpUrl(request.getRequestURL().toString());//请求地址
        syslog.setHttpMethod(request.getMethod());//请求方式
        syslog.setIp(IpUtil.getCliectIp(request));//请求者IP
        syslog.setParams(params);//请求参数
        syslog.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()); //请求方法名
        //添加日志
        sysLogsMapper.insert(syslog);

    }

    @AfterReturning(pointcut = "methed()",returning = "obj")
    public void doAfterReturning(Object obj)  throws Throwable {
        // 处理完请求，返回内容
        /* logger.info("WebLogAspect.doAfterReturning--处理完请求");
         logger.info("obj:"+String.valueOf(obj));*/
    }
}
