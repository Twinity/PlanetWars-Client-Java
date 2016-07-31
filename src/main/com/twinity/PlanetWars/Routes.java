/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class Routes {

    public static World getServerState() throws IOException {
        URL url = new URL("http://localhost:" + ServerConfig.getServerPort() + "/serverdata");
        Gson gson = new Gson();

        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        World world = gson.fromJson(request.getContent().toString(), World.class);
        return world;
    }

    public static int sendState(ArmyMovement[] inArmyMovement) throws IOException {
        String url = "http://localhost:" + ServerConfig.getServerPort() + "/clientdata";
        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity postingString = new StringEntity(gson.toJson(inArmyMovement));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        return response.getStatusLine().getStatusCode();
    }
}
