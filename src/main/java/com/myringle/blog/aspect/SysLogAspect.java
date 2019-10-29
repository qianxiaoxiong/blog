package com.myringle.blog.aspect;

import com.alibaba.fastjson.JSON;
import com.myringle.blog.annotation.MyLog;
import com.myringle.blog.pojo.TbSyslog;
import com.myringle.blog.service.TbSyslogService;
import com.myringle.blog.utils.IpAdrressUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private TbSyslogService tbSyslogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.myringle.blog.annotation.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveTbSyslog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
        //保存日志
        TbSyslog TbSyslog = new TbSyslog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            TbSyslog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        TbSyslog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        TbSyslog.setParams(params);

        TbSyslog.setCreateDate(new Date());
        //获取用户名

      TbSyslog.setUserName("qlb");

        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        TbSyslog.setIp(IpAdrressUtil.getIpAdrress(request));

        //调用service保存TbSyslog实体类到数据库
        tbSyslogService.save(TbSyslog);
    }

}