package com.codecool.hackernews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "hackerNewsServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class HackerNewServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "Michael Hackson news";

        out.println(
                "<html>\n" +
                        "<head>" +
                        "  <title>" + title + "</title>" +
                        "  <link rel=\"stylesheet\" type=\"text/css\" href='/static/css/site.css' />" +
                        "<script src='/static/js/main.js' defer></script>" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul id=\"nav-bar\">\n" +
                        "<li id=\"main-page\"><b>Hackson News</b>" + "\n" +
                        "<li id=\"top-news\"><b>Top News</b>" + "\n" +
                        "<li id=\"newest\"><b>Newest</b>" + "\n" +
                        "<li id=\"jobs\"><b>Jobs</b>" + "\n" +
                        "</ul>\n" +
                        "<div id=\"nav-buttons\">" +
                        "<button id=\"prev\" data-current-page=\"1\">Previous</button>" +
                        "<button id=\"next\" data-current-page=\"1\">Next</button>" +
                        "</div>" +
                        "<div id=\"content\"></div>" +
                        "<footer>" +
                        "<p>Dev: Barnabás Mayer</p>" + "\n" +
                        "<p><a href=\"mailto:barna.m42@gmail.com\">barna.m42@gmail.com</a>" + "\n" +
                        "</footer>" +
                        "</body></html>"
        );
    }
}
