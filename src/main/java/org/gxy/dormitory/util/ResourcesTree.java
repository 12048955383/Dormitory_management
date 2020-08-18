package org.gxy.dormitory.util;

import org.gxy.dormitory.entity.TSResource;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 孙鹏轩
 * @date 2020-04-29
 */
public class ResourcesTree {
    //创建菜单list
    private List<TSResource> menuList = new ArrayList();

    /**
     * @param menuList 菜单
     */
    public ResourcesTree(List<TSResource> menuList) {
        this.menuList = menuList;
    }

    //获取根节点
    private List<TSResource> getRootNode() {
        List<TSResource> rootMenuLists = new ArrayList();
        for (TSResource menuNode : menuList) {
            if (menuNode.getParentid()==null) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }

    /**
     * 建立树形结构
     *
     * @return 树形
     */
    public List<TSResource> builTree() {
        //创建树形list(获取根节点)
        List<TSResource> treeMenus = new ArrayList<>();
        //获取所有根节点
        for (TSResource menuNode : getRootNode()) {
            //调用子树形结构方法
            menuNode = buildChilTree(menuNode);
            //添加树形根节点
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private TSResource buildChilTree(TSResource pNode) {
        List<TSResource> chilMenus = new ArrayList();
        for (TSResource menuNode : menuList) {
            if (pNode.getId().equals(menuNode.getParentid())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }
}
