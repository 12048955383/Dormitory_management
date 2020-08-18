package org.gxy.dormitory.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.gxy.dormitory.entity.TBDorm;
import org.gxy.dormitory.service.TBDormService;
import org.gxy.dormitory.util.Paging;
import org.gxy.dormitory.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 宿舍信息(TBDorm)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-03-26 17:44:53
 */
@Controller
@RequestMapping("dormController")
public class TBDormController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TBDormService dormService;

    /**
     * 跳转宿舍管理页面
     *
     * @return 宿舍管理页面
     */
    @RequestMapping(params = "goDorm")
    public String goDorm() {
        return "buss/dorm";
    }

    /**
     * 宿舍信息
     *
     * @param page      分页对象
     * @param dormname  宿舍名称
     * @param totals     总床位数
     * @param dormadmin 宿管
     * @return 宿舍信息map
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> dormInfo(Paging page, String dormname, String totals, String dormadmin) {
        Map<String, Object> map = new HashMap<>();
        if (totals == null) {
            totals = "0";
        }
        int parseInt = Integer.parseInt(totals);
        //查询总页数
        int totalcount = dormService.dormCount(dormname, parseInt, dormadmin);
        //分页带搜索查询
        List<TBDorm> dormList = dormService.dormInfo(dormname, parseInt, dormadmin, page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", totalcount);
        //封装结果集啊
        map.put("rows", dormList);
        return map;
    }

    /**
     * 修改宿舍信息
     *
     * @param dorm 宿舍对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TBDorm dorm) {
        Result result = dormService.updateDorm(dorm);
        return result;
    }

    /**
     * 添加宿舍信息
     *
     * @param dorm 宿舍对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "save")
    public Result save(TBDorm dorm) {
        Result result = dormService.addDorm(dorm);
        return result;
    }

    /**
     * 删除宿舍信息
     *
     * @param ids 宿舍id
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "delete")
    public Result save(String[] ids) {
        Result result = dormService.deleteDorm(ids);
        return result;
    }
}