package org.gxy.dormitory.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户角色(TSUserRole)实体类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:00:22
 */
@Getter
@Setter
@Data
public class TSUserRole implements Serializable {
    private static final long serialVersionUID = 686491372395588173L;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleId;

}