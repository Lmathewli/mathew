package com.mathew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.constants.MainConstants;
import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;
import com.mathew.utils.core.ParamUtil;
import com.mathew.utils.tags.page.Page;
import com.mathew.utils.tags.page.PageConstants;
import com.mathew.utils.tags.page.PageUtil;


@Controller
public class SignInController extends BaseController {

    @Autowired
    private BaseService<User> userService;
    @Autowired
    private PageUtil<User> pageUtil;

    @RequestMapping(MainConstants.URL_HOME)
    public String home() {
        return MainConstants.PATH_HOME;
    }

    @RequestMapping("/signin")
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView();
        int currentPage = ParamUtil.get(request, PageConstants.CURRENT_PAGE, 0);
        Query query = new Query(Criteria.where("_class").is("com.mathew.model.User"));
        Page<User> page = pageUtil.convertToPage(query, currentPage, userService, "/mathew/signin");

        modelAndView.setViewName("profile");
        modelAndView.addObject(PageConstants.PAGINATION_CONTEXT, page);
        
        return modelAndView;
    }
}
