package com.mathew.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mathew.dao.base.BaseDao;
import com.mathew.service.base.impl.BaseMongoServiceImpl;

@Service
public class UserServiceImpl<User> extends BaseMongoServiceImpl<User> {

    @Autowired
    private BaseDao<User> dao;

    @Override
    public void insert(User entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Query query) {
        dao.remove(query);
    }

    @Override
    public List<User> find(Query query) {
        return dao.find(query);
    }

    @Override
    public User findOne(Query query) {
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
    public User findById(String id) {
        return dao.findById(id);
    }

    @Override
    public long count(Query query) {
        return dao.count(query);
    }

}
