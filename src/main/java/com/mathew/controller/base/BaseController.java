package com.mathew.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    public static final Logger LOGGER = Logger.getLogger(BaseController.class);

}
