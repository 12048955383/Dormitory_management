package org.gxy.dormitory.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * easyui属性结构菜单栏
 * 每条菜单有自己的id、父节点parentId、菜单名称text、菜单还拥有次级菜单children。
 *
 * @auther 孙鹏轩
 * @date 2020-03-17
 */
@Getter
@Setter
@Data
public class Menu {
    private String id;

    private String parentid;

    private String text;

    private boolean isLeaf;

    private String iconCls;

    private String state; //closed open
    /**
     * 子菜单
     */
    private List<Menu> children;

    private Map<String, Object> attributes;
}