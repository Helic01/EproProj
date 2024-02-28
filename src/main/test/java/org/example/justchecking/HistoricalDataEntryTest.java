package org.example.justchecking;

import org.example.model.BusinessUnit;
import org.example.model.HistoricalDataEntry;
import org.example.repository.BusinessUnitRepository;
import org.example.service.BusinessUnitService;
import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HistoricalDataEntryTest {

    @Test
    public void testNoComment(){
        HistoricalDataEntry hDE =  new HistoricalDataEntry(2.0,"");
        assertEquals(0.0,hDE.getValue());
        hDE =  new HistoricalDataEntry(2.0,"comment");
        assertEquals(2.0,hDE.getValue());
        hDE.setComment("");
        assertEquals("comment",hDE.getComment());
        assertEquals("BusinessUnit{id=null, value='2.0', comment=comment, date=}",hDE.toString());
    }

}
