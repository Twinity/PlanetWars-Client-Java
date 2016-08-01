/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.util.ArrayList;

public class AI {
    public ArmyMovement[] doTurn(World world) {

        ArrayList<ArmyMovement> am = new ArrayList<>();

        for (Node node : world.getMyNodes()) {
            int dest = node.getAdjacents()[(int)(Math.round(Math.random() * node.getAdjacents().length))];
            am.add(new ArmyMovement(node.getId(), dest, node.getArmyCount() / ((int)Math.round(Math.random() * node.getArmyCount()))));
        }

        return am.toArray(new ArmyMovement[am.size()]);
    }
}
