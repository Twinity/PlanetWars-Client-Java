/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.io.*;
import java.net.URL;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.*;

public class Routes {

    public static World getServerState() {
        URL url;
        String data = "";

        try {
            url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/serverdata");
            data = HttpRequest.get(url).body();
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
            status = HttpRequest.post(url).contentType("application/json").send(jsonToSend.getBytes()).code();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}
