package org.gxy.dormitory.service;

import org.gxy.dormitory.entity.TBVisitor;
import org.gxy.dormitory.util.Result;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 访客信息(TBVisitor)表服务接口
 *
 * @author 孙鹏轩
 * @since 2020-04-01 14:01:50
 */
public interface TBVisitorService {
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
    List<TBVisitor> visitorList(String visitorName,
                                String name,
                                String relationship,
                                Date startTime,
                                Date endTime,
                                int indexStr,
                                int pageSize) throws ParseException;

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
    int visitorCount(String visitorName,
                     String name,
                     String relationship,
                     Date startTime,
                     Date endTime);

    /**
     * 添加访客
     *
     * @param visitor 访客对象
     * @return true/false
     */
    Result addVisitor(TBVisitor visitor) throws ParseException;

    /**
     * 修改访客
     *
     * @param visitor 访客对象
     * @return true/false
     */
    Result updateVisitor(TBVisitor visitor) throws ParseException;

    /**
     * 删除访客
     *
     * @param ids 访客id
     * @return true/false
     */
    Result deleteVisitor(String[] ids);
}