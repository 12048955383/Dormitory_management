package org.gxy.dormitory.dao;

import org.gxy.dormitory.entity.TSResource;

import java.util.List;

/**
 * 资源表(TSResource)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-03-18 13:16:25
 */
public interface TSResourceDao {
    /**
     * 根据用户角色id菜单导航栏
     *
     * @param roleId 用户角色Id
     * @return 角色资源集合对象
     */
    List<TSResource> selectByRoleId(String roleId);

    /**
     * 查询所有资源
     *
     * @return
     */
    List<TSResource> selectResourceAll();
}