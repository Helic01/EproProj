package org.example.controller;

import org.example.model.Objective;
import org.example.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/objectives")
public class ObjectiveController {

    @Autowired
    private ObjectiveService objectiveService;

    @GetMapping("/{id}")
    public Objective getObjectById(@PathVariable Long id) {
        return objectiveService.getObjectiveById(id);
    }

    @PostMapping
    public Objective createObjective(@RequestBody Objective objective) {
        return objectiveService.createObjective(objective);
    }

    @PutMapping("/{id}")
    public Objective updateObjective(@PathVariable Long id, @RequestBody Objective objective) {
        return objectiveService.updateObjective(id, objective);
    }

    @DeleteMapping("/{id}")
    public void deleteObjective(@PathVariable Long id) {
        objectiveService.deleteObjective(id);
    }
}
