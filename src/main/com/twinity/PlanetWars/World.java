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
    private int myId;
    private int opponentId;
    private int neutralId;

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
        return getTotalTurns() - getCurrentTurn();
    }

    public int getMyId() {
        return myId;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public int getNeutralId() {
        return neutralId;
    }

}
