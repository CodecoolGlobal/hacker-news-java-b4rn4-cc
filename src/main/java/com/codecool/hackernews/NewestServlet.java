package com.codecool.hackernews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "newest", urlPatterns = "/newest")
public class NewestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        URL url = new URL("https://api.hnpwa.com/v0/newest/1.json");
        StringBuffer content = Util.getStringifiedJson(url);

        PrintWriter out = response.getWriter();

        out.println(content);
    }
}
