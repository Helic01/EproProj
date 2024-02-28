package org.example.controller;

import org.example.model.Objective;
import org.example.service.CompanyService;
import org.example.service.DashboardService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {


    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @RequestMapping("/Objectives")
    public void printDashboard(){
        dashboardService.printDashboard();
    }

    @RequestMapping("/KeyResults")
    public void printKeyResultObjective(@NotNull Objective objective){
        dashboardService.printKeyResultObjective(objective);
    }

}
