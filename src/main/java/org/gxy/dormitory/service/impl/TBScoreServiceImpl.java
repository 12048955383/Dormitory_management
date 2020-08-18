package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TBScoreDao;
import org.gxy.dormitory.entity.TBScore;
import org.gxy.dormitory.service.TBScoreService;
import org.gxy.dormitory.util.Result;
import org.gxy.dormitory.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 宿舍评分(TBScore)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-04-03 11:24:40
 */
@Service("tBScoreService")
public class TBScoreServiceImpl implements TBScoreService {
    @Autowired
    private TBScoreDao scoreDao;
    //结果信息实体类
    private Result re = new Result();
    /**
     * 宿舍评分信息
     *
     * @param dormname 宿舍名称
     * @param indexStr 页码
     * @param pageSize 页面代销
     * @return selectByScore
     */
    @Override
    public List<TBScore> scoreList(String dormname, int indexStr, int pageSize) {
        List<TBScore> scoreList = scoreDao.selectByScore(dormname, indexStr, pageSize);
        return scoreList;
    }

    /**
     * 宿舍评分信息总条数
     *
     * @param dormname 宿舍名称
     * @return selectByScoreCount
     */
    @Override
    public int scoreCount(String dormname) {
        int count = scoreDao.selectByScoreCount(dormname);
        return count;
    }

    /**
     * 修改评分
     *
     * @param score 评分对象
     * @return updateScore
     */
    @Override
    public Result updateScore(TBScore score) {
        boolean b = scoreDao.updateScore(score);
        if (b == false) {
            re.setMsg("修改失败");
            re.setSuccess(false);
        }
        re.setMsg("修改成功");
        return re;
    }

    /**
     * 添加评分
     *
     * @param score 评分对象
     * @return updateScore
     */
    @Override
    public Result addScore(TBScore score) {
        score.setCreatetime(new Date());
        score.setId(UUIDUtils.getUUID());
        boolean b = scoreDao.insertScore(score);
        if (b == false) {
            re.setMsg("添加失败");
            re.setSuccess(false);
        }
        re.setMsg("添加成功");
        return re;
    }

    /**
     * 删除
     *
     * @param ids 评分对象
     * @return updateScore
     */
    @Override
    public Result deleteScore(String[] ids) {
        boolean b = scoreDao.deleteScore(ids);
        if (b == false) {
            re.setMsg("删除失败");
            re.setSuccess(false);
        }
        re.setMsg("删除成功");
        return re;
    }
}