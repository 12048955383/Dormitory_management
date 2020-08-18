package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 访客信息(TBVisitor)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Getter
@Setter
@Data
public class TBVisitor implements Serializable {
    private static final long serialVersionUID = -66277563023904793L;
    /**
     * 访客ID
     */
    private String id;
    /**
     * 访客姓名
     */
    private String visitorname;
    /**
     * 受访人
     */
    private String studentid;
    /**
     * 与受访人关系
     */
    private String relationship;
    /**
     * 进入时间
     */
    private Date starttime;
    /**
     * 离开时间
     */
    private Date endtime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 学生信息
     */
    private TBStudent student;
}