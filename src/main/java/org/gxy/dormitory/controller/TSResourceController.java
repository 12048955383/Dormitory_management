package org.gxy.dormitory.controller;

import org.gxy.dormitory.entity.TSResource;
import org.gxy.dormitory.service.TSResourceService;
import org.gxy.dormitory.util.Menu;
import org.gxy.dormitory.util.MenuTree;
import org.gxy.dormitory.util.Paging;
import org.gxy.dormitory.util.ResourcesTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源表(TSResource)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-04-28 20:36:35
 */
@Controller
@RequestMapping("resourceController")
public class TSResourceController {
    /**
     * 服务对象
     */
    @Autowired
    private TSResourceService tSResourceService;

    @RequestMapping(params = "goResource")
    public String goResource() {
        return "system/resource";
    }

    @ResponseBody
    @RequestMapping(params = "datagrid")
    public List<TSResource> datagrid(Paging page, HttpServletResponse response) throws Exception {
        /*page.setPage(0);
        page.setRows(0);
        List<TSResource> resourceList = tSResourceService.ResourceAll();
        String resourceJson = JSON.toJSONString(resourceList);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(resourceJson);*/
        page.setPage(0);
        page.setRows(0);
        List<TSResource> resourceList = tSResourceService.ResourceAll();
        ResourcesTree resourcesTree = new ResourcesTree(resourceList);
        return resourcesTree.builTree();
    }

    @ResponseBody
    @RequestMapping(params = "treeDropdown")
    public List<Menu> treeDropdown(Paging page) throws Exception {
        page.setPage(0);
        page.setRows(0);
        List<TSResource> resourceList = tSResourceService.ResourceAll();
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
}