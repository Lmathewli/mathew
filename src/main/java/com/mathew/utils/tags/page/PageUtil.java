package com.mathew.utils.tags.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mathew.service.base.BaseService;
@Component
public class PageUtil<T> {
    /**
     * combine pagination.
     * @param currentPage
     * @param iService
     * @param url
     * <h2>Page<User> page = pageUtil.convertToPage(currentPage, userService, "/mathew/signin");</h2>
     * @return
     */
    public Page<T> convertToPage(int currentPage, BaseService<T, Serializable> iService, String url) {
        Map<String, Integer> map = new HashMap<>();
        Page<T> page = new Page<>();
        page.setUrl(url);
        int recordTotal = iService.count();
        page.setTotalCount(recordTotal);
        int totalPage = page.getTotalPage();

        if (currentPage > totalPage) {
            currentPage = totalPage;
        }

        if (currentPage < 1) {
            currentPage = 1;
        }
        page.setCurrentPage(currentPage);
        map.put(PageConstants.CURRENT, currentPage * PageConstants.PAGES_SIZE);
        map.put(PageConstants.PAGES_SIZE_STRING, PageConstants.PAGES_SIZE);
        List<T> list = iService.selectPagination(map);
        page.setContext(list);

        return page;
    }
}
