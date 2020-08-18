package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * (TBClass)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:01
 */
@Data
@Setter
@Getter
public class TBClass implements Serializable {
    private static final long serialVersionUID = 417473076709624774L;
    /**
    * 班级ID
    */
    private String id;
    /**
    * 班级名
    */
    private String classname;
    /**
    * 辅导员
    */
    private String teachername;
    /**
    * 创建时间
    */
    private Date createtime;

}