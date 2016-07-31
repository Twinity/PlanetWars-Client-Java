/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

public class ServerConfig {

    private static int _serverPort = 4000;
    private static int _clientRetryTimes = 5;

    public static int getServerPort() {
        return _serverPort;
    }

    public static int getClientRetryTimes() {
        return _clientRetryTimes;
    }

    public static void setClientRetryTimes(int inTimes) {
        if (_clientRetryTimes >= 0) {
            _clientRetryTimes = inTimes;
        }
    }

}
