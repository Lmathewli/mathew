package com.mathew.utils.tags.page;

import java.util.List;

import com.mathew.utils.core.GetterUtil;

public class Page<E> {
    private long currentPage;//总页数
    private long totalCount;//总记录数
    private long pageSize = PageConstants.PAGES_SIZE;
    private List<E> context;

    private String url;

    public List<E> getContext() {
        return context;
    }

    public void setContext(List<E> context) {
        this.context = context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return GetterUtil.getInteger(Math.ceil(totalCount / pageSize));
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

}