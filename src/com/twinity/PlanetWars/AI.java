package com.twinity.PlanetWars;

import java.util.ArrayList;

/**
 * Created by Golsa on 7/31/2016.
 */
public class AI {
    public ArmyMovement[] doTurn() {

        ArrayList<ArmyMovement> move = new ArrayList<>();
        move.add(new ArmyMovement(101, 102, 20));

        return move.toArray(new ArmyMovement[move.size()]);
    }
}
