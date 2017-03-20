package com.mathew.dao;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.mathew.dao.base.BaseDao;
import com.mathew.model.User;

public interface IUserDao extends BaseDao<User, Serializable>{

}
