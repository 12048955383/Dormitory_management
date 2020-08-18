package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TSRole;

import java.util.List;

/**
 * 角色(TSRole)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-03-20 10:12:47
 */
public interface TSRoleDao {
    /**
     * 根据用户名id查询该角色
     *
     * @param userId 用户ID
     * @return 权限对象
     */
    List<TSRole> selectUserByRole(@Param("userId") String userId);

    /**
     * 角色下拉列表，查询所有角色
     *
     * @return 所有角色
     */
    List<TSRole> queryRoleAll();

    /**
     * 查询所有角色
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 所有角色
     */
    List<TSRole> selectRoleAll(@Param("indexStr") int indexStr,@Param("pageSize")  int pageSize);

    /**
     * 查询所有角色
     *
     * @return
     */
    int queryRoleCount();
}