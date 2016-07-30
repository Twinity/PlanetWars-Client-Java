/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

public class ServerConfig {
    private static int _port = 0;
    private static int _minThreads = 2;
    private static int _maxThreads = 8;
    private static int _timeOutMillis = 3000;

    public static int getPort() {
        return _port;
    }

    public static int getMinThreads() {
        return _minThreads;
    }

    public static int getMaxThreads() {
        return _maxThreads;
    }

    public static int getTimeout() {
        return _timeOutMillis;
    }

}
