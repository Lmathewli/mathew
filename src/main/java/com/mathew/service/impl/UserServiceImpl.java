package com.mathew.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathew.dao.IUserDao;
import com.mathew.model.User;
import com.mathew.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int add(User record) {
        return userDao.insert(record);
    }

    @Override
    public int delete(Serializable id) {
        return userDao.delete(id);
    }

    @Override
    public int deleteAll(User[] records) {
        return userDao.deleteAll(records);
    }

    @Override
    public int update(User record) {
        return userDao.update(record);
    }

    @Override
    public User find(Serializable id) {
        return userDao.select(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.selectAll();
    }
}
