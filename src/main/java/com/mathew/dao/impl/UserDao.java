package com.mathew.dao.impl;

import java.io.Serializable;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.mathew.model.User;
public class UserDao extends BasicDAO<User, Serializable> {

    public UserDao(Datastore ds) {
        super(ds);
    }
}
