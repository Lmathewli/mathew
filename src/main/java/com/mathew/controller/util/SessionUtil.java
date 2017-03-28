package com.mathew.controller.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mathew.constants.MainConstants;
import com.mathew.model.User;

public class SessionUtil {

    public static User getCurrentUser() {
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        User user = (User) session.getAttribute(MainConstants.CURRENT_USER);

        return user;
    }
}
