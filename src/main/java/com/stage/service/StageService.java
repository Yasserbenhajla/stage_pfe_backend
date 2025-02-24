package com.stage.service;

import com.stage.entity.Stage;
import com.stage.entity.EtatStage;
import com.stage.entity.TypeStage;
import com.stage.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StageService {

    @Autowired
    private StageRepository stageRepository;

    // CRUD operations

    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    public Stage getStageById(Long id) {
        return stageRepository.findById(id).orElse(null);
    }

    public Stage createStage(Stage stage) {
        return stageRepository.save(stage);
    }

    public Stage updateStage(Long id, Stage stageDetails) {
        Stage stage = stageRepository.findById(id).orElse(null);
        if (stage != null) {
            stage.setIntitule(stageDetails.getIntitule());
            stage.setDescription(stageDetails.getDescription());
            stage.setEtatSujet(stageDetails.getEtatSujet());
            stage.setDateDebut(stageDetails.getDateDebut());
            stage.setDateFin(stageDetails.getDateFin());
            stage.setTechnologiesEtOutils(stageDetails.getTechnologiesEtOutils());
            stage.setEtatStage(stageDetails.getEtatStage());
            stage.setLieuStage(stageDetails.getLieuStage());
            stage.setPaysStage(stageDetails.getPaysStage());
            stage.setEncadrantAcademique(stageDetails.getEncadrantAcademique());
            stage.setEncadrantEntreprise(stageDetails.getEncadrantEntreprise());
            stage.setEntreprise(stageDetails.getEntreprise());
            stage.setEtudiant(stageDetails.getEtudiant());
            stage.setTypeStage(stageDetails.getTypeStage());
            return stageRepository.save(stage);
        }
        return null;
    }

    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }

    // Search and Sort operations

    public List<Stage> searchByIntitule(String intitule) {
        return stageRepository.findByIntituleContaining(intitule);
    }

    public List<Stage> searchByTechnologies(String technologies) {
        return stageRepository.findByTechnologiesEtOutilsContaining(technologies);
    }

    public List<Stage> searchByEtatStage(EtatStage etatStage) {
        return stageRepository.findByEtatStage(etatStage);
    }

    public List<Stage> searchByTypeStage(TypeStage typeStage) {
        return stageRepository.findByTypeStage(typeStage);
    }

    public List<Stage> searchByDateDebut(LocalDate dateDebut) {
        return stageRepository.findByDateDebut(dateDebut);
    }

    public List<Stage> searchByDateFin(LocalDate dateFin) {
        return stageRepository.findByDateFin(dateFin);
    }

    public List<Stage> sortByDateDebutAsc() {
        return stageRepository.findAllByOrderByDateDebutAsc();
    }

    public List<Stage> sortByDateFinAsc() {
        return stageRepository.findAllByOrderByDateFinAsc();
    }

    public List<Stage> findByDateDebutBetweenAndEtatStage(LocalDate startDate, LocalDate endDate, EtatStage etatStage) {
        return stageRepository.findByDateDebutBetweenAndEtatStage(startDate, endDate, etatStage);
    }
}