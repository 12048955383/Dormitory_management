package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 宿舍信息(TBDorm)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:19
 */
@Data
@Setter
@Getter
public class TBDorm implements Serializable {
    private static final long serialVersionUID = -46877005725683818L;
    /**
     * 宿舍ID
     */
    private String id;
    /**
     * 宿舍名称
     */
    private String dormname;
    /**
     * 床位总数
     */
    private Integer total;
    /**
     * 已用床位
     */
    private Integer used;
    /**
     * 宿舍管理员
     */
    private String dormadmin;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createtime;
}