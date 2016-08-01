/**
 * Created by Borderliner on 7/31/2016.
 */

package com.twinity.PlanetWars;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class RoutesTest {

    @Test
    public void testGetServerState() throws IOException {
        World world = Routes.getServerState();
        System.out.println(world.getAllNodes()[0].getId());
        Assert.assertSame(world.getAllNodes().getClass(), Node[].class);
    }

    @Test
    public void testSendState() throws IOException {
        ArmyMovement[] am = new ArmyMovement[3];
        am[0] = new ArmyMovement(101, 102, 20);
        am[1] = new ArmyMovement(103, 105, 10);
        am[2] = new ArmyMovement(104, 101, 5);
        String response = Routes.sendState(am);
        Assert.assertEquals("OK", response);
    }

    @Test
    public void testGetId() {
        int idFromServer = Routes.getIdFromServer();
        Assert.assertEquals(569, idFromServer);
    }
}
