package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "homeServlet",
        urlPatterns = "/home"
)
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c = new Cookie("test", "cookie");
        c.setMaxAge(1000);
        resp.addCookie(c);
        resp.addCookie(new Cookie("hello", "world"));
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
