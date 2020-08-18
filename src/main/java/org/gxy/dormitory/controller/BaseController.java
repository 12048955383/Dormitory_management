package org.gxy.dormitory.controller;

import org.gxy.dormitory.util.DateConvertEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * 接受前台日期字符串(String类型)转换为Date类型
 * @auther 孙鹏轩
 * @date 2020-03-27
 */
public class BaseController  {
    /**
     * @InitBinder 自定义数据绑定注册支持，用于将请求参数转换到命令对象属性的对应类型
     * @param binder 注册一个自定义的编辑器，编辑器是日期类型
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         */
        binder.registerCustomEditor(Date.class, new DateConvertEditor());
    }
}
