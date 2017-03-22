package com.mathew.dao;

import java.io.Serializable;
import java.util.List;

import com.mathew.dao.base.BaseDao;
import com.mathew.model.User;

public interface IUserDao extends BaseDao<User, Serializable>{
    void save(User user);

    int update(User user);

    boolean delete(int id);

    User findById(int id);

    List<User> findAll();
}
