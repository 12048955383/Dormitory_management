package org.gxy.dormitory.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.gxy.dormitory.entity.TBClass;
import org.gxy.dormitory.service.TBClassService;
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
 * (TBClass)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-03-26 15:50:21
 */
@Controller
@RequestMapping("classController")
public class TBClassController {
    /**
     * 服务对象
     */
    @Autowired
    private TBClassService classService;

    @RequestMapping(params = "goClass")
    public String goClass() {
        return "buss/classmanage";
    }

    /**
     * 班级信息
     *
     * @param page      分页对象
     * @param classname 班级名称
     * @return 班级信息
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> classInfo(Paging page, String classname, String teachername) {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = classService.classCount(classname, teachername);
        //分页带搜索查询
        List<TBClass> classList = classService.classInfo(classname, teachername, page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", classList);
        return map;
    }

    /**
     * 修改班级信息
     *
     * @param tbClass 班级对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TBClass tbClass) {
        Result result = classService.updateClass(tbClass);
        return result;
    }

    /**
     * 添加班级
     *
     * @param tbClass 班级对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "save")
    public Result save(TBClass tbClass) {
        Result result = classService.addClass(tbClass);
        return result;
    }

    /**
     * 删除班级
     *
     * @param ids 班级id
     * @param re  结果信息对象
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "delete")
    public Result delete(String[] ids, Result re) {
        Result result = null;
        try {
            result = classService.deleteClass(ids);
        } catch (Exception e) {
            re.setSuccess(false);
            re.setMsg("请先删除该班级所有学生");
            return re;
        }
        return result;
    }
}