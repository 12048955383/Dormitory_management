package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TSUserRole;

/**
 * (TSUserRole)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-04-14 13:14:47
 */
public interface TSUserRoleDao {

    /**
     * 修改用户角色(用户管理模块)
     *
     * @param userRole 用户角色对象
     * @return true/false
     */
    boolean insertRole(@Param("t_s_user_role") TSUserRole userRole);

    /**
     * 如果有该角色则删除(用户管理模块)
     *
     * @param id 角色id
     * @return true/false
     */
    boolean deleteRole(@Param("id")String id);

}