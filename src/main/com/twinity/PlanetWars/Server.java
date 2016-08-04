/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

import java.io.IOException;
import java.net.ConnectException;

public class Server {

    private static int myId = 0;

    public Server() {
        try {
            runServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void runServer() throws IOException {
        AI ai = new AI();
        World world;
        myId = Routes.getIdFromServer();

        if(myId == 0) {
            throw new ConnectException();
        }

        do {
            world = Routes.getServerState();
            ArmyMovement[] movementList = ai.doTurn(world);
            String response = Routes.sendState(movementList);
            if (!response.equals("OK")) {
                System.out.println("Server returned illegal token.");
                ServerConfig.setClientRetryTimes(ServerConfig.getClientRetryTimes() - 1);
            }

            if (ServerConfig.getClientRetryTimes() == 0) {
                System.out.println("Server is not responding. Shutting down...");
                System.exit(1);
            }
        }
        while (world.getCurrentTurn() <= world.getTotalTurns());
    }

    public static int getMyId() {
        return myId;
    }
}
