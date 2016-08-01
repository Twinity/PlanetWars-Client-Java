/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import com.google.gson.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import spark.Spark;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestRunner {

    public static World world;
    static Gson gson = new Gson();

    public static void main(String[] args) {
        world = new World();
        Spark.port(ServerConfig.getServerPort());

        runSparkServer();

        Result result = JUnitCore.runClasses(RoutesTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
    public static String readJson() {
        String content = "";
        try{
            content = new Scanner(new File(System.getProperty("user.dir") + "\\serverdata.json")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return content;
    }

    public static void runSparkServer() {
        Spark.get("/serverdata", (req, res) -> {
            res.header("Content-type", "application/json");
            res.body(readJson());
            return res.body();
        });

        Spark.post("/clientdata", (req, res) -> {
            ArmyMovement[] am = gson.fromJson(req.body(), ArmyMovement[].class);
            res.body("OK");
            return res.body();
        });

        Spark.get("/getid", (req, res) -> {
            res.body("569");
            return res.body();
        });
    }

}
