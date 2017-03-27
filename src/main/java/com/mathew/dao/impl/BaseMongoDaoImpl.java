package com.mathew.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mathew.dao.base.BaseDao;
import com.mathew.model.User;
import com.mathew.utils.core.GetterUtil;
import com.mathew.utils.tags.page.Page;
import com.mathew.utils.tags.page.PageConstants;
import com.mongodb.WriteResult;

@Repository
public class BaseMongoDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 注入mongodbTemplate
     *
     * @param mongoTemplate
     */
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public T save(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }

    @Override
    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    @Override
    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(this.getEntityClass());
    }

    @Override
    public List<T> findAll(String collectionName) {
        return mongoTemplate.findAll(this.getEntityClass(), collectionName);
    }

    @Override
    public List find(Query query) {
        return mongoTemplate.find(query, User.class);
    }

    @Override
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    @Override
    public Page<T> getPage(int currentPage, Query query) {
        Page<T> page = new Page<T>();
        // 获取总条数
        long totalCount = count(query);
        // 总页数
        page.setTotalCount(totalCount);
        long totalPage = page.getTotalPage();

        if (currentPage > totalPage) {
            currentPage = GetterUtil.getInteger(totalPage);
        }

        if (currentPage < 1) {
            currentPage = 1;
        }

        int skip = (currentPage - 1) * PageConstants.PAGES_SIZE;
        query.skip(skip);// skip相当于从那条记录开始
        query.limit(PageConstants.PAGES_SIZE);// 从skip开始,取多少条记录
        List<T> datas = this.find(query);
        page.setContext(datas);

        return page;
    }

    @Override
    public long count(Query query) {
        return mongoTemplate.count(query, this.getEntityClass());
    }

    @Override
    public WriteResult update(Query query, Update update) {
        if (update == null) {
            return null;
        }
        return mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    @Override
    public T updateOne(Query query, Update update) {
        if (update == null) {
            return null;
        }
        return mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    @Override
    public void remove(Query query) {
        mongoTemplate.remove(query, this.getEntityClass());
    }

    /**
     * 获得泛型类
     */
    private Class<T> getEntityClass() {
        return getSuperClassGenricType(getClass(), 0);
    }

    public static Class getSuperClassGenricType(final Class clazz,
            final int index) {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }

    @Override
    public WriteResult update(T entity) {
        // TODO Auto-generated method stub
        return null;
    }
}
