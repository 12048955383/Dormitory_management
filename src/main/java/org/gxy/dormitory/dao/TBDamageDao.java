package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBDamage;

import java.util.List;

/**
 * 宿舍损坏情况(TBDamage)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-04-02 13:13:49
 */
public interface TBDamageDao {
    /**
     * 查询宿舍损坏情况
     *
     * @param dormname 宿舍名字
     * @param isfixed  是否修复
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return 宿舍损坏情况信息
     */
    List<TBDamage> selectByDamage(@Param("dormname") String dormname,
                                  @Param("isfixed") String isfixed,
                                  @Param("indexStr") int indexStr,
                                  @Param("pageSize") int pageSize);

    /**
     * 查询宿舍损坏情况总数
     *
     * @param dormname 宿舍名字
     * @param isfixed  是否修复
     * @return 宿舍损坏情况信息总数
     */
    int selectByDamageCount(@Param("dormname") String dormname, @Param("isfixed") String isfixed);

    /**
     * 修改宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return true/false
     */
    boolean updateDamage(@Param("t_b_damage") TBDamage damage);

    /**
     * 修改宿舍损坏信息
     *
     * @param damage 宿舍损坏信息对象
     * @return true/false
     */
    boolean insertDamage(@Param("t_b_damage") TBDamage damage);

    /**
     * 删除宿舍损坏信息
     *
     * @param ids 宿舍id
     * @return true/false
     */
    boolean deleteDamage(@Param("ids") String[] ids);
}