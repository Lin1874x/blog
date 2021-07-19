package cn.lin1874.blog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author lin1874
 * @date 2021/7/19 - 9:18
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    public String exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return e.getMessage();
    }
}
