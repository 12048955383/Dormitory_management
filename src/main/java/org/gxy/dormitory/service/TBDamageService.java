package org.gxy.dormitory.service;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBDamage;
import org.gxy.dormitory.util.Result;

import java.util.List;

/**
 * 宿舍损坏情况(TBDamage)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-04-02 13:13:49
 */
public interface TBDamageService {
    /**
     * 查询宿舍损坏情况
     *
     * @param dormname 宿舍名字
     * @param isfixed  是否修复
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 宿舍损坏情况信息
     */
    List<TBDamage> damageList(String dormname, String isfixed, int indexStr, int pageSize);

    /**
     * 查询宿舍损坏情况总数
     *
     * @param dormname 宿舍名字
     * @param isfixed  是否修复
     * @return 宿舍损坏情况信息总数
     */
    int damageCount(String dormname, String isfixed);

    /**
     * 修改宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return true/false
     */
    Result updateDamage(@Param("t_b_damage") TBDamage damage);

    /**
     * 修改宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return true/false
     */
    Result addDamage(@Param("t_b_damage") TBDamage damage);

    /**
     * 删除宿舍损坏信息
     *
     * @param ids 宿舍id
     * @return true/false
     */
    Result deleteDamage(@Param("ids") String[] ids);
}