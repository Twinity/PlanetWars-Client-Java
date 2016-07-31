/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

public class World {

    private Node[] myNodes;
    private Node[] allNodes;
    private Node[] opponentNodes;
    private Node[] freeNodes;
    private int totalTurns;
    private int currentTurn;
    private int remainingTurns;

    public Node[] getMyNodes() {
        return myNodes;
    }

    public Node[] getAllNodes() {
        return allNodes;
    }

    public Node[] getOpponentNodes() {
        return opponentNodes;
    }

    public Node[] getFreeNodes() {
        return freeNodes;
    }

    public int getTotalTurns() {
        return totalTurns;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

}
