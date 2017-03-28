package com.mathew.controller.util;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mathew.controller.signin.constants.Constants;
import com.mathew.model.User;

public class QueryUtil {
    public static Query getSignInQuery(User user) {
        Query query = new Query(Criteria.where(Constants.EMAIL_ADDRESS).is(user.getEmailAddress())
                .and(Constants.PASSWORD).is(user.getPassword()));
        return query;
    }
}
