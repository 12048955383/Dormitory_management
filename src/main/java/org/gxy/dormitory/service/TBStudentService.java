package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TBStudent;
import org.gxy.dormitory.util.Result;

import java.util.List;

/**
 * 学生信息(TBStudent)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-03-23 13:39:38
 */
public interface TBStudentService {

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
    List<TBStudent> studentInfo(String name, String mobile,
                                String qq, String dormName,
                                int indexStr, int pageSize);

    /**
     * 查询学生管理信息总数
     *
     * @return 学生管理信息总数
     */
    int studentCount(String name, String mobile, String qq, String dormName);

    /**
     * 更新学生信息
     *
     * @param student 学生对象
     * @return 更新信息
     */
    Result updateByStuId(TBStudent student);

    /**
     * 添加学生
     *
     * @param student 学生对象
     * @return true/false
     */
    Result addStudent(TBStudent student);

    /**
     * 删除学生
     *
     * @param ids 学生id
     * @return true/false(成功/失败)
     */
    Result deleteStudent(String[] ids);

    /**
     * 退舍
     *
     * @param stuId 学生id
     * @return 退舍信息
     */
    Result checkOut(String stuId);
}