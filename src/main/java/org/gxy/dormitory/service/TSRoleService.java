package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TSRole;

import java.util.List;

/**
 * 角色(TSRole)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-03-20 10:22:40
 */
public interface TSRoleService {

    /**
     * 根据用户名查询该角色所拥有的权限
     *
     * @param userId 用户ID
     * @return 权限对象
     */
    List<TSRole> selectUserByRole(String userId);

    /**
     * 角色下拉列表，查询所有角色
     *
     * @return 所有角色
     */
    List<TSRole> selectIonRoleAll();

    /**
     * 查询所有角色
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 所有角色
     */
    List<TSRole> selectRoleAll(int indexStr, int pageSize);

    /**
     * 查询所有角色
     *
     * @return
     */
    int roleCount();
}