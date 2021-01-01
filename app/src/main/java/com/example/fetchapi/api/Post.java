package com.example.fetchapi.api;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post {
    private URL url;
    private HttpURLConnection con;

    private String login;
    private String pass;

    public Post(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Response apiConnect() throws IOException {
        url = new URL("http://10.0.2.2:3000/test/login/post");
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        try {
            TestUser user = new TestUser(login, pass);

            Gson g = new Gson();
            String jsonInputString = g.toJson(user);

            try (
                    OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                System.out.println(response);

            String json = response.toString();

            Gson g = new Gson();
            Response res = g.fromJson(json, Response.class);

            System.out.println(res.getMessage());
            System.out.println(res.getRole());
            return res;
            }
        }
    }
}
