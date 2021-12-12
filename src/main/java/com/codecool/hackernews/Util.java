package com.codecool.hackernews;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static StringBuffer getStringifiedJson(URL url) throws IOException {
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
        return content;
    }

    static void setupJson(HttpServletResponse response, URL url) throws IOException {
        StringBuffer content = getStringifiedJson(url);

        Type listType = new TypeToken<ArrayList<News>>(){}.getType();
        List<News> newsList = new Gson().fromJson(String.valueOf(content), listType);

        Gson gson = new Gson();
        String fullJson = gson.toJson(newsList);

        PrintWriter out = response.getWriter();

        out.println(fullJson);
    }
}
