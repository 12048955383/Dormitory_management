package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBDorm;
import org.gxy.dormitory.entity.TBStudent;

import java.util.List;

/**
 * 学生信息(TBStudent)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-03-20 16:22:03
 */
public interface TBStudentDao {
    /**
     * 学生管理信息查询
     *
     * @param indexStr 开始页码
     * @param pageSize 页面大小
     * @param name     学生姓名
     * @param mobile   学生电话
     * @param qq       学生qq
     * @param dormName 学生宿舍名称
     * @return 学生管理信息集合对象
     */
    List<TBStudent> selectByStudentInfo(@Param("name") String name,
                                        @Param("mobile") String mobile,
                                        @Param("qq") String qq,
                                        @Param("dormname") String dormName,
                                        @Param("indexStr") int indexStr,
                                        @Param("pageSize") int pageSize);

    /**
     * 查询学生管理信息总数
     *
     * @return 学生管理信息总数
     */
    int selectByStudentCount(@Param("name") String name,
                             @Param("mobile") String mobile,
                             @Param("qq") String qq,
                             @Param("dormname") String dormName);

    /**
     * 根据学生id查询学生信息(∈修改)
     *
     * @param id 学生id
     * @return 学生信息
     */
    TBStudent selectByStuId(String id);

    /**
     * 根据学生信息，拿到宿舍id进行查询宿舍信息
     *
     * @param id 宿舍id
     * @return 宿舍信息
     */
    TBDorm selectByDormId(String id);

    /**
     * 更新学生信息
     *
     * @param student 学生对象
     * @return 更新信息
     */
    boolean updateByStuId(@Param("t_b_student") TBStudent student);

    /**
     * 更新宿舍信息
     *
     * @param dorm 宿舍对象
     * @return true/false(成功/失败)
     */
    boolean updateByDormId(@Param("t_b_dorm") TBDorm dorm);

    /**
     * 添加学生
     *
     * @param student 学生对象
     * @return true/false(成功/失败)
     */
    boolean insertStu(@Param("t_b_student") TBStudent student);

    /**
     * 删除学生
     *
     * @param ids 学生id
     * @return true/false(成功/失败)
     */
    boolean deleteByStuId(@Param("ids") String[] ids);

}