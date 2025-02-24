package com.stage.controller;

import com.stage.entity.EncadrantAcademique;
import com.stage.service.EncadrantAcademiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/encadrants-academiques")
public class EncadrantAcademiqueController {

    @Autowired
    private EncadrantAcademiqueService encadrantAcademiqueService;

    // Ajouter un encadrant académique
    @PostMapping("/add")
    public EncadrantAcademique addEncadrantAcademique(@RequestBody EncadrantAcademique encadrantAcademique) {
        return encadrantAcademiqueService.addEncadrantAcademique(encadrantAcademique);
    }

    // Récupérer tous les encadrants académiques
    @GetMapping("/get")
    public List<EncadrantAcademique> getAllEncadrantsAcademiques() {
        return encadrantAcademiqueService.getAllEncadrantsAcademiques();
    }

    // Récupérer un encadrant académique par son ID
    @GetMapping("/{id}")
    public ResponseEntity<EncadrantAcademique> getEncadrantAcademiqueById(@PathVariable Long id) {
        return encadrantAcademiqueService.getEncadrantAcademiqueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Modifier un encadrant académique
    @PutMapping("/{id}")
    public ResponseEntity<EncadrantAcademique> updateEncadrantAcademique(@PathVariable Long id, @RequestBody EncadrantAcademique encadrantAcademiqueDetails) {
        EncadrantAcademique updatedEncadrantAcademique = encadrantAcademiqueService.updateEncadrantAcademique(id, encadrantAcademiqueDetails);
        return ResponseEntity.ok(updatedEncadrantAcademique);
    }

    // Supprimer un encadrant académique
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncadrantAcademique(@PathVariable Long id) {
        encadrantAcademiqueService.deleteEncadrantAcademique(id);
        return ResponseEntity.noContent().build();
    }
}