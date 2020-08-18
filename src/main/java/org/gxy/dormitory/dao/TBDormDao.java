package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBDorm;

import java.util.List;

/**
 * 宿舍信息(TBDorm)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-03-20 16:19:10
 */
public interface TBDormDao {
    /**
     * 查询宿舍信息
     *
     * @param dormName  宿舍名称
     * @param total     总床位数
     * @param dormadmin 宿管
     * @param indexStr  开始页码
     * @param pageSize  页面大小
     * @return
     */
    List<TBDorm> selectByDormInfo(@Param("dormname") String dormName,
                                  @Param("total") int total,
                                  @Param("dormadmin") String dormadmin,
                                  @Param("indexStr") int indexStr,
                                  @Param("pageSize") int pageSize);

    /**
     * 查询宿舍信息总条数
     *
     * @param dormName  宿舍名称
     * @param total     总床位数
     * @param dormadmin 宿管
     * @return 宿舍信息总条数
     */
    int selectByDormCount(@Param("dormname") String dormName,
                          @Param("total") int total,
                          @Param("dormadmin") String dormadmin);

    /**
     * 修改宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false
     */
    boolean updateDorm(@Param("t_b_dorm") TBDorm dorm);

    /**
     * 添加宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false
     */
    boolean insertDorm(@Param("t_b_dorm") TBDorm dorm);

    /**
     * 删除宿舍信息
     *
     * @param ids 宿舍id
     * @return true/false
     */
    boolean deleteDorm(@Param("ids") String[] ids);
}