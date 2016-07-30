/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import spark.Spark;

public class Server {

    public Server() {
        setConfigs();
    }

    public void setConfigs() {
        Spark.port(ServerConfig.getPort());
        // Config Logger
        BasicConfigurator.configure();
        // Turn off log4j logs in console
        Logger.getLogger("org").setLevel(Level.OFF);
        Logger.getLogger("akka").setLevel(Level.OFF);
    }
}
