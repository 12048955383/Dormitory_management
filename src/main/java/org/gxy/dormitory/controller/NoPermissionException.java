package org.gxy.dormitory.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.gxy.dormitory.util.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获处理
 *
 * @auther 孙鹏轩
 * @date 2020-04-13
 */
@ControllerAdvice
public class NoPermissionException {
    /**
     * 权限认证
     *
     * @param ex
     * @return result
     */
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public Result handleShiroException(Exception ex) {
        Result result = new Result();
        result.setMsg("无权限操作");
        result.setObj("异常");
        return result;
    }

    /**
     * shiro权限认证失败
     *
     * @param ex
     * @return result
     */
    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public Result AuthorizationException(Exception ex) {
        Result result = new Result();
        result.setMsg("权限认证失败");
        result.setObj("异常");
        return result;
    }

    /**
     * session超时空指针异常
     *
     * @param ex
     * @return 登录页面
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullPoint(Exception ex) {
        System.out.println("近");
        return "system/login";
    }
}
