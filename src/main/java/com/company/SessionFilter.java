package com.company;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie cookie = null;

        try {
            for (Cookie c : ((HttpServletRequest) servletRequest).getCookies()) {
                System.out.println(c.getName() + " : " + c.getValue());
                if (c.getName().equals("JSESSIONID")) {
                    cookie = c;
                    break;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        if (cookie != null) {
            cookie.setMaxAge(1800);
        }



        filterChain.doFilter(servletRequest, servletResponse);
    }

}
