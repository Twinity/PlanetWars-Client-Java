/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import java.util.ArrayList;

public class AI {
    public ArmyMovement[] doTurn(World world) {

        ArrayList<ArmyMovement> move = new ArrayList<>();
        move.add(new ArmyMovement(101, 102, 20));

        return move.toArray(new ArmyMovement[move.size()]);
    }
}
