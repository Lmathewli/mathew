package com.mathew.service.base;

import java.io.Serializable;
import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mathew.utils.tags.page.Page;
import com.mongodb.WriteResult;

public interface BaseService<T> {
    public Key<T> insert(T entity);

    public WriteResult delete(Query<T> query);

    public List<Serializable> findList(Query<T> query);

    public T findOne(Query<T> query);

    public UpdateResults updateFirst(Query<T> query, UpdateOperations<T> update);

    public UpdateResults updateMulti(Query<T> query, UpdateOperations<T> update);

    public long count(Query<T> query);

    public Page<Serializable> getPage(int currentPage, int pageSize, Query<T> query);

    public Query<T> createQuery();
}
