package org.example.justchecking;

import org.example.model.BusinessUnit;
import org.example.model.HistoricalDataEntry;
import org.example.model.KeyResult;
import org.example.repository.BusinessUnitRepository;
import org.example.service.BusinessUnitService;
import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyResultTest {

    @Test
    public void testNoComment(){
        KeyResult kR = new KeyResult("abc",0.0,10.0);
        assertEquals("abc",kR.getName());
        assertEquals(0.0,kR.getCurrent());
        assertEquals(10.0,kR.getGoal());

        kR.setGoal(-1.0);
        assertEquals(10.0,kR.getGoal());

        kR.setCurrent(1.0,"");
        assertEquals(0.0,kR.getCurrent());

        kR.setCurrent(1.0,"def");
        assertEquals(1.0,kR.getCurrent());
    }
}
