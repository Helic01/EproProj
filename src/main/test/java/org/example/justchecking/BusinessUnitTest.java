package org.example.justchecking;

import org.example.model.BusinessUnit;
import org.example.model.Company;
import org.example.model.Objective;
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

public class BusinessUnitTest {

    @Mock
    private BusinessUnitRepository businessUnitRepository;

    @InjectMocks
    private BusinessUnitService businessUnitService;

    public BusinessUnitTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void t0(){ //getBusinessUnitById
        BusinessUnit mockObjective1 = new BusinessUnit();
        mockObjective1.setId(1L); mockObjective1.setName("Test Businessunit1");
        BusinessUnit mockObjective2 = new BusinessUnit();
        mockObjective1.setId(2L); mockObjective1.setName("Test Businessunit2");
        // Mock the behavior of the ObjectiveRepository
        when(businessUnitRepository.findById(1L)).thenReturn(java.util.Optional.of(mockObjective1));
        // Test the getObjectById method
        BusinessUnit retrievedObjective = businessUnitService.getBusinessUnitById(1L);
        // Verify that the retrieved objective matches the mock objective
        assertEquals(mockObjective1, retrievedObjective);
    }

    @Test
    public void toStringTest(){
        BusinessUnit bu1 = new BusinessUnit("bu1",4,new Company());
        bu1.setId(1L);
        bu1.getCompany().setName("abc");
        bu1.addObjective(new Objective("obj1"));
        assertEquals("BusinessUnit{id=1, name='bu1', size=4, company=BusinessUnit{id=null, name='abc', size=0, objectives=[]}, objectives=[BusinessUnit{id=null, name='obj1', Number of KeyResults=0}]}",bu1.toString());
    }



}
