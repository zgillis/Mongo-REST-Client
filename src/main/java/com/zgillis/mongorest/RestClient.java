package com.zgillis.mongorest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {

    static final String USER_AGENT = "Mozilla/5.0";

    public static JsonObject getApi(String restUrl) throws IOException {
        URL url = new URL(restUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String curLine;
        StringBuffer response = new StringBuffer();

        while ((curLine = in.readLine()) != null) {
            response.append(curLine);
        }
        in.close();

        JsonParser parser = new JsonParser();
        JsonObject parsedResponse = (JsonObject)parser.parse(response.toString());
        return parsedResponse;
    }
}
