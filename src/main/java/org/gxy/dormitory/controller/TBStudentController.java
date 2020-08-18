package org.gxy.dormitory.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.gxy.dormitory.entity.TBStudent;
import org.gxy.dormitory.service.TBStudentService;
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
 * 学生信息(TBStudent)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-03-23 13:39:38
 */
@Controller
@RequestMapping("studentController")
public class TBStudentController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TBStudentService studentService;

    /**
     * 跳转学生管理界面
     *
     * @return 单条数据
     */
    @RequestMapping(params = "goStudent")
    public String goStudent() {
        return "buss/student";
    }

    /**
     * 分页查询学生管理下所有学生信息(带搜索)
     *
     * @param page     分页对象
     * @param name     学生姓名
     * @param mobile   学生电话
     * @param qq       学生qq
     * @param dormName 学生宿舍名
     * @return 学生信息集合
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> studentInfo(Paging page, String name, String mobile, String qq, String dormName) {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = studentService.studentCount(name, mobile, qq, dormName);
        //分页带搜索查询
        List<TBStudent> tbStudentList = studentService.studentInfo(name, mobile, qq, dormName, page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", tbStudentList);
        return map;
    }

    /**
     * 添加学生
     *
     * @param student 学生对象
     * @param re      结果信息对象
     * @return 添加学生结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "save")
    public Result add(TBStudent student, Result re) {
        Result result = null;
        try {
            result = studentService.addStudent(student);
        } catch (Exception e) {
            re.setMsg("添加失败,核对后重新添加");
            return re;
        }
        return result;
    }

    /**
     * 更新学生信息
     *
     * @param student 学生信息对象
     * @param re      结果信息对象
     * @return 修改结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TBStudent student, Result re) {
        Result result = null;
        try {
            result = studentService.updateByStuId(student);
        } catch (Exception e) {
            re.setMsg("编辑失败");
            re.setSuccess(false);
            return re;
        }
        return result;
    }

    /**
     * 删除学生
     *
     * @param ids 学生id
     * @return 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "delete")
    public Result delete(String[] ids) {
        Result rs = studentService.deleteStudent(ids);
        return rs;
    }

    /**
     * 学生退舍
     *
     * @param stuId 学生id
     * @param re    结果信息对象
     * @return 退舍信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "checkOut")
    public Result checkOut(String stuId, Result re) {
        Result result = null;
        try {
            result = studentService.checkOut(stuId);
        } catch (Exception e) {
            re.setMsg("退舍失败");
            re.setSuccess(false);
            return re;
        }
        return result;
    }
}