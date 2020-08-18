package org.gxy.dormitory.util;

import lombok.Data;

/**
 * 分页工具类
 *
 * @auther 孙鹏轩
 * @date 2020-03-27
 */
@Data
public class Paging {
    /**
     * 页码
     */
    private int page;
    /**
     * 页面大小
     */
    private int rows;
    /**
     * 开始页码
     */
    private int indexStr;
    /**
     * 总条数
     */
    private int total;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 获取页面大小
     * @return 页面大小
     */
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 获取首页
     * @return 首页
     */
    public int getIndexStr() {
        //计算开始页
        int indexStr = (page - 1) * rows;
        return indexStr;
    }

    public void setIndexStr(int indexStr) {
        this.indexStr = indexStr;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
