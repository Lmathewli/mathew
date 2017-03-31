package com.mathew.controller.signin;

import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.constants.MainConstants;
import com.mathew.controller.base.BaseController;
import com.mathew.controller.signin.constants.Constants;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;
import com.mathew.utils.core.Validator;

@Controller
public class SignInController extends BaseController {

    @Autowired
    private BaseService<User> userService;

    @RequestMapping(MainConstants.URL_HOME)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) session.getAttribute(MainConstants.CURRENT_USER);

        if (Validator.isNotNull(user)) {
            modelAndView.addObject(MainConstants.CURRENT_USER, user);
        }
        return modelAndView;
    }

    @RequestMapping("/signin")
    public ModelAndView signin(User paramUser) {
        ModelAndView modelAndView = new ModelAndView();
        Query<User> query = userService.createQuery();
        query.criteria(Constants.EMAIL_ADDRESS).equal(paramUser.getEmailAddress()).criteria(Constants.PASSWORD).equal(paramUser.getPassword());
        User user = userService.findOne(query);

        if (Validator.isNull(user)) {
            modelAndView.setViewName(MainConstants.PATH_HOME);
            modelAndView.addObject(Constants.USER, paramUser);

            return modelAndView;
        }

        modelAndView.addObject(Constants.USER, user);
        session.setAttribute(MainConstants.CURRENT_USER, user);
        modelAndView.setViewName("user/profile");

        return modelAndView;
    }
}
