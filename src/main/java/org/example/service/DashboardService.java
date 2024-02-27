package org.example.service;

import org.example.model.KeyResult;
import org.example.model.Objective;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DashboardService {

    @Autowired
    private ObjectiveService objectiveService;

    @Autowired
    private KeyResultService keyResultService;

    public void printDashboard() {
        List<Objective> objectives = objectiveService.getAllObjectives();
        double objectiveProgress = 0;
        for (Objective objective : objectives) {
            objectiveProgress = calculateObjectiveProgress(objective);
            System.out.println("Progress for Objective: " + objective.getName() + " is at " + objectiveProgress + "%.");
        }
    }

    private double calculateObjectiveProgress(@NotNull Objective objective) {
        List<KeyResult> keyResults = objective.getKeyResults();
        double totalPercentage = 0.0;
        for (KeyResult keyResult : keyResults) {
            totalPercentage += keyResult.getProgress();
            System.out.println("Progress for KeyResult: " + keyResult.getName() + " is at " + keyResult.getProgress() + "%.");
        }
        return totalPercentage/keyResults.size(); //man sollte nie durch 0 teilen können, wenn du aber angst hast kannst du hier nochmal was dran machen
    }

    public void printKeyResultObjective(@NotNull Objective objective){
        List<KeyResult> keyResults = objective.getKeyResults();
        double totalPercentage = 0.0;
        for (KeyResult keyResult : keyResults) {
            totalPercentage += keyResult.getProgress();
        }
        System.out.println("Total Progress of Objective "+objective.getName()+": "+totalPercentage);
        for (KeyResult keyResult : keyResults) {
            System.out.println("     Progress for KeyResult: " + keyResult.getName() + " is at " + keyResult.getProgress() + "%.");
        }
    }

}
