package org.gxy.dormitory.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 返回结果信息
 *
 * @auther 孙鹏轩
 * @date 2020-03-12
 */
@Setter
@Getter
public class Result {
    // 是否成功
    private boolean success = true;
    // 提示信息
    private String msg = "操作成功";
    // 其他信息
    private Object obj = null;
    // 其他参数
    private Map<String, Object> attributes;
}
