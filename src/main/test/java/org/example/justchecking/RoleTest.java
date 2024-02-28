package org.example.justchecking;

import org.example.model.*;
import org.example.model.Objective;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    @Test
    public void toStringTest(){
        Role r1 = new Role("CEO");
        r1.setId(1L);
        assertEquals("Role{id=1, name='CEO'}",r1.toString());
    }
}
