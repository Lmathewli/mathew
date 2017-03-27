package com.mathew.service.base;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mathew.utils.tags.page.Page;

public interface BaseService<T> {
    public void insert(T entity);

    public void delete(Query query);

    public List<T> find(Query query);

    public T findOne(Query query);

    public void update(Query query, Update update);

    public void updateMulti(Query query, Update update);

    public T findById(String id);

    public long count(Query query);

    public Page<T> getPage(int currentPage, Query query);
}
