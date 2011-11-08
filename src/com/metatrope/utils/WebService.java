package com.metatrope.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WebService {
    public static String get(String serviceURL) {
        StringBuilder response = new StringBuilder();
        InputStreamReader isr = null;
        BufferedReader in = null;
        try
        {
            URL url = new URL(serviceURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("Content-Type",
                    "text/xml; charset=utf-8");
            conn.setRequestMethod("GET");
            conn.setDoOutput(false);
            conn.setDoInput(true);

            // Read the response and write it to standard out.
            isr = new InputStreamReader(conn.getInputStream());
            in = new BufferedReader(isr);
            String line = null;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } catch (Exception e) {
            throw new CheckedExceptionsAreStupidException(e);
        }
    }
}
