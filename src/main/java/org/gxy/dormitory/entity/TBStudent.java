package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生信息(TBStudent)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Data
@Setter
@Getter
public class TBStudent implements Serializable {
    private static final long serialVersionUID = -52911181407403910L;
    /**
     * 学生ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * qq
     */
    private String qq;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 班级ID
     */
    private String classid;
    /**
     * 宿舍ID
     */
    private String dormid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 学生对应的班级
     */
    private TBClass classes;
    /**
     * 学生对应的宿舍信息
     */
    private TBDorm dorm;

}