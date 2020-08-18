package org.gxy.dormitory.service;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBClass;
import org.gxy.dormitory.util.Result;

import java.util.List;

/**
 * (TBClass)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-03-26 15:50:21
 */
public interface TBClassService {

    /**
     * 查询全部班级及辅导员姓名
     *
     * @param className   班级名称
     * @param teacherName 辅导员名字
     * @param indexStr    开始页码
     * @param pageSize    页面大小
     * @return 班级信息
     */
    List<TBClass> classInfo(String className, String teacherName, int indexStr, int pageSize);

    /**
     * 学生班级及其辅导员总条数
     *
     * @param className   班级名称
     * @param teacherName 辅导员名字
     * @return 班级信息
     */
    int classCount(String className, String teacherName);

    /**
     * 更新班级信息
     *
     * @param tbClass 班级对象
     * @return true/false(成功/失败)
     */
    Result updateClass(@Param("t_b_class") TBClass tbClass);
    /**
     * 添加班级
     *
     * @param tbClass 班级对象
     * @return true/false(成功/失败)
     */
    Result addClass(TBClass tbClass);
    /**
     * 删除班级
     *
     * @param ids 班级id
     * @return true/false(成功/失败)
     */
    Result deleteClass(String[] ids);
}