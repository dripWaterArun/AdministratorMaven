package com.core.configuration.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wangxiaosong
 * @date 2019年6月7日
 * @version 1.0
 */
@RestControllerAdvice
public class ExceptionController {

  private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

//  @ResponseBody
//  @ExceptionHandler(value = Exception.class)
//  public Result errorHandler(HttpServletRequest request, Exception ex) {
//    //异常 code 值
//    int code = -1;
//    //异常信息
//    String exMessage = ex.getMessage();
//    if (ex instanceof MethodArgumentNotValidException) {
//      MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
//      List<ObjectError> errors = exception.getBindingResult().getAllErrors();
//      StringBuffer sb = new StringBuffer();
//      for (ObjectError error : errors) {
//        String message = error.getDefaultMessage();
//        sb.append(message).append(";");
//      }
//      exMessage = sb.toString();
//    }else if (ex instanceof ConstraintViolationException) {
//      ConstraintViolationException exception = (ConstraintViolationException) ex;
//      StringBuffer sb = new StringBuffer();
//      for (ConstraintViolation constraint : exception.getConstraintViolations()) {
//        sb.append(constraint.getInvalidValue()).append("值不正确，").append(constraint.getMessage()).append("；");
//      }
//      exMessage = sb.toString();
//    } else if (ex instanceof BindException) {
//      BindException exception = (BindException) ex;
//      List<FieldError> fieldErrors=exception.getBindingResult().getFieldErrors();
//      String msg = "参数异常";
//      for (FieldError error:fieldErrors){
//        if (error.getDefaultMessage().indexOf("Failed")==-1) {
//          msg = error.getDefaultMessage();
//        }
//        exMessage = msg;
//        //参数异常 code 值
//        code = ResultCode.ERROR_PARAM.getCode();
//        break;
//      }
//    }
//    log.error("【统一异常处理】：请求路径：" + request.getRequestURL().toString() + " 错误信息：" + exMessage);
//    log.error("【统一异常处理】：请求路径：" + request.getRequestURL().toString() + " 错误详情：" + ex.getMessage());
//    return Result.result(code, Result.FAIL_MESSAGE_CODE, "网络异常");
//  }
//
//  @ResponseBody
//  @ExceptionHandler(value = RuntimeException.class)
//  public Result runtimeException(HttpServletRequest request, RuntimeException ex) {
//    //异常 code 值
//    int code = -1;
//    //异常信息
//    String exMessage = ex.getMessage();
//    //数据库异常
//    if (ex instanceof BadSqlGrammarException){
//      code = ResultCode.ERROR_DB_EXCEPTION.getCode();
//      exMessage = ResultCode.ERROR_DB_EXCEPTION.getDisplay();
//    }
//    log.error("【统一异常处理】：请求路径：" + request.getRequestURL().toString() + " 错误信息：" + exMessage);
//    log.error("【统一异常处理(运行时异常)】：请求路径：" + request.getRequestURL().toString() + " 错误详情：" + ex.getMessage());
//    return Result.result(code, Result.FAIL_MESSAGE_CODE, "网络异常");
//  }
//
//  /** 默认异常处理，前面未处理 */
//  @ExceptionHandler(value = Throwable.class)
//  public Result defaultHandler(HttpServletRequest request, Exception e) {
//    log.error(
//        "【统一异常处理(其他异常)】：请求路径：" + request.getRequestURL().toString() + " 错误信息：" + e.getMessage());
//    return Result.result(Result.FAIL, Result.FAIL_MESSAGE_CODE, "网络异常");
//  }
}
