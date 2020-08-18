package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TSUserDao;
import org.gxy.dormitory.dao.TSUserRoleDao;
import org.gxy.dormitory.entity.TSUser;
import org.gxy.dormitory.entity.TSUserRole;
import org.gxy.dormitory.service.TSUserService;
import org.gxy.dormitory.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户(TSUser)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:40:53
 */
@Service("tSUserService")
public class TSUserServiceImpl implements TSUserService {

    @Autowired
    private TSUserDao tSUserDao;
    @Autowired
    private TSUserRoleDao tsUserRoleDao;

    //结果信息实体类
    private Result re = new Result();

    /**
     * 登录查询
     *
     * @param userName 账号
     * @param passWord 密码
     * @return 对象列表
     */
    @Override
    public TSUser selectByName(String userName, String passWord) {
        TSUser user = tSUserDao.selectByName(userName, passWord);
        return user;
    }

    /**
     * 用户管理查询所有用户
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 用户
     */
    @Override
    public List<TSUser> allUser(int indexStr, int pageSize) {
        List<TSUser> userList = tSUserDao.selectAllUser(indexStr, pageSize);
        return userList;
    }

    /**
     * 用户总数
     *
     * @return 用户总数
     */
    @Override
    public int userCount() {
        int count = tSUserDao.selectAllUserByCount();
        return count;
    }

    /**
     * 查询用户角色
     *
     * @param id 用户id
     * @return 用户角色
     */
    @Override
    public TSUser roleName(String id) {
        TSUser users = tSUserDao.selectByRoleName(id);
        return users;
    }

    /**
     * 修改用户信息(用户管理模块)
     *
     * @param user   用户对象
     * @param roleid 角色id
     * @return true/false
     */
    @Override
    @Transactional
    public Result updateUserInfo(TSUser user, String[] roleid) {
        System.out.println("进来了");
        if (roleid != null) {
            boolean b = tSUserDao.updateUserInfo(user);
            //根据用户id删除角色重新赋予角色
            tsUserRoleDao.deleteRole(user.getId());
            //查询当前用户所拥有的角色
            for (int i = 0; i < roleid.length; i++) {
                String id = roleid[i];
                TSUserRole userRole = new TSUserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(id);
                tsUserRoleDao.insertRole(userRole);
            }
            re.setMsg("修改成功");
        } else {
            re.setSuccess(false);
            re.setMsg("至少有一种角色");
        }
        return re;
    }
}