package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TSRoleDao;
import org.gxy.dormitory.entity.TSRole;
import org.gxy.dormitory.service.TSRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色(TSRole)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-03-20 10:22:40
 */
@Service("tSRoleService")
public class TSRoleServiceImpl implements TSRoleService {
    @Autowired
    private TSRoleDao tSRoleDao;

    /**
     * 根据用户名id查询该角色
     *
     * @param userId 用户ID
     * @return 权限对象
     */
    @Override
    public List<TSRole> selectUserByRole(String userId) {
        List<TSRole> roleList = tSRoleDao.selectUserByRole(userId);
        return roleList;
    }

    /**
     * 角色下拉列表，查询所有角色
     *
     * @return 所有角色
     */
    @Override
    public List<TSRole> selectIonRoleAll() {
        return tSRoleDao.queryRoleAll();
    }

    /**
     * 查询所有角色
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 所有角色
     */
    @Override
    public List<TSRole> selectRoleAll(int indexStr, int pageSize) {
        return tSRoleDao.selectRoleAll(indexStr, pageSize);
    }

    /**
     * 查询所有角色
     *
     * @return 角色总数
     */
    @Override
    public int roleCount() {
        int count = tSRoleDao.queryRoleCount();
        return count;
    }
}