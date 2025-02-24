package com.stage.controller;

import com.stage.entity.Stage;
import com.stage.entity.EtatStage;
import com.stage.entity.TypeStage;
import com.stage.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    // CRUD endpoints

    @GetMapping
    public List<Stage> getAllStages() {
        return stageService.getAllStages();
    }

    @GetMapping("/{id}")
    public Stage getStageById(@PathVariable Long id) {
        return stageService.getStageById(id);
    }

    @PostMapping("/add")
    public Stage createStage(@RequestBody Stage stage) {
        return stageService.createStage(stage);
    }

    @PutMapping("/{id}")
    public Stage updateStage(@PathVariable Long id, @RequestBody Stage stageDetails) {
        return stageService.updateStage(id, stageDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageService.deleteStage(id);
    }

    // Search and Sort endpoints

    @GetMapping("/search/intitule")
    public List<Stage> searchByIntitule(@RequestParam String intitule) {
        return stageService.searchByIntitule(intitule);
    }

    @GetMapping("/search/technologies")
    public List<Stage> searchByTechnologies(@RequestParam String technologies) {
        return stageService.searchByTechnologies(technologies);
    }

    @GetMapping("/search/etatStage")
    public List<Stage> searchByEtatStage(@RequestParam EtatStage etatStage) {
        return stageService.searchByEtatStage(etatStage);
    }

    @GetMapping("/search/typeStage")
    public List<Stage> searchByTypeStage(@RequestParam TypeStage typeStage) {
        return stageService.searchByTypeStage(typeStage);
    }

    @GetMapping("/search/dateDebut")
    public List<Stage> searchByDateDebut(@RequestParam LocalDate dateDebut) {
        return stageService.searchByDateDebut(dateDebut);
    }

    @GetMapping("/search/dateFin")
    public List<Stage> searchByDateFin(@RequestParam LocalDate dateFin) {
        return stageService.searchByDateFin(dateFin);
    }

    @GetMapping("/sort/dateDebut")
    public List<Stage> sortByDateDebutAsc() {
        return stageService.sortByDateDebutAsc();
    }

    @GetMapping("/sort/dateFin")
    public List<Stage> sortByDateFinAsc() {
        return stageService.sortByDateFinAsc();
    }

    @GetMapping("/search/dateDebutBetweenAndEtatStage")
    public List<Stage> findByDateDebutBetweenAndEtatStage(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam EtatStage etatStage) {
        return stageService.findByDateDebutBetweenAndEtatStage(startDate, endDate, etatStage);
    }
}