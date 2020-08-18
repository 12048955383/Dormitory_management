package org.gxy.dormitory.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.gxy.dormitory.entity.TBScore;
import org.gxy.dormitory.service.TBScoreService;
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
 * 宿舍评分(TBScore)表控制层
 *
 * @author 孙鹏轩
 * @since 2020-04-03 11:24:40
 */
@Controller
@RequestMapping("scoreController")
public class TBScoreController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private TBScoreService scoreService;

    /**
     * 跳转宿舍评分页面
     *
     * @return 宿舍评分页面
     */
    @RequestMapping(params = "goScore")
    public String goScore() {
        return "buss/score";
    }

    /**
     * 宿舍评分
     *
     * @param page     分页对象
     * @param paramDorm 宿舍名称
     * @return map
     */
    @ResponseBody
    @RequestMapping(params = "datagrid")
    public Map<String, Object> classInfo(Paging page, String paramDorm) {
        Map<String, Object> map = new HashMap<>();
        //查询总页数
        int total = scoreService.scoreCount(paramDorm);
        //分页带搜索查询
        List<TBScore> scoreList = scoreService.scoreList(paramDorm, page.getIndexStr(), page.getRows());
        //封装总记录条数
        map.put("total", total);
        //封装结果集
        map.put("rows", scoreList);
        return map;
    }

    /**
     * 更新信息
     *
     * @param score 更新
     * @return result 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "update")
    public Result update(TBScore score) {
        Result result = scoreService.updateScore(score);
        return result;
    }
    /**
     * 添加评分信息
     *
     * @param score 评分对象
     * @return result 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "save")
    public Result save(TBScore score) {
        Result result = scoreService.addScore(score);
        return result;
    }

    /**
     * 删除评分
     *
     * @param ids 评分id
     * @return result 结果信息
     */
    @RequiresRoles({"admin"})
    @ResponseBody
    @RequestMapping(params = "delete")
    public Result delete(String[] ids) {
        Result result = scoreService.deleteScore(ids);
        return result;
    }
}