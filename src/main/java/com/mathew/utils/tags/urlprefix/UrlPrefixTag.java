package com.mathew.utils.tags.urlprefix;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class UrlPrefixTag extends TagSupport implements Serializable{
    private final Logger LOG = Logger.getLogger(UrlPrefixTag.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String path = request.getContextPath();  
        String urlPrefix = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        try {
            writer.print(urlPrefix);
        } catch (IOException e) {
            LOG.error("[Mathew][Exception]Io exception, please check it.", e);
        }
        return super.doStartTag();
    }
}
