package org.gxy.dormitory.controller;

import org.gxy.dormitory.entity.TSRole;
import org.gxy.dormitory.service.TSResourceService;
import org.gxy.dormitory.service.TSRoleService;
import org.gxy.dormitory.util.Menu;
import org.gxy.dormitory.util.Paging;
import org.gxy.dormitory.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色(TSRole)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-04-10 13:55:57
 */
@Controller
@RequestMapping("roleController")
public class TSRoleController {
    /**
     * 服务对象
     */
    @Autowired
    private TSRoleService roleService;
    @Autowired
    private TSResourceService tSResourceService;

    /**
     * 跳转角色管理界面
     *
     * @return 角色管理界面
     */
    @RequestMapping(params = "goRole")
    public String goRole() {
        return "system/role";
    }

    /**
     * 角色管理，查询所有角色
     *
     * @param page 分页对象
     * @return 所有角色
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> studentInfo(Paging page) {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = roleService.roleCount();
        //分页带搜索查询
        List<TSRole> roleList = roleService.selectRoleAll(page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", roleList);
        return map;
    }

    @ResponseBody
    @RequestMapping(params = "queryResource", method = RequestMethod.POST)
    public Result treeDropdown(String id, Result result) {
        List<Menu> menus = tSResourceService.menuByRole(id);
        String resourceId = "";
        for (Menu menu : menus) {
            List<Menu> children = menu.getChildren();
            for (Menu child : children) {
                resourceId += (child.getId() + ",");
                List<Menu> childChildren = child.getChildren();
                for (Menu childChild : childChildren) {
                    resourceId += (childChild.getId() + ",");
                }
            }
        }
        if(resourceId.length()>0){
            resourceId = resourceId.substring(0, resourceId.length()-1);
        }
        result.setMsg("成功！");
        result.setSuccess(true);
        result.setObj(resourceId);
        return result;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param response 主键
     * @return 单条数据
     */
    @ResponseBody
    @RequestMapping(params = "dropdown")
    public void dropdown(HttpServletResponse response) throws IOException {
        List<TSRole> tsRoleList = roleService.selectIonRoleAll();
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (TSRole re : tsRoleList) {
            sb.append("{");
            sb.append("\"id\":");
            sb.append("\"");
            sb.append(re.getId());
            sb.append("\"");
            sb.append(",");
            sb.append("\"text\":");
            sb.append("\"");
            sb.append(re.getName());
            sb.append("\"");
            sb.append("},");
        }
        String dropdown = sb.substring(0, sb.length() - 1);
        dropdown += "]";
        response.setCharacterEncoding("utf-8");//指定为utf-8
        response.getWriter().write(dropdown);//转化为JSOn格式
    }

}