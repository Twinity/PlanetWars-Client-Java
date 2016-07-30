/**
 * Created by Borderliner on 7/30/2016.
 */

package com.twinity.PlanetWars;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Spark.get("/hello", (req, res) -> {
            return "Hello";
        });
    }
}
