package com.mathew.dao.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T, ID extends Serializable> {
    public int insert(T record);

    public int delete(ID id);

    public int deleteAll(T[] records);

    public int update(T record);

    public T select(ID id);

    public List<T> selectAll();

    public int count();

    public List<T> selectPagination(int currentPage, int pageSize);

}
