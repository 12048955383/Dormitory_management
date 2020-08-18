package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TSUser;

import java.util.List;

/**
 * 用户(TSUser)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-03-12 10:40:53
 */
public interface TSUserDao {
    /**
     * 登录查询
     *
     * @param userName 账号
     * @param passWord 密码
     * @return 对象列表
     */
    TSUser selectByName(@Param("username") String userName, @Param("PASSWORD") String passWord);

    /**
     * 用户管理查询所有用户
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 用户
     */
    List<TSUser> selectAllUser(@Param("indexStr") int indexStr, @Param("pageSize") int pageSize);

    /**
     * 用户总数
     *
     * @return 用户总数
     */
    int selectAllUserByCount();

    /**
     * 查询用户角色(用户管理模块)
     *
     * @param id 用户id
     * @return 用户角色
     */
    TSUser selectByRoleName(String id);

    /**
     * 修改用户信息(用户管理模块)
     *
     * @param user 用户对象
     * @return true/false
     */
    boolean updateUserInfo(@Param("t_s_user") TSUser user);
}