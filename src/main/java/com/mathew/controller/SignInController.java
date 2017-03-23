package com.mathew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.IUserService;
import com.mathew.utils.core.ParamUtil;
import com.mathew.utils.tags.page.Page;
import com.mathew.utils.tags.page.PageConstants;
import com.mathew.utils.tags.page.PageUtil;


@Controller
public class SignInController extends BaseController {
    private static final String PAGINATION_CONTEXT = "paginationContext";

    @Autowired
    private IUserService userService;
    @Autowired
    private PageUtil<User> pageUtil;

    @RequestMapping("/signin")
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView();
        int currentPage = ParamUtil.get(request, PageConstants.CURRENT_PAGE, 0);
        Page<User> page = pageUtil.convertToPage(currentPage, userService, "/mathew/signin");

        modelAndView.setViewName("profile");
        modelAndView.addObject(PAGINATION_CONTEXT, page);

        return modelAndView;
    }
}
