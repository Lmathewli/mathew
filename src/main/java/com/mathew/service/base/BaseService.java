package com.mathew.service.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.search.aggregator.Count;

public interface BaseService<T, ID extends Serializable> {
    public int add(T record);

    public int delete(ID id);

    public int deleteAll(T[] records);

    public int update(T record);

    public T find(ID id);

    public List<T> findAll();

    public int count();

    public List<T> selectPagination(Map<String, Integer> map);
}
