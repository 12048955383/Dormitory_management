package org.gxy.dormitory.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.gxy.dormitory.entity.TBVisitor;
import org.gxy.dormitory.service.TBVisitorService;
import org.gxy.dormitory.util.Paging;
import org.gxy.dormitory.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访客信息(TBVisitor)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-04-01 14:01:50
 */
@Controller
@RequestMapping("visitorController")
public class TBVisitorController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TBVisitorService visitorService;

    /**
     * 跳转访客页面
     *
     * @return 访客页面
     */
    @RequestMapping(params = "goVisitor")
    public String goVisitor() {
        return "buss/visitor";
    }

    /**
     * 查询访客信息
     *
     * @param page         分页对象
     * @param visitorname  访客名字
     * @param studentname  被访问着名字
     * @param relationship 访客与被访问者关系
     * @param starttime    进入时间
     * @param endtime      结束时间
     * @return 所有访客
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> datagrid(Paging page, String visitorname, String studentname, String relationship, Date starttime, Date endtime) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = visitorService.visitorCount(visitorname, studentname, relationship, starttime, endtime);
        //分页带搜索查询
        List<TBVisitor> visitorList = visitorService.visitorList(visitorname, studentname, relationship, starttime, endtime, page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", visitorList);
        return map;
    }

    /**
     * 添加访客
     *
     * @param visitor 访客对象
     * @return 结果信息
     * @throws ParseException 日期异常
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "save")
    public Result save(TBVisitor visitor) throws ParseException {
        Result result = visitorService.addVisitor(visitor);
        return result;
    }

    /**
     * 修改访客
     *
     * @param visitor 访客对象
     * @return 结果信息
     * @throws ParseException 日期异常
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TBVisitor visitor) throws ParseException {
        Result result = visitorService.updateVisitor(visitor);
        return result;
    }

    /**
     * 删除访客
     *
     * @param ids 访客id
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "delete")
    public Result delete(String[] ids) {
        Result result = visitorService.deleteVisitor(ids);
        return result;
    }
}