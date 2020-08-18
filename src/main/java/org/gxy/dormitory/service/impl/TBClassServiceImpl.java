package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TBClassDao;
import org.gxy.dormitory.entity.TBClass;
import org.gxy.dormitory.service.TBClassService;
import org.gxy.dormitory.util.Result;
import org.gxy.dormitory.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * (TBClass)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-03-26 15:50:21
 */
@Service("tBClassService")
public class TBClassServiceImpl implements TBClassService {

    @Autowired
    private TBClassDao tbClassDao;

    //结果信息实体类
    private Result re = new Result();

    /**
     * 查询全部班级及辅导员姓名
     *
     * @param className 班级名称
     * @param indexStr  开始页码
     * @param pageSize  页面大小
     * @return 班级信息
     */
    @Override
    public List<TBClass> classInfo(String className, String teacherName, int indexStr, int pageSize) {
        List<TBClass> classList = tbClassDao.selectByClassInfo(className, teacherName, indexStr, pageSize);
        return classList;
    }

    /**
     * 学生班级及其辅导员总条数
     *
     * @param className 班级名称
     * @return 班级信息
     */
    @Override
    public int classCount(String className, String teacherName) {
        int i = tbClassDao.selectByClassCount(className, teacherName);
        return i;
    }

    /**
     * 更新班级信息
     *
     * @param tbClass 班级对象
     * @return true/false(成功/失败)
     */
    @Override
    public Result updateClass(TBClass tbClass) {
        boolean b = tbClassDao.updateByClassId(tbClass);
        if (b == false) {
            re.setMsg("修改失败");
            re.setSuccess(false);
        }
        re.setMsg("修改成功");
        return re;
    }

    /**
     * 添加班级
     *
     * @param tbClass 班级对象
     * @return true/false(成功/失败)
     */
    @Override
    public Result addClass(TBClass tbClass) {
        tbClass.setId(UUIDUtils.getUUID());
        tbClass.setCreatetime(new Date());
        boolean b = tbClassDao.insertClass(tbClass);
        if (b == false) {
            re.setMsg("添加失败");
            re.setSuccess(false);
        }
        re.setMsg("添加成功");
        return re;
    }

    /**
     * 删除班级
     *
     * @param ids 班级id
     * @return true/false(成功/失败)
     */
    @Override
    @Transactional
    public Result deleteClass(String[] ids) {
        boolean b = tbClassDao.deleteByClassId(ids);
        if (b == false) {
            re.setMsg("删除失败");
            re.setSuccess(false);
        }
        re.setMsg("删除成功");
        return re;
    }

}