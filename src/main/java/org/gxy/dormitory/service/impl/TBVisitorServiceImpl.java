package org.gxy.dormitory.service.impl;

import org.gxy.dormitory.dao.TBVisitorDao;
import org.gxy.dormitory.entity.TBVisitor;
import org.gxy.dormitory.service.TBVisitorService;
import org.gxy.dormitory.util.Result;
import org.gxy.dormitory.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 访客信息(TBVisitor)表服务实现类
 *
 * @author 孙鹏轩
 * @since 2020-04-01 14:01:50
 */
@Service("tBVisitorService")
public class TBVisitorServiceImpl implements TBVisitorService {
    @Autowired
    private TBVisitorDao tBVisitorDao;

    //结果信息实体类
    private Result re = new Result();

    /**
     * 查询访客
     *
     * @param visitorName  访客名字
     * @param name         被访问着名字
     * @param relationship 访客与被访问者关系
     * @param startTime    进入时间
     * @param endTime      结束时间
     * @param indexStr     开始页码
     * @param pageSize     页面大小
     * @return 访客信息
     */
    @Override
    public List<TBVisitor> visitorList(String visitorName, String name, String relationship, Date startTime, Date endTime, int indexStr, int pageSize) throws ParseException {
        if (startTime != null && endTime != null) {
            List<TBVisitor> visitorList = tBVisitorDao.selectByVisitor(visitorName, name, relationship, startTime, endTime, indexStr, pageSize);
        }
        List<TBVisitor> visitorList = tBVisitorDao.selectByVisitor(visitorName, name, relationship, startTime, endTime, indexStr, pageSize);
        return visitorList;
    }

    /**
     * 查询访客总数
     *
     * @param visitorName  访客名字
     * @param name         被访问着名字
     * @param relationship 访客与被访问者关系
     * @param startTime    进入时间
     * @param endTime      结束时间
     * @return 访客总数
     */
    @Override
    public int visitorCount(String visitorName, String name, String relationship, Date startTime, Date endTime) {
        int count = tBVisitorDao.selectByvisitorCount(visitorName, name, relationship, startTime, endTime);
        return count;
    }

    /**
     * 添加访客
     *
     * @param visitor 访客对象
     * @return true/false
     */
    @Override
    public Result addVisitor(TBVisitor visitor) throws ParseException {
        visitor.setId(UUIDUtils.getUUID());
        visitor.setCreatetime(new Date());
        boolean b = tBVisitorDao.insertVisitor(visitor);
        if (b == false) {
            re.setMsg("添加失败");
            re.setSuccess(false);
        }
        re.setMsg("添加成功");
        return re;
    }

    /**
     * 修改访客
     *
     * @param visitor 访客对象
     * @return true/false
     */
    @Override
    public Result updateVisitor(TBVisitor visitor) throws ParseException {
        boolean b = tBVisitorDao.updateVisitor(visitor);
        if (b == false) {
            re.setMsg("修改失败");
            re.setSuccess(false);
        }
        re.setMsg("修改成功");
        return re;
    }

    /**
     * 删除访客
     *
     * @param ids 访客id
     * @return true/false
     */
    @Override
    public Result deleteVisitor(String[] ids) {
        boolean b = tBVisitorDao.deleteVisitor(ids);
        if (b == false) {
            re.setMsg("删除失败");
            re.setSuccess(false);
        }
        re.setMsg("删除成功");
        return re;
    }
}