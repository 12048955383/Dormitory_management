package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.gxy.dormitory.util.Menu;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色(TSRole)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Getter
@Setter
@Data
public class TSRole implements Serializable {
    private static final long serialVersionUID = -74653595162759426L;
    /**
    * 角色ID
    */
    private String id;
    /**
    * 创建时间
    */
    private Date createtime;
    /**
    * 角色描述
    */
    private String description;
    /**
    * 角色名
    */
    private String name;

    /**
     * 菜单栏
     */
    private List<Menu> menuList;
}