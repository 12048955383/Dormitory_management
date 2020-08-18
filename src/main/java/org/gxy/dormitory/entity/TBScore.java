package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 宿舍评分(TBScore)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:21
 */
@Getter
@Setter
@Data
public class TBScore implements Serializable {
    private static final long serialVersionUID = 949441935904834551L;
    /**
     * 评分ID
     */
    private String id;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 评分时间
     */
    private Date scoredate;
    /**
     * 宿舍ID
     */
    private String dormid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 宿舍名称
     */
    private TBDorm dorm;
}