package org.example.justchecking;

import org.example.model.Objective;
import org.example.repository.ObjectiveRepository;
import org.example.service.ObjectiveService;
import org.testng.annotations.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        // Create a mock Objective object
        Objective mockObjective = new Objective();
        mockObjective.setId(1L);
        mockObjective.setName("Test Objective");
        mockObjective.setProgress(0.5);
        // Mock the behavior of the ObjectiveRepository
        when(objectiveRepository.findById(1L)).thenReturn(java.util.Optional.of(mockObjective));
        // Test the getObjectById method
        Objective retrievedObjective = objectiveService.getObjectiveById(1L);
        // Verify that the retrieved objective matches the mock objective
        assertEquals(mockObjective, retrievedObjective);
    }

    // Add more test methods for other service methods as needed
}
