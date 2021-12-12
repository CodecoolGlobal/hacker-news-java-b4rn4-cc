package com.codecool.hackernews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@WebServlet(name = "newest", urlPatterns = "/newest")
public class NewestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String requestPage = request.getParameter("page");
        String page;
        page = Objects.requireNonNullElse(requestPage, "1");

        URL url = new URL("https://api.hnpwa.com/v0/newest/" + page + ".json");

        Util.setupJson(response, url);
    }
}
