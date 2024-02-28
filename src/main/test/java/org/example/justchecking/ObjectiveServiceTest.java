package org.example.justchecking;

import org.example.model.*;
import org.example.repository.ObjectiveRepository;
import org.example.service.ObjectiveService;
import org.testng.annotations.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ObjectiveServiceTest {

    @Mock
    private ObjectiveRepository objectiveRepository;

    @InjectMocks
    private ObjectiveService objectiveService;

    public ObjectiveServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetObjectById() {
        Objective mockObjective = new Objective();
        mockObjective.setId(1L);
        mockObjective.setName("Test Objective");
        when(objectiveRepository.findById(1L)).thenReturn(java.util.Optional.of(mockObjective));
        Objective retrievedObjective = objectiveService.getObjectiveById(1L);
        assertEquals(mockObjective, retrievedObjective);
    }
}
