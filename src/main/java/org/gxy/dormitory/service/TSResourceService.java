package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TSResource;
import org.gxy.dormitory.util.Menu;

import java.util.List;

/**
 * 资源表(TSResource)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-03-20 10:28:23
 */
public interface TSResourceService {

    /**
     * 根据用户角色id菜单导航栏
     * @param roleId 用户角色Id
     * @return 角色资源集合对象
     */
    List<Menu> menuByRole(String roleId);
    /**
     * 查询所有资源
     *
     * @return
     */
    List<TSResource> ResourceAll();

}