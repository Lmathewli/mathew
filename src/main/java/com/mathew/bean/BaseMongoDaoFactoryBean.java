package com.mathew.bean;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mathew.dao.impl.UserDao;

public class BaseMongoDaoFactoryBean extends AbstractFactoryBean<UserDao> {

    private Datastore ds;
    public Datastore getDs() {
        return ds;
    }

    public void setDs(Datastore ds) {
        this.ds = ds;
    }

    @Override
    protected UserDao createInstance() throws Exception {

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

}
