package com.hello.advice;

import com.hello.common.ResultResponse;
import com.hello.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;


@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
    Logger LOG= LoggerFactory.getLogger(ExceptionAdvice.class);



    /**
     * 验证信息异常处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResultResponse handleValidationException(ValidationException e) {
        LOG.error("参数验证失败 {}", e);
        return new ResultResponse().fail("params validation fail");
    }

    /**
     * 业务异常处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ResultResponse handlerBusinessException(BusinessException e){
        LOG.error("业务处理异常 errorMsg:{}",e.getMessage());
        return new ResultResponse().fail(e.getMessage());
    }

    /**
     * 系统未知异常处理
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResultResponse handlerException(Exception e){
        LOG.error("系统未知异常 errorMsg:{}",e.getMessage());
        return new ResultResponse().fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        LOG.error("系统不支持当前请求方法 {}", e);
        return new ResultResponse().fail("not supported method");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        //解析原错误信息，封装后返回，此处返回非法的字段名称，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            return new ResultResponse().fail(error.getDefaultMessage());
        }
        return new ResultResponse().fail("参数校验失败");
    }
}
