package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TBScore;
import org.gxy.dormitory.util.Result;

import java.util.List;

/**
 * 宿舍评分(TBScore)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-04-03 11:24:40
 */
public interface TBScoreService {
    /**
     * 宿舍评分信息
     *
     * @param dormname 宿舍名称
     * @param indexStr 页码
     * @param pageSize 页面代销
     * @return selectByScore
     */
    List<TBScore> scoreList(String dormname, int indexStr, int pageSize);

    /**
     * 宿舍评分信息总条数
     *
     * @param dormname 宿舍名称
     * @return selectByScoreCount
     */
    int scoreCount(String dormname);

    /**
     * 修改评分
     *
     * @param score 评分对象
     * @return updateScore
     */
    Result updateScore(TBScore score);

    /**
     * 添加评分
     *
     * @param score 评分对象
     * @return updateScore
     */
    Result addScore(TBScore score);

    /**
     * 删除
     *
     * @param ids 评分对象
     * @return updateScore
     */
    Result deleteScore(String[] ids);
}