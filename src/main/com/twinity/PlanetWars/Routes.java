/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.*;

public class Routes {

    public static World getServerState() {
        URL url;
        String data = "";

        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/serverdata");
            data = HttpRequest.get(url).header("X-Request-ID", Server.getMyId()).body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        World world = new Gson().fromJson(data, World.class);
        return world;
    }

    public static int sendState(ArmyMovement[] inArmyMovement) {
        URL url;

        String jsonToSend = new Gson().toJson(inArmyMovement);
        int status = 500;
        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/clientdata");
            status = HttpRequest.post(url)
                    .contentType("application/json")
                    .send(jsonToSend.getBytes())
                    .header("X-Request-ID", Server.getMyId())
                    .code();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int getIdFromServer() {
        URL url;
        String data = "";

        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/getid");
            data = HttpRequest.get(url).body();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        return Integer.parseInt(data);
    }

}
