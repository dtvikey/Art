package com.imooc.art.web;


import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: dtvikey
 * @Date: 26/11/18 下午 05:04
 * @Version 1.0
 * 字符集过滤器
 */
public class CharsetEncodingFilter implements Filter {

    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
