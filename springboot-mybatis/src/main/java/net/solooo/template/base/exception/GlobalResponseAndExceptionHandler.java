package net.solooo.template.base.exception;

import net.solooo.template.base.entity.ResultEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 自定义返回值和异常处理
 * Author:Eric
 * Date:17/3/30
 */
@RestControllerAdvice
public class GlobalResponseAndExceptionHandler {

    /**
     * 自定义异常处理
     * @param e WebException
     * @return resultEntity
     */
    @ExceptionHandler(value = WebException.class)
    public ResultEntity webErrorHandler(HttpServletRequest request, WebException e) {
        ResultEntity result = new ResultEntity();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMessage(e.getMessage());
        result.setUrl(request.getRequestURI());
        result.setError(new ResultEntity.MyError(e.getError()));
        return result;
    }

    /**
     * 统一异常处理
     * @param e Exception
     * @return ResultEntity
     */
    @ExceptionHandler(value = Exception.class)
    public ResultEntity defaultErrorHandler(HttpServletRequest request, Exception e) {
        ResultEntity result = new ResultEntity();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMessage(e.getMessage());
        result.setUrl(request.getRequestURI());
        result.setError(new ResultEntity.MyError(e.getMessage(), e));
        return result;
    }

}
