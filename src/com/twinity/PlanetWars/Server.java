/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import spark.Spark;

import java.io.IOException;

public class Server {

    public Server() {
        setConfigs();
        try {
            runServer();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void setConfigs() {
        Spark.port(ServerConfig.getPort());
        // Config Logger
        BasicConfigurator.configure();
        // Turn off log4j logs in console
        Logger.getLogger("org").setLevel(Level.OFF);
        Logger.getLogger("akka").setLevel(Level.OFF);
    }

    private void runServer() throws IOException {
        AI ai = new AI();
        World world = new World();

        while (true) {
            world = Routes.getServerState();
            ArmyMovement[] movementList = ai.doTurn(world);
            int status = Routes.sendState(movementList);
            if (status != 200) {
                System.out.println("Server is not responding...");
                ServerConfig.setClientRetryTimes(ServerConfig.getClientRetryTimes() - 1);
            }

            if (ServerConfig.getClientRetryTimes() == 0) {
                System.out.println("Server is not responding. Shutting down...");
                break;
            }
        }
    }
}
