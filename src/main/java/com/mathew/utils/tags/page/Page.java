package com.mathew.utils.tags.page;

import java.util.List;

import com.mathew.utils.core.GetterUtil;

public class Page<E> {
    private int currentPage;//总页数
    private int totalCount;//总记录数
    private int pageSize = PageConstants.PAGES_SIZE;
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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return GetterUtil.getInteger(Math.ceil(totalCount / pageSize));
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}