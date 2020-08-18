package org.gxy.dormitory.controller;

import org.gxy.dormitory.entity.TSRole;
import org.gxy.dormitory.entity.TSUser;
import org.gxy.dormitory.service.TSUserService;
import org.gxy.dormitory.util.Paging;
import org.gxy.dormitory.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户(TSUser)表控制层
 *
 * @auther 孙鹏轩
 * @date 2020-04-10
 */
@Controller
@RequestMapping("userController")
public class TSUserController {
    @Autowired
    private TSUserService userService;

    /**
     * 跳转用户管理页面
     *
     * @return 用户管理页面
     */
    @RequestMapping(params = "goUser")
    public String goUser() {
        return "system/user";
    }

    /**
     * 用户管理，查询所有用户
     *
     * @param page 分页对象
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> classInfo(Paging page) {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = userService.userCount();
        //分页带搜索查询
        List<TSUser> userList = userService.allUser(page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", userList);
        return map;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @param roleid
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TSUser user, String[] roleid) {
        Result result = userService.updateUserInfo(user, roleid);
        return result;
    }

    /**
     * 查询角色
     *
     * @param id     角色id
     * @param result 结果对象
     * @return 结果对象信息
     */
    @ResponseBody
    @RequestMapping(params = "queryRole", method = RequestMethod.POST)
    public Result queryRole(String id, Result result) {
        TSUser user = userService.roleName(id);
        String roleId = "";
        for (TSRole re : user.getRoles()) {
            roleId += (re.getId() + ",");
        }
        if (roleId.length() > 0) {
            roleId = roleId.substring(0, roleId.length() - 1);
        }
        result.setObj(roleId);
        return result;
    }
}
