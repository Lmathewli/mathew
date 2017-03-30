package com.mathew.utils.tags.page;

import java.io.Serializable;

import org.mongodb.morphia.query.Query;
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
    public Page<Serializable> convertToPageTage(Query<T> query, int currentPage, BaseService<T> iService, String url) {
        Page<Serializable> page = iService.getPage(currentPage, PageConstants.PAGES_SIZE ,query);
        page.setUrl(url);

        return page;
    }
}
