package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TBDamageDao;
import org.gxy.dormitory.entity.TBDamage;
import org.gxy.dormitory.service.TBDamageService;
import org.gxy.dormitory.util.Result;
import org.gxy.dormitory.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 宿舍损坏情况(TBDamage)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-04-02 13:13:49
 */
@Service("tBDamageService")
public class TBDamageServiceImpl implements TBDamageService {
    @Autowired
    private TBDamageDao damageDao;
    //结果信息实体类
    private Result re = new Result();
    /**
     * 查询宿舍损坏情况
     *
     * @param dormname 宿舍名字
     * @param isfixed  是否修复
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 宿舍损坏情况信息
     */
    @Override
    public List<TBDamage> damageList(String dormname, String isfixed, int indexStr, int pageSize) {
        List<TBDamage> damageList = damageDao.selectByDamage(dormname, isfixed, indexStr, pageSize);
        return damageList;
    }

    /**
     * 查询宿舍损坏情况总数
     *
     * @param dormname 宿舍名字
     * @param isfixed  是否修复
     * @return 宿舍损坏情况信息总数
     */
    @Override
    public int damageCount(String dormname, String isfixed) {
        int count = damageDao.selectByDamageCount(dormname, isfixed);
        return count;
    }

    /**
     * 修改宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return true/false
     */
    @Override
    public Result updateDamage(TBDamage damage) {
        boolean b = damageDao.updateDamage(damage);
        if (b == false) {
            re.setMsg("修改失败");
            re.setSuccess(false);
        }
        re.setMsg("修改成功");
        return re;
    }

    /**
     * 修改宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return true/false
     */
    @Override
    public Result addDamage(TBDamage damage) {
        damage.setId(UUIDUtils.getUUID());
        damage.setCreatetime(new Date());
        boolean b = damageDao.insertDamage(damage);
        if (b == false) {
            re.setMsg("添加失败");
            re.setSuccess(false);
        }
        re.setMsg("添加成功");
        return re;
    }

    /**
     * 删除宿舍损坏信息
     *
     * @param ids 宿舍id
     * @return true/false
     */
    @Override
    public Result deleteDamage(String[] ids) {
        boolean b = damageDao.deleteDamage(ids);
        if (b == false) {
            re.setMsg("删除失败");
            re.setSuccess(false);
        }
        re.setMsg("删除成功");
        return re;
    }
}