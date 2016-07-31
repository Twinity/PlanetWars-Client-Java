/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.io.*;
import java.net.URL;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.*;

public class Routes {

    public static World getServerState() throws IOException {
        URL url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/serverdata");
        String data = "";

        try {
            data = HttpRequest.get(url).body();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        World world = new Gson().fromJson(data, World.class);
        return world;
    }

    public static int sendState(ArmyMovement[] inArmyMovement) {
        String _url = "http://localhost:" + ServerConfig.getServerPort() + "/clientdata";
        URL url;

        String jsonToSend = new Gson().toJson(inArmyMovement);
        int status = 500;
        try {
            url = new URL(_url);
            status = HttpRequest.post(url).send(jsonToSend.getBytes()).code();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}
