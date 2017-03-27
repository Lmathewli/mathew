package com.mathew.utils.tags.page;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PagesTags<T> extends TagSupport implements Serializable {

    private static final long serialVersionUID = 0;
    private Page<T> paginationContext;

    public Page<T> getPaginationContext() {
        return paginationContext;
    }

    public void setPaginationContext(Page<T> paginationContext) {
        this.paginationContext = paginationContext;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        long pre = paginationContext.getCurrentPage() - 1;
        long next = paginationContext.getCurrentPage() + 1;

        if (paginationContext.getTotalPage() < 0) {
            return super.doStartTag();
        }

        try {
            out.print("<div class='page'><a href='javascript:go(" + pre + ")'>Previous</a>" + "total page:"
                    + paginationContext.getTotalPage() + "Current Page:"
                    + paginationContext.getCurrentPage() + "<a href='javascript:go(" + next + ")'>Next</a></div>");
            out.print(
                    "<script> function go(page) {if (page < 1) {alert('This is the first page.');} "
                            + "else if(page >'"
                            + paginationContext.getTotalPage()
                            + "') {alert('This is the last page.');} else {location.href='"
                            + paginationContext.getUrl() + "?currentPage=' + page;" 
                            + "}} </script>");
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return super.doStartTag();
    }
}
