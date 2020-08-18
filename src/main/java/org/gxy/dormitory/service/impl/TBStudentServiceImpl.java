package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TBStudentDao;
import org.gxy.dormitory.entity.TBDorm;
import org.gxy.dormitory.entity.TBStudent;
import org.gxy.dormitory.service.TBStudentService;
import org.gxy.dormitory.util.Result;
import org.gxy.dormitory.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 学生信息(TBStudent)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-03-23 13:39:38
 */
@Service("tBStudentService")
public class TBStudentServiceImpl implements TBStudentService {

    @Autowired
    private TBStudentDao tBStudentDao;
    //结果信息实体类
    private Result re = new Result();

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
    @Override
    public List<TBStudent> studentInfo(String name, String mobile, String qq, String dormName, int indexStr, int pageSize) {
        List<TBStudent> studentList = tBStudentDao.selectByStudentInfo(name, mobile, qq, dormName, indexStr, pageSize);
        return studentList;
    }

    /**
     * 查询学生管理信息总数
     *
     * @return 学生管理信息总数
     */
    @Override
    public int studentCount(String name, String mobile, String qq, String dormName) {
        int i = tBStudentDao.selectByStudentCount(name, mobile, qq, dormName);
        return i;
    }

    /**
     * 更新学生信息
     *
     * @param student 学生对象
     * @return 更新信息
     */
    @Override
    @Transactional
    public Result updateByStuId(TBStudent student) {
        //查询改学生的信息
        TBStudent selectByStuId = tBStudentDao.selectByStuId(student.getId());
        //查询修改之前学生宿舍信息
        TBDorm beForeDorm = tBStudentDao.selectByDormId(selectByStuId.getDormid());
        //查询到更新的宿舍信息数据
        TBDorm dorm = tBStudentDao.selectByDormId(student.getDormid());
        //判断现在的宿舍id，是否与修改之前的宿舍id相同
        if (!dorm.getId().equals(beForeDorm.getId())) {
            //已经使用床位(更新之前)
            Integer used = dorm.getUsed();
            //更新之后
            Integer beForeUsed = beForeDorm.getUsed();
            //总数床位
            Integer total = dorm.getTotal();
            if (used == total) {
                re.setMsg("该宿舍床位已满,请重新选择");
                re.setSuccess(false);
                return re;
            }
            used++;
            beForeUsed--;
            dorm.setUsed(used);
            beForeDorm.setUsed(beForeUsed);
            //更新当前数据
            tBStudentDao.updateByDormId(dorm);
            //更新原来的数据
            tBStudentDao.updateByDormId(beForeDorm);
        }
        tBStudentDao.updateByStuId(student);
        re.setMsg("修改成功");
        return re;
    }

    /**
     * 添加学生
     *
     * @param student 学生对象
     * @return 添加结果信息
     */
    @Override
    @Transactional
    public Result addStudent(TBStudent student) {
        //查询当前宿舍信息
        TBDorm dorm = tBStudentDao.selectByDormId(student.getDormid());
        //判断当前宿舍，宿舍位够不够
        Integer used = dorm.getUsed();
        Integer total = dorm.getTotal();
        if (used == total) {
            re.setMsg("该宿舍床位已满,请重新选择");
            re.setSuccess(false);
            return re;
        }
        dorm.setUsed(++used);
        tBStudentDao.updateByDormId(dorm);
        //添加id
        student.setId(UUIDUtils.getUUID());
        //添加创建日期
        student.setCreatetime(new Date());
        //添加学生信息
        tBStudentDao.insertStu(student);
        re.setMsg("添加成功");
        return re;
    }

    /**
     * 删除学生
     *
     * @param ids 学生id
     * @return true/false(成功/失败)
     */
    @Override
    @Transactional
    public Result deleteStudent(String[] ids) {
        boolean b = tBStudentDao.deleteByStuId(ids);
        if (b == false) {
            re.setMsg("删除失败");
            re.setSuccess(false);
        }
        re.setMsg("删除成功");
        return re;
    }

    /**
     * 退舍
     *
     * @param stuId 学生id
     * @return 退舍信息
     */
    @Override
    @Transactional
    public Result checkOut(String stuId) {
        TBStudent tbStudent = tBStudentDao.selectByStuId(stuId);
        //原始宿舍
        TBDorm beForedorm = tBStudentDao.selectByDormId(tbStudent.getDormid());
        //获取原宿舍使用床位
        Integer beForedormUsed = beForedorm.getUsed();
        beForedormUsed--;
        beForedorm.setUsed(beForedormUsed);
        tBStudentDao.updateByDormId(beForedorm);
        //退舍
        TBDorm dorm = tBStudentDao.selectByDormId("1");
        //获取退舍使用床位
        Integer dormUsed = dorm.getUsed();
        dormUsed++;
        dorm.setUsed(dormUsed);
        tBStudentDao.updateByDormId(dorm);
        //退舍id
        tbStudent.setDormid("1");
        //更新学生信息
        tBStudentDao.updateByStuId(tbStudent);
        re.setMsg("退舍成功");
        return re;
    }

}