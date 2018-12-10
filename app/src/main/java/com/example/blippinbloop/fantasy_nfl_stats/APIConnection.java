package com.example.blippinbloop.fantasy_nfl_stats;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

@RequiresApi(api = Build.VERSION_CODES.O)
public class APIConnection {

    private String url;
    private String JSONResult;

    public APIConnection(String url){
        this.url = url;
        this.JSONResult = getJSON(url);
    }


    private String getJSON(String urlString){
        try {
            URL url = new URL(urlString);

            String originalInput = "24f2e9c8-7320-4657-b04e-807e4d:MYSPORTSFEEDS";
            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encodedString);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(content));
            String line;

            line = in.readLine();

            return line;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
