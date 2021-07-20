package cn.lin1874.blog.exception.handler;

import cn.lin1874.blog.exception.DatabaseException;
import cn.lin1874.blog.utils.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lin1874
 * @date 2021/7/19 - 9:18
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ResultEntity exceptionHandler(Exception e){
        if (e instanceof DatabaseException) {
            return new ResultEntity(ResultEntity.FAILED,"数据库异常：" + e.getMessage(), null);
        }
        return new ResultEntity(ResultEntity.FAILED,e.getMessage(),null);
    }


}
