package org.gxy.dormitory.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.gxy.dormitory.entity.TBDamage;
import org.gxy.dormitory.service.TBDamageService;
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
 * 宿舍损坏情况(TBDamage)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-04-02 13:13:49
 */
@Controller
@RequestMapping("damageController")
public class TBDamageController extends BaseController{
    /**
     * 服务对象
     */
    @Autowired
    private TBDamageService damageService;

    /**
     * 跳转损坏管理页面
     *
     * @return 损坏管理页面
     */
    @RequestMapping(params = "goDamage")
    public String goDamage() {
        return "buss/damage";
    }

    /**
     * 所有宿舍损坏信息
     *
     * @param page     分页对象
     * @param dormname 宿舍
     * @param isfixed  是否修复
     * @return 宿舍损坏信息
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> damageInfo(Paging page, String dormname, String isfixed) {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = damageService.damageCount(dormname, isfixed);
        //分页带搜索查询
        List<TBDamage> damageList = damageService.damageList(dormname, isfixed, page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", damageList);
        return map;
    }

    /**
     * 更新宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TBDamage damage) {
        Result result = damageService.updateDamage(damage);
        return result;
    }

    /**
     * 添加宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "save")
    public Result sava(TBDamage damage) {
        Result result = damageService.addDamage(damage);
        return result;
    }

    /**
     * 添加宿舍损坏信息
     *
     * @param ids 宿舍id
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "delete")
    public Result delete(String[] ids) {
        Result result = damageService.deleteDamage(ids);
        return result;
    }
}