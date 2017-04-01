package com.mathew.controller.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;

@Controller
public class signup extends BaseController {

    @Autowired
    private BaseService<User> userService;

    @RequestMapping("/signup")
    public ModelAndView signUp(User user) {
        ModelAndView modelAndView = new ModelAndView();
        user.setPreferenceId("1");
        userService.insert(user);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
