package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TSUser;
import org.gxy.dormitory.util.Result;

import java.util.List;

/**
 * 用户(TSUser)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:40:53
 */
public interface TSUserService {
    /**
     * 登录查询
     *
     * @param userName 账号
     * @param passWord 密码
     * @return 对象列表
     */
    TSUser selectByName(String userName, String passWord);

    /**
     * 用户管理查询所有用户
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 用户
     */
    List<TSUser> allUser(int indexStr, int pageSize);

    /**
     * 用户总数
     *
     * @return 用户总数
     */
    int userCount();

    /**
     * 查询用户角色
     *
     * @param id 用户id
     * @return 用户角色
     */
    TSUser roleName(String id);

    /**
     * 修改用户信息(用户管理模块)
     *
     * @param user   用户对象
     * @param roleid 角色id
     * @return true/false
     */
    Result updateUserInfo(TSUser user, String[] roleid);
}