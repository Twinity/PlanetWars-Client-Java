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

        do {
            try {
                url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/serverdata");
                Request request = new Request.Builder()
                        .url(url)
                        .addHeader("X-Request-ID", String.valueOf(Server.getMyId()))
                        .build();
                Response response = client.newCall(request).execute();

                data = response.body().string();

                if (data.equals("wait")) {
                    Thread.sleep(1000);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (data.equals("wait"));

        World world = new Gson().fromJson(data, World.class);
        return world;
    }

    public static String sendState(ArmyMovement[] inArmyMovement) {
        URL url;
        String data = "";
        int retryCount = ServerConfig.getClientRetryTimes();
        String jsonToSend = new Gson().toJson(inArmyMovement);
        final MediaType JSON_TYPE =
                MediaType.parse("application/json");

        do {
            try {
                url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/clientdata");
                Request request = new Request.Builder()
                        .url(url)
                        .post(RequestBody.create(JSON_TYPE, jsonToSend))
                        .addHeader("X-Request-ID", String.valueOf(Server.getMyId()))
                        .build();
                Response response = client.newCall(request).execute();

                data = response.body().string();

                return data;
            } catch (Exception ex) {
                if (--retryCount == 0) {
                    System.out.println("Server not responding. Shutting down...");
                    System.exit(1);
                }
                System.out.println("Could not connect to server. Retrying...");
                try {
                    Thread.sleep(2000);
                } catch (Exception ex2) {ex2.printStackTrace();}
            }
        } while (retryCount != 0);

        return "";
    }

    public static int getIdFromServer() {
        URL url;
        String data = "";
        int retryCount = ServerConfig.getClientRetryTimes();

        do {
            try {
                url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/getid");
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = client.newCall(request).execute();
                data = response.body().string();

                return Integer.parseInt(data);
            } catch (Exception ex) {
                if (--retryCount == 0) {
                    System.out.println("Server not responding. Shutting down...");
                    System.exit(1);
                }
                System.out.println("Could not connect to server. Retrying...");
                try {
                    Thread.sleep(2000);
                } catch (Exception ex2) {ex2.printStackTrace();}
            }
        } while (retryCount != 0);

        return 0;
    }

}
