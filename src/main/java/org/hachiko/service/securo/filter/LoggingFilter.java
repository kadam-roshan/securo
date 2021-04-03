package org.hachiko.service.securo.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {
    static Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.info(String.format("%s %s from %s", httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI(), httpServletRequest.getRemoteAddr()));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
