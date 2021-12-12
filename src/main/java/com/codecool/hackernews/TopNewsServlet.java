package com.codecool.hackernews;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "anotherServlet", urlPatterns = {"/top-news"}, loadOnStartup = 2)
public class TopNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String requestPage = request.getParameter("page");
        String page;
        page = Objects.requireNonNullElse(requestPage, "1");
        URL url = new URL("https://api.hnpwa.com/v0/news/" + page +".json");
        StringBuffer content = Util.getStringifiedJson(url);
        // serialization
        Type listType = new TypeToken<ArrayList<News>>(){}.getType();
        List<News> newsList = new Gson().fromJson(String.valueOf(content), listType);

        Gson gson = new Gson();
        String fullJson = gson.toJson(newsList);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(fullJson);
    }
}
