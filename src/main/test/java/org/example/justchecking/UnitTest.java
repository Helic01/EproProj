package org.example.justchecking;

import org.example.model.*;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {

    @Test
    public void toStringTest(){
        Unit u1 = new Unit("subUnit1",3,new BusinessUnit("bu1",10,new Company()));
        u1.setId(1L);
        u1.addObjective(new Objective("obj1"));
        assertEquals("Unit{id=1, name='subUnit1', size=3, Parent-BusinessUnit=bu1, objectives=[BusinessUnit{id=null, name='obj1', Number of KeyResults=0}]}",u1.toString());
    }
}
