package com.mathew.dao.impl;

import java.io.Serializable;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.mathew.model.User;
public class BaseMongoDaoImpl extends BasicDAO<User, Serializable> {

    public BaseMongoDaoImpl(Datastore ds) {
        super(ds);
    }
}
