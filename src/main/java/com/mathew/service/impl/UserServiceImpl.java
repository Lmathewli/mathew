package com.mathew.service.impl;

import java.io.Serializable;
import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathew.constants.MainConstants;
import com.mathew.dao.impl.UserDao;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;
import com.mathew.utils.tags.page.Page;
import com.mongodb.WriteResult;
@Service
public class UserServiceImpl implements BaseService<User> {

    @Autowired
    private UserDao dao;

    @Override
    public Key<User> insert(User entity) {
        return dao.save(entity);
    }

    @Override
    public WriteResult delete(Query<User> query) {
        return dao.deleteByQuery(query);
    }

    @Override
    public User FindOne(String id) {
        Query<User> query = createQuery();
        query.criteria(MainConstants.ID_MODEL).equal(id);
        return this.findOne(query);
    }

    @Override
    public List<Serializable> findList(Query<User> query) {
        return dao.findIds(query);
    }

    @Override
    public User findOne(Query<User> query) {
        return dao.findOne(query);
    }

    @Override
    public UpdateResults updateFirst(Query<User> query, UpdateOperations<User> update) {
        return dao.updateFirst(query, update);
        
    }

    @Override
    public UpdateResults updateMulti(Query<User> query, UpdateOperations<User> update) {
        return dao.update(query, update);
    }

    @Override
    public long count(Query<User> query) {
        return dao.count(query);
    }


    @Override
    public Query<User> createQuery() {
        return dao.createQuery();
    }

    @Override
    public Page<Serializable> getPage(int currentPage, int pageSize, Query<User> query) {
        long totalCount = this.count(query);
        query.fetch(new FindOptions().skip(currentPage).limit(pageSize));
        List<Serializable> list = findList(query);
        Page<Serializable> page = new Page<>();
        page.setContext(list);
        page.setTotalCount(totalCount);

        return page;
    }

    @Override
    public UpdateOperations<User> createUpdateOperations() {
        return dao.createUpdateOperations();
    }
}
