package com.mathew.dao;

import java.util.List;

import com.mathew.model.User;

public interface IUserDao {
    void save(User user);

    boolean update(User user);

    boolean delete(int id);

    User findById(int id);

    List<User> findAll();
}
