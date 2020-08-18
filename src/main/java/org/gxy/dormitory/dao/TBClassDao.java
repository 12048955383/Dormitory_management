package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBClass;

import java.util.List;

/**
 * (TBClass)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-03-26 15:50:21
 */
public interface TBClassDao {
    /**
     * 查询全部班级及辅导员姓名
     *
     * @param className   班级名称
     * @param teacherName 辅导员名字
     * @param indexStr    开始页码
     * @param pageSize    页面大小
     * @return 班级信息
     */
    List<TBClass> selectByClassInfo(@Param("classname") String className,
                                    @Param("teachername") String teacherName,
                                    @Param("indexStr") int indexStr,
                                    @Param("pageSize") int pageSize);

    /**
     * 学生班级及其辅导员总条数
     *
     * @param className   班级名称
     * @param teacherName 辅导员名字
     * @return 班级信息
     */
    int selectByClassCount(@Param("classname") String className, @Param("teachername") String teacherName);

    /**
     * 更新班级信息
     *
     * @param tbClass 班级对象
     * @return true/false(成功/失败)
     */
    boolean updateByClassId(@Param("t_b_class") TBClass tbClass);

    /**
     * 添加班级
     *
     * @param tbClass 班级对象
     * @return true/false(成功/失败)
     */
    boolean insertClass(@Param("t_b_class") TBClass tbClass);

    /**
     * 删除班级
     *
     * @param ids 班级id
     * @return true/false(成功/失败)
     */
    boolean deleteByClassId(@Param("ids") String[] ids);
}