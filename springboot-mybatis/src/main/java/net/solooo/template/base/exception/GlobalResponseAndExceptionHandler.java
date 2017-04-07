package net.solooo.template.base.exception;

import com.alibaba.fastjson.JSON;
import net.solooo.template.base.entity.ResultEntity;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 自定义返回值和异常处理
 * Author:Eric
 * Date:17/3/30
 */
@RestControllerAdvice
public class GlobalResponseAndExceptionHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter,
            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> converterType, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {

        if(o instanceof ResultEntity){
            return o;
        }

        ResultEntity result = new ResultEntity();
        result.setCode(HttpStatus.OK.value());
        result.setData(o);

        if(converterType.isAssignableFrom(ByteArrayHttpMessageConverter.class)){
            return JSON.toJSONString(result).getBytes();
        }
        return result;
    }


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
