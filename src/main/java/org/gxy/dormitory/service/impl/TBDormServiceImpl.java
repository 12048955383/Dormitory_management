package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TBDormDao;
import org.gxy.dormitory.entity.TBDorm;
import org.gxy.dormitory.service.TBDormService;
import org.gxy.dormitory.util.Result;
import org.gxy.dormitory.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 宿舍信息(TBDorm)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-03-26 17:44:53
 */
@Service("tBDormService")
public class TBDormServiceImpl implements TBDormService {
    @Autowired
    private TBDormDao tBDormDao;
    //结果信息实体类
    private Result re = new Result();

    /**
     * 查询宿舍信息
     *
     * @param dormName 宿舍名称
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return
     */
    @Override
    public List<TBDorm> dormInfo(String dormName, int total, String dormadmin, int indexStr, int pageSize) {
        List<TBDorm> dormList = tBDormDao.selectByDormInfo(dormName, total, dormadmin, indexStr, pageSize);
        for (TBDorm tbDorm : dormList) {
            Integer dormUsed = tbDorm.getUsed();
            Integer dormTotal = tbDorm.getTotal();
            tbDorm.setUsed(dormTotal - dormUsed);
        }
        return dormList;
    }

    /**
     * 查询宿舍信息总条数
     *
     * @param dormName 宿舍名称
     * @return
     */
    @Override
    public int dormCount(String dormName, int total, String dormadmin) {
        int i = tBDormDao.selectByDormCount(dormName, total, dormadmin);
        return i;
    }

    /**
     * 修改宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false
     */
    @Override
    public Result updateDorm(TBDorm dorm) {
        boolean b = tBDormDao.updateDorm(dorm);
        if (b == false) {
            re.setMsg("修改失败");
            re.setSuccess(false);
        }
        re.setMsg("修改成功");
        return re;
    }

    /**
     * 添加宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false
     */
    @Override
    public Result addDorm(TBDorm dorm) {
        dorm.setId(UUIDUtils.getUUID());
        dorm.setCreatetime(new Date());
        dorm.setUsed(0);
        boolean b = tBDormDao.insertDorm(dorm);
        if (b == false) {
            re.setMsg("添加失败");
            re.setSuccess(false);
        }
        re.setMsg("添加成功");
        return re;
    }

    /**
     * 删除宿舍信息
     *
     * @param ids 宿舍id
     * @return true/false
     */
    @Override
    public Result deleteDorm(String[] ids) {
        boolean b = tBDormDao.deleteDorm(ids);
        if (b == false) {
            re.setMsg("删除失败");
            re.setSuccess(false);
        }
        re.setMsg("删除成功");
        return re;
    }
}