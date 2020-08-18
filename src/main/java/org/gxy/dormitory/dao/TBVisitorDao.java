package org.gxy.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.gxy.dormitory.entity.TBVisitor;

import java.util.Date;
import java.util.List;

/**
 * 访客信息(TBVisitor)表数据库访问层
 *
 * @author 孙鹏轩
 * @since 2020-04-01 14:01:50
 */
public interface TBVisitorDao {
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
    List<TBVisitor> selectByVisitor(@Param("visitorname") String visitorName,
                                    @Param("name") String name,
                                    @Param("relationship") String relationship,
                                    @Param("starttime") Date startTime,
                                    @Param("endtime") Date endTime,
                                    @Param("indexStr") int indexStr,
                                    @Param("pageSize") int pageSize);

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
    int selectByvisitorCount(@Param("visitorname") String visitorName,
                             @Param("name") String name,
                             @Param("relationship") String relationship,
                             @Param("starttime") Date startTime,
                             @Param("endtime") Date endTime);

    /**
     * 添加访客
     *
     * @param visitor 访客对象
     * @return true/false
     */
    boolean insertVisitor(@Param("t_b_visitor") TBVisitor visitor);

    /**
     * 修改访客
     *
     * @param visitor 访客对象
     * @return true/false
     */
    boolean updateVisitor(@Param("t_b_visitor") TBVisitor visitor);
    /**
     * 删除访客
     *
     * @param ids 访客id
     * @return true/false
     */
    boolean deleteVisitor(@Param("ids") String[] ids);
}