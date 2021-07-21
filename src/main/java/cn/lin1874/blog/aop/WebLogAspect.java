package cn.lin1874.blog.aop;

import cn.lin1874.blog.mapper.LoginLogMapper;
import cn.lin1874.blog.po.LoginLog;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.LoginLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

/**
 * @author lin1874
 * @date 2021/7/21 - 15:40
 */
@Aspect
@Component
public class WebLogAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Autowired
    LoginLogService loginLogService;

    @After("execution(* cn.lin1874.blog.controller.admin.UserController.doAdminLogin(..))")
    public void adminLoginLog() throws Exception {
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginAcct");
        if (user == null) {
            throw new Exception("用户未登录");
        }
        String desc = "用户：" + user.getNickname() + "登录";
        String ip = request.getRemoteAddr();

        LoginLog loginLog = new LoginLog();
        loginLog.setIp(ip);
        loginLog.setOperDesc(desc);
        loginLog.setOperResult("成功");
        loginLog.setOperTime(new Date());

        loginLogService.addLoginLog(loginLog);

    }

    @Pointcut("execution(public * cn.lin1874.blog.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        // 记录下请求内容
        LOGGER.info("URL : " + request.getRequestURL().toString());
        LOGGER.info("HTTP_METHOD : " + request.getMethod());
        LOGGER.info("IP : " + request.getRemoteAddr());
        LOGGER.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOGGER.info("RESPONSE : " + ret);
        LOGGER.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
        startTime.remove();//用完之后记得清除，不然可能导致内存泄露;
    }



}
