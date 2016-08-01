/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.io.IOException;
import java.net.URL;

import com.google.gson.*;
import okhttp3.*;

public class Routes {

    private static final OkHttpClient client = new OkHttpClient();

    public static World getServerState() {
        URL url;
        String data = "";

        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/serverdata");
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("X-Request-ID", String.valueOf(Server.getMyId()))
                    .build();
            Response response = client.newCall(request).execute();

            data = response.body().string();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        World world = new Gson().fromJson(data, World.class);
        return world;
    }

    public static String sendState(ArmyMovement[] inArmyMovement) {
        URL url;
        String data = "";
        String jsonToSend = new Gson().toJson(inArmyMovement);
        final MediaType JSON_TYPE =
                MediaType.parse("application/json");

        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/clientdata");
            Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(JSON_TYPE, jsonToSend))
                    .addHeader("X-Request-ID", String.valueOf(Server.getMyId()))
                    .build();
            Response response = client.newCall(request).execute();

            data = response.body().string();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public static int getIdFromServer() {
        URL url;
        String data = "";

        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/getid");
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            data = response.body().string();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Integer.parseInt(data);
    }

}
