package com.mathew.preference.service;

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
import com.mathew.preference.dao.PreferenceDao;
import com.mathew.preference.model.Preference;
import com.mathew.service.base.BaseService;
import com.mathew.utils.tags.page.Page;
import com.mongodb.WriteResult;
@Service
public class PreferenceService implements BaseService<Preference> {

    @Autowired
    private PreferenceDao dao;

    @Override
    public Key<Preference> insert(Preference entity) {
        return dao.save(entity);
    }

    @Override
    public WriteResult delete(Query<Preference> query) {
        return dao.deleteByQuery(query);
    }

    @Override
    public List<Serializable> findList(Query<Preference> query) {
        return dao.findIds(query);
    }

    @Override
    public Preference FindOne(String id) {
        Query<Preference> query = createQuery();
        query.criteria(MainConstants.ID_MODEL).equal(id);
        return this.findOne(query);
    }

    @Override
    public Preference findOne(Query<Preference> query) {
        return dao.findOne(query);
    }

    @Override
    public UpdateResults updateFirst(Query<Preference> query, UpdateOperations<Preference> update) {
        return dao.updateFirst(query, update);
        
    }

    @Override
    public UpdateResults updateMulti(Query<Preference> query, UpdateOperations<Preference> update) {
        return dao.update(query, update);
    }

    @Override
    public long count(Query<Preference> query) {
        return dao.count(query);
    }


    @Override
    public Query<Preference> createQuery() {
        return dao.createQuery();
    }

    @Override
    public Page<Serializable> getPage(int currentPage, int pageSize, Query<Preference> query) {
        long totalCount = this.count(query);
        query.fetch(new FindOptions().skip(currentPage).limit(pageSize));
        List<Serializable> list = findList(query);
        Page<Serializable> page = new Page<>();
        page.setContext(list);
        page.setTotalCount(totalCount);

        return page;
    }

    @Override
    public UpdateOperations<Preference> createUpdateOperations() {
        return dao.createUpdateOperations();
    }
}
