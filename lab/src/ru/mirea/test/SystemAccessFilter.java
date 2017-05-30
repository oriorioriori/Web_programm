package ru.mirea.test;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by Денис on 13.05.2017.
 */
public class SystemAccessFilter implements Filter {
    private FilterConfig filterConfig;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (filterConfig == null){
            return;
        }
        ServletContext ctx = filterConfig.getServletContext();
        String logged = (String)((HttpServletRequest)request).getSession().getAttribute("isLogged");
        if (!"true".equals(logged)){
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/MainServlet/SignIn");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/MainServlet/Website");
            dispatcher.forward(request, response);
        }
    }
    public void init(FilterConfig config)  throws ServletException {
        this.filterConfig = config;
    }
    public void destroy() { }
}