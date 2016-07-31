/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

import java.io.IOException;

public class Server {

    public Server() {
        try {
            runServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
