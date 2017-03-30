package com.mathew.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;

import com.mathew.utils.tags.page.Page;
import com.mongodb.MongoClient;

public class BaseMongoDaoImpl<T> extends BasicDAO<T, Serializable> {

    public BaseMongoDaoImpl(MongoClient mongoClient, Morphia morphia,
            String dbName) {
        super(mongoClient, morphia, dbName);
    }

    public Page<Serializable> getPage(int currentPage, int pageSize, Query<T> query) {
        long totalCount = this.count(query);
        query.fetch(new FindOptions().skip(currentPage).limit(pageSize));
        List<Serializable> list = findIds(query);
        Page<Serializable> page = new Page<>();
        page.setContext(list);
        page.setTotalCount(totalCount);

        return page;
    }
}
