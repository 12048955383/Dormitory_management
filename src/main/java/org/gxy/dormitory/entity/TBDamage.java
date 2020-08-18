package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * 宿舍损坏情况(TBDamage)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:01:59
 */
@Getter
@Setter
@Data
public class TBDamage implements Serializable {
    private static final long serialVersionUID = 993008839938034194L;
    /**
     * 损坏ID
     */
    private String id;
    /**
     * 损坏情况
     */
    private String damagestation;
    /**
     * 损坏时间
     */
    private Date damagetime;
    /**
     * 修复时间
     */
    private Date fixtime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 宿舍ID
     */
    private String dormid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 是否修复
     */
    private String isfixed;
    /**
     * 宿舍名字
     */
    private TBDorm  dorm;
}