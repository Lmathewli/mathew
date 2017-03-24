package com.mathew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.constants.MainConstants;
import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.IUserService;
import com.mathew.utils.tags.page.PageUtil;


@Controller
public class SignInController extends BaseController {

    @Autowired
    private IUserService userService;
    @Autowired
    private PageUtil<User> pageUtil;

    @RequestMapping(MainConstants.URL_HOME)
    public String home() {
        return MainConstants.PATH_HOME;
    }

    @RequestMapping("/signin")
    public ModelAndView signin(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");

        return modelAndView;
    }
}
