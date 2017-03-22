package com.mathew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.IUserService;


@Controller
public class SignInController extends BaseController {
    private static String USERS = "users";

    @Autowired
    private IUserService userService;

    @RequestMapping("/signin")
    public ModelAndView signin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profile");
        List<User> users = userService.findAll();
        mv.addObject(USERS, users);

        return mv;

    }
}
