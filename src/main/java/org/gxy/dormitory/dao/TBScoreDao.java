package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBScore;

import java.util.List;

/**
 * 宿舍评分(TBScore)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-04-03 11:24:40
 */
public interface TBScoreDao {
    /**
     * 宿舍评分信息
     *
     * @param dormname 宿舍名称
     * @param indexStr 页码
     * @param pageSize 页面代销
     * @return selectByScore
     */
    List<TBScore> selectByScore(@Param("dormname") String dormname,
                                @Param("indexStr") int indexStr,
                                @Param("pageSize") int pageSize);

    /**
     * 宿舍评分信息总条数
     *
     * @param dormname 宿舍名称
     * @return selectByScoreCount
     */
    int selectByScoreCount(@Param("dormname") String dormname);

    /**
     * 修改评分
     *
     * @param score 评分对象
     * @return updateScore
     */
    boolean updateScore(@Param("t_b_score") TBScore score);

    /**
     * 添加评分
     *
     * @param score 评分对象
     * @return updateScore
     */
    boolean insertScore(@Param("t_b_score") TBScore score);

    /**
     * 删除
     *
     * @param ids 评分对象
     * @return updateScore
     */
    boolean deleteScore(@Param("ids") String[] ids);
}