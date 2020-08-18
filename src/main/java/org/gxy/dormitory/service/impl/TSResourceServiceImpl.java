package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TSResourceDao;
import org.gxy.dormitory.entity.TSResource;
import org.gxy.dormitory.service.TSResourceService;
import org.gxy.dormitory.util.Menu;
import org.gxy.dormitory.util.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源表(TSResource)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-03-20 10:28:23
 */
@Service("tSResourceService")
public class TSResourceServiceImpl implements TSResourceService {

    @Autowired
    private TSResourceDao tSResourceDao;

    /**
     * 根据用户角色id菜单导航栏
     *
     * @param roleId 用户角色id
     * @return 角色资源集合对象
     */
    @Override
    public List<Menu> menuByRole(String roleId) {
        List<TSResource> resourceList = tSResourceDao.selectByRoleId(roleId);
        //new出来菜单list
        List<Menu> menus = new ArrayList<>();
        //循环出数据
        for (TSResource resource : resourceList) {
            Menu menu = new Menu();
            Map<String, Object> map = new HashMap<>();
            map.put("url", resource.getHref());
            menu.setAttributes(map);
            menu.setText(resource.getName());
            menu.setId(resource.getId());
            menu.setParentid(resource.getParentid());
            menus.add(menu);
        }
        MenuTree menuTree = new MenuTree(menus);
        //建立树形结构
        menus = menuTree.builTree();
        return menus;
    }

    /**
     * 查询所有资源
     *
     * @return
     */
    @Override
    public List<TSResource> ResourceAll() {
        return tSResourceDao.selectResourceAll();
    }
}