package org.example.service;

import org.example.model.Objective;
import org.example.repository.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectiveService {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    public List<Objective> getAllObjectives() {
        return objectiveRepository.findAll();
    }

    public Objective getObjectiveById(Long id) {
        Optional<Objective> objectiveOptional = objectiveRepository.findById(id);
        return objectiveOptional.orElse(null);
    }

    public Objective createObjective(Objective objective) {
        if (objective.getKeyResults().size() < 3) {
            throw new IllegalArgumentException("Objectives must have at least three Key Results.");
        }
        if (objective.getKeyResults().size() > 5) {
            throw new IllegalArgumentException("Objectives can only have up to five Key Results.");
        }
        return objectiveRepository.save(objective);
    }

    public Objective updateObjective(Long id, Objective newObjective) {
        Optional<Objective> optionalObjective = objectiveRepository.findById(id);
        if (optionalObjective.isPresent()) {
            Objective existingObjective = optionalObjective.get();
            existingObjective.setName(newObjective.getName());
            //existingObjective.setCompany(newObjective.getCompany());
            return objectiveRepository.save(existingObjective);
        } else {
            return null;
        }
    }

    public void deleteObjective(Long id) {
        objectiveRepository.deleteById(id);
    }
}
