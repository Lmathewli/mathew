package com.mathew.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;
import com.mathew.utils.Annotation.Password;

@Controller
public class signup extends BaseController {

    @Autowired
    private BaseService<User> userService;

    @RequestMapping("/signup")
    public ModelAndView signUp(@Password String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");
        return modelAndView;
    }
}
