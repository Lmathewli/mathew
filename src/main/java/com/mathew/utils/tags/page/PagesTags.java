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
        int pre = paginationContext.getCurrentPage() - 1;
        int next = paginationContext.getCurrentPage() + 1;

        if (paginationContext.getTotalPage() < 0) {
            return super.doStartTag();
        }

        try {
            out.print("<a href='javascript:go(" + pre + ")'>Previous</a>" + "total page:"
                    + paginationContext.getTotalPage() + "Current Page:"
                    + paginationContext.getCurrentPage() + "<a href='javascript:go(" + next + ")'>Next</a>");
            out.print(
                    "<script> function go(currentPage) {if (currentPage < 1) {alert('This is the first page.');} "
                            + "else if(currentPage >'"
                            + paginationContext.getTotalPage()
                            + "') {alert('This is the last page.');}}} else {location.href='"
                            + paginationContext.getUrl() + "?currentPage=" + paginationContext.getCurrentPage()
                            + "'} </script>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return super.doStartTag();
    }
}
