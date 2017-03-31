package com.mathew.bean;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mathew.dao.impl.BaseMongoDaoImpl;

public class BaseMongoDaoFactoryBean extends AbstractFactoryBean<BaseMongoDaoImpl> {

    private Datastore ds;
    public Datastore getDs() {
        return ds;
    }

    public void setDs(Datastore ds) {
        this.ds = ds;
    }

    @Override
    protected BaseMongoDaoImpl createInstance() throws Exception {

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

}
