package com.mathew.utils.tags.page;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.mathew.utils.core.Validator;

public class PagesTags<T> extends TagSupport implements Serializable {

    private static final long serialVersionUID = 0;
    private int currentPage;
    private int totalPage;
    private String formId;
    private String url;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String url =   request.getPathInfo();
        int pre = currentPage - 1;
        int next = currentPage + 1;

        if (totalPage < 0) {
            return super.doStartTag();
        }

        try {
            out.print("<a href='"+ url +"?currentPage='" + pre + ">Previous</a>" + "total page:" + totalPage + "Current Page:"
            + currentPage + "<a href='"+ url +"?currentPage='" + next + ">Next</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.doStartTag();
    }
}
