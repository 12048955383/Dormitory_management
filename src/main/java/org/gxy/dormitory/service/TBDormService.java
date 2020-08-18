package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TBDorm;
import org.gxy.dormitory.util.Result;

import java.util.List;

/**
 * 宿舍信息(TBDorm)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-03-26 17:44:53
 */
public interface TBDormService {
    /**
     * 查询宿舍信息
     *
     * @param dormName 宿舍名称
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @return
     */
    List<TBDorm> dormInfo(String dormName, int total, String dormadmin, int indexStr, int pageSize);

    /**
     * 查询宿舍信息总条数
     *
     * @param dormName  宿舍名称
     * @param total     总床位数
     * @param dormadmin 宿管
     * @return 宿舍信息总条数
     */
    int dormCount(String dormName, int total, String dormadmin);

    /**
     * 修改宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false
     */
    Result updateDorm(TBDorm dorm);

    /**
     * 添加宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false
     */
    Result addDorm(TBDorm dorm);

    /**
     * 删除宿舍信息
     *
     * @param ids 宿舍id
     * @return true/false
     */
    Result deleteDorm(String[] ids);
}