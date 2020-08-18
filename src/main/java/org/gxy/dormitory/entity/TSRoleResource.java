package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 角色资源(TSRoleResource)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Getter
@Setter
@Data
public class TSRoleResource implements Serializable {
    private static final long serialVersionUID = 844396041643367339L;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 角色资源ID
     */
    private String resourceId;
}