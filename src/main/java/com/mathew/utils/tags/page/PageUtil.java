package com.mathew.utils.tags.page;

import org.springframework.data.mongodb.core.query.Query;
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
    public Page<T> convertToPage(Query query, int currentPage, BaseService<T> iService, String url) {
        Page<T> page = iService.getPage(currentPage, query);

        page.setUrl(url);

        return page;
    }
}
