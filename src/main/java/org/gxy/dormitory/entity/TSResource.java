package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 资源表(TSResource)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Getter
@Setter
@Data
public class TSResource implements Serializable {
    private static final long serialVersionUID = -16870885379012985L;

    private String id;
    
    private Date createtime;
    
    private String description;
    
    private String href;
    
    private String name;
    
    private Integer orderNo;
    
    private Integer resourcetype;
    
    private String parentid;

    private List<TSResource> children;
}