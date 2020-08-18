package org.gxy.dormitory.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法getRootNode获取所有根节点，方法builTree将根节点汇总创建树形结构，
 * buildChilTree为节点建立次级树并拼接上当前树，递归调用buildChilTree不断为当前树开枝散叶直至找
 * 不到新的子树。完成递归，获取树形结构。
 *
 * @author 孙鹏轩
 * @data 2020-03-17
 */
public class MenuTree {
    //创建菜单list
    private List<Menu> menuList = new ArrayList();

    /**
     * @param menuList 菜单
     */
    public MenuTree(List<Menu> menuList) {
        this.menuList = menuList;
    }

    //获取根节点
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists = new ArrayList();
        for (Menu menuNode : menuList) {
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
    public List<Menu> builTree() {
        //创建树形list(获取根节点)
        List<Menu> treeMenus = new ArrayList<>();
        //获取所有根节点
        for (Menu menuNode : getRootNode()) {
            //调用子树形结构方法
            menuNode = buildChilTree(menuNode);
            //添加树形根节点
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    //递归，建立子树形结构
    private Menu buildChilTree(Menu pNode) {
        List<Menu> chilMenus = new ArrayList();
        for (Menu menuNode : menuList) {
            if (pNode.getId().equals(menuNode.getParentid())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }
}