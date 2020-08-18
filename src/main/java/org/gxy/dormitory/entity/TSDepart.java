package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门表(TSDepart)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Getter
@Setter
@Data
public class TSDepart implements Serializable {
    private static final long serialVersionUID = -40363430197357211L;
    /**
     * 部门ID
     */
    private String id;
    /**
     * 部门名称
     */
    private String departname;
    /**
     * 部门描述
     */
    private String description;
    /**
     * 部门ID
     */
    private String parentid;
    /**
     * 创建时间
     */
    private Date createtime;

}