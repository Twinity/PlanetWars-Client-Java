/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

import spark.Spark;

public class Server {

    public Server() {
        setConfigs();
    }

    public void setConfigs() {
        Spark.port(ServerConfig.getPort());
    }
}
