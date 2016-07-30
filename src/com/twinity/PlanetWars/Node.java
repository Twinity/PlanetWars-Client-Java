/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

public class Node {

    private int id;
    private int armyCount;
    private int owner;
    private int[] adjacents;

    // Getters
    public int getId() {
        return id;
    }

    public int getArmyCount() {
        return armyCount;
    }

    public int getOwner() {
        return owner;
    }

    public int[] getAdjacents() {
        return adjacents;
    }

}
