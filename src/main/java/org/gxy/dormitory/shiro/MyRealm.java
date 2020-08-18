package org.gxy.dormitory.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.gxy.dormitory.entity.TSRole;
import org.gxy.dormitory.entity.TSUser;
import org.gxy.dormitory.service.TSResourceService;
import org.gxy.dormitory.service.TSRoleService;
import org.gxy.dormitory.service.TSUserService;
import org.gxy.dormitory.util.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 孙鹏轩
 * @date 2020-03-12
 */
public class MyRealm extends AuthorizingRealm {
    /**
     * 服务对象
     */
    @Autowired
    private TSUserService tsUserService;
    @Autowired
    private TSRoleService tsRoleService;
    @Autowired
    private TSResourceService tsResourceService;

    /**
     * 当前登录的Subject授予角色和权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("============开始授权============");
        //从principals中获取主身份信息
        TSRole tsRole = (TSRole) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //共享token中的Subject主体，获取当前用户的用户名
        //String username = (String) principals.getPrimaryPrincipal();
        //通过用户id查询数据库，所属角色
        List<TSRole> tsRoles = tsRoleService.selectUserByRole(tsRole.getId());
        //new一个集合存储该用户角色
        List<String> list = new ArrayList<>();
        for (TSRole role : tsRoles) {
            list.add(role.getName());
        }
        //角色添加
        info.addRoles(list);
        return info;
    }

    /**
     * 验证当前登录的Subject
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名
        String name = (String) token.getPrincipal();
        //得到密码
        String password = new String((char[]) token.getCredentials());
        //ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        //TSUserDao tSUserDao = (TSUserDao) context.getBean("TSUserDao");
        TSUser user = tsUserService.selectByName(name, null);
        if (user != null) {
            TSRole tsRole = new TSRole();
            //根据用户名查询该角色
            List<TSRole> tsRoles = tsRoleService.selectUserByRole(user.getId());
            String roleId = tsRoles.get(0).getId();
            //根据用户角色id菜单导航栏
            List<Menu> menus = tsResourceService.menuByRole(roleId);
            tsRole.setId(user.getId());
            tsRole.setMenuList(menus);
            //如果配置化了MD5凭证规则，token内的明文密码就完成凭证下的加密工作，由shiro完成加密对比
            //明文密码被token记录 ，然后按照凭证规则开始加密，最终匹配数据库中的user.getPassword()的密码
            SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(tsRole, user.getPassword(), getName());
            //如果身份认证验证成功，返回一个AuthenticationInfo实现
            //加盐验证
            //SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getPassword()), user.getRealName());
            return authcInfo;
        }
        return null;
    }
}
