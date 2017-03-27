package com.mathew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mathew.constants.MainConstants;
import com.mathew.controller.base.BaseController;
import com.mathew.model.User;
import com.mathew.service.base.BaseService;
import com.mathew.utils.core.ParamUtil;
import com.mathew.utils.tags.page.PageConstants;
import com.mathew.utils.tags.page.PageUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

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
        DBObject dbObject = new BasicDBObject();
        // dbObject.put("name", "zhangsan"); //查询条件

        BasicDBObject fieldsObject = new BasicDBObject();
        // 指定返回的字段
        fieldsObject.put("emailAddress", true);
        Query query = new BasicQuery(dbObject, fieldsObject);
        // Page<User> page = pageUtil.convertToPage(query, currentPage,
        // userService, "/mathew/signin");
        List<User> page = userService.find(query);
        modelAndView.setViewName("profile");
        modelAndView.addObject(PageConstants.PAGINATION_CONTEXT, page);

        return modelAndView;
    }
}
