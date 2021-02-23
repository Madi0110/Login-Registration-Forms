package com.company;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LogFilter implements Filter {
    FileWriter fw;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        File f = new File("logs");

        if (f.exists()) {
            try {

                fw = new FileWriter(f, true);
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            try {
                fw = new FileWriter(f);
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        fw.write("----- ----- ----- -----\n");
        try {
            for (String s : servletRequest.getParameterMap().keySet()) {
                fw.write("Parameter " + s + ": "
                        + servletRequest.getParameter(s) + "\n");
            }
            for (Cookie c : ((HttpServletRequest) servletRequest).getCookies()) {
                fw.write("Cookie " + c.getName() + ": " + c.getValue() + "\n");
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        try {
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
