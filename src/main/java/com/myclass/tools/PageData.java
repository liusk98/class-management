package com.myclass.tools;

import java.util.List;

/**
 * 分页控件
 *
 * @param <E>
 * @author joe
 */
public class PageData<E> {

    private long total;

    private List<E> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }
}
