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
import com.mathew.utils.core.GetterUtil;
import com.mathew.utils.tags.page.Page;
import com.mathew.utils.tags.page.PageConstants;
@Repository
public class BaseMongoDaoImpl<T> implements BaseDao<T>{

    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public void insert(T entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void delete(Query query){
        mongoTemplate.remove(query, getClazz());
    }

    @Override
    public List<T> find(Query query) {
        return mongoTemplate.find(query, getClazz());
    }

    @Override
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, getClazz());
    }

    @Override
    public void update(Query query, Update update) {  
        mongoTemplate.findAndModify(query, update, getClazz());
    }

    //批量更新
    @Override
    public void updateMulti(Query query, Update update) {  
        mongoTemplate.updateMulti(query, update, getClazz());  
    }

    @Override
    public T findById(String id) {
        return mongoTemplate.findById(id, getClazz());  
    }

    @Override
    public long count(Query query){
        return mongoTemplate.count(query, getClazz());
    }

    @SuppressWarnings("unchecked")
    public Class<T> getClazz() {
        Class<T> clazz = null;
        Type genericSuperclass = getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType) {
            //参数化类型  
            ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;  
            //返回表示此类型实际类型参数的 Type 对象的数组  
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();  
            clazz= (Class<T>) actualTypeArguments[0];  
        }else{  
            clazz= (Class<T>)genericSuperclass;  
        }

        return clazz;  
    }

    @Override
    public Page<T> getPage(int currentPage, Query query) {
        Page<T> page = new Page<T>();
        //获取总条数  
        long totalCount = count(query);
        //总页数  
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
}
