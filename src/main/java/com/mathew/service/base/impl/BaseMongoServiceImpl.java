package com.mathew.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mathew.dao.base.BaseDao;
import com.mathew.service.base.BaseService;
import com.mathew.utils.tags.page.Page;

public class BaseMongoServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> dao;

    @Override
    public void insert(T entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Query query) {
        dao.remove(query);
    }

    @Override
    public List<T> find(Query query) {
        return dao.find(query);
    }

    @Override
    public T findOne(Query query) {
        return dao.findOne(query);
    }

    @Override
    public void update(Query query, Update update) {
        dao.update(query, update);
    }

    @Override
    public void updateMulti(Query query, Update update) {
        dao.update(query, update);
    }

    @Override
    public T findById(String id) {
        return dao.findById(id);
    }

    @Override
    public long count(Query query) {
        return dao.count(query);
    }

    @Override
    public Page<T> getPage(int currentPage, Query query) {
        return dao.getPage(currentPage, query);
    }

}
