/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

public class ArmyMovement {

    private int source;
    private int destination;
    private int armyCount;

    public ArmyMovement(int inSource, int inDestination, int inArmyCount) {
        this.source = inSource;
        this.destination = inDestination;
        this.armyCount = inArmyCount;
    }

    public ArmyMovement() {
        this.source = 0;
        this.destination = 0;
        this.armyCount = 0;
    }

    public int getSource() {
        return this.source;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getArmyCount() {
        return this.armyCount;
    }

    public void setSource(int inSource) {
        if (inSource > 0)
            this.source = inSource;
    }

    public void setDestination(int inDestination) {
        if (inDestination > 0)
            this.destination = inDestination;
    }

    public void setArmyCount(int inArmyCount) {
        if (inArmyCount > 0)
            this.armyCount = inArmyCount;
    }

}
