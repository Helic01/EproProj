package org.example.justchecking;

import org.example.model.BusinessUnit;
import org.example.model.Company;
import org.example.model.Objective;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyTest {

    @Test
    public void toStringTest(){
        Company c1 = new Company();
        c1.setName("Google");
        c1.setId(1L);
        c1.setSize(420);
        c1.addObjective(new Objective("googling"));
        assertEquals("BusinessUnit{id=1, name='Google', size=420, objectives=[BusinessUnit{id=null, name='googling', Number of KeyResults=0}]}",c1.toString());
    }
}
