package com.codecool.hackernews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
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
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.println(content);

        /*StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            buffer.append("<div>");
            buffer.append("<a href=\"/another?link_id=" + i + "\">");
            buffer.append("Hello " + i + ". link:");
            buffer.append("</a>");
            buffer.append("</div>");
        }

        String linkId = request.getParameter("link_id");

        out.println(
                "<html>\n" +
                        "  <head>" +
                        "    <title>Another page</title>" +
                        "    <script src='/static/js/main.js'></script>" +
                        "  </head>\n" +
                        "<body>\n" +
                        "  <h1>Hello CodeCooler!</h1>" +
                        (linkId == null ?
                                "<h3>No link was pressed</h3>" :
                                "<h3>Link " + linkId + " was pressed!</h3>") +
                        "  <br/>" +
                        "  <div>" + buffer.toString() + "</div>" +
                        "</body>" +
                        "</html>"
        );*/
    }
}
