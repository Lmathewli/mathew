package com.mathew.service.base.impl;

import java.io.Serializable;
import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;

import com.mathew.dao.impl.BaseMongoDaoImpl;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;
import com.mathew.utils.tags.page.Page;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class BaseMongoServiceImpl<T> implements BaseService<T> {

    @Autowired
    MongoClient mongoClient;
    @Autowired
    Morphia morphia;

    public BaseMongoDaoImpl<T> getDao() {
        BaseMongoDaoImpl<User> dao = new BaseMongoDaoImpl<User>(mongoClient, morphia, "mathew");
        return (BaseMongoDaoImpl<T>) dao;
    }

    @Override
    public Key<T> insert(T entity) {
        return getDao().save(entity);
    }

    @Override
    public WriteResult delete(Query<T> query) {
        return getDao().deleteByQuery(query);
    }

    @Override
    public List<Serializable> findList(Query<T> query) {
        return getDao().findIds(query);
    }

    @Override
    public T findOne(Query<T> query) {
        return getDao().findOne(query);
    }

    @Override
    public UpdateResults updateFirst(Query<T> query, UpdateOperations<T> update) {
        return getDao().updateFirst(query, update);
        
    }

    @Override
    public UpdateResults updateMulti(Query<T> query, UpdateOperations<T> update) {
        return getDao().update(query, update);
    }

    @Override
    public long count(Query<T> query) {
        return getDao().count(query);
    }

    @Override
    public Page<Serializable> getPage(int currentPage, int pageSize, Query<T> query) {
        return getDao().getPage(currentPage,pageSize, query);
    }

    @Override
    public Query<T> createQuery() {
        return getDao().createQuery();
    }
}
