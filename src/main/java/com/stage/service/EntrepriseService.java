package com.stage.service;

import com.stage.entity.Entreprise;
import com.stage.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    // Ajouter une entreprise
    public Entreprise addEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    // Récupérer toutes les entreprises
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    // Récupérer une entreprise par son ID
    public Optional<Entreprise> getEntrepriseById(Long id) {
        return entrepriseRepository.findById(id);
    }

    // Modifier une entreprise
    public Entreprise updateEntreprise(Long id, Entreprise entrepriseDetails) {
        Entreprise entreprise = entrepriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID : " + id));
        entreprise.setNom(entrepriseDetails.getNom());
        entreprise.setAdresse(entrepriseDetails.getAdresse());
        entreprise.setEmail(entrepriseDetails.getEmail());
        return entrepriseRepository.save(entreprise);
    }

    // Supprimer une entreprise
    public void deleteEntreprise(Long id) {
        entrepriseRepository.deleteById(id);
    }

    // Rechercher une entreprise par son nom exact
    public Optional<Entreprise> findByNom(String nom) {
        return entrepriseRepository.findByNom(nom);
    }

    // Rechercher des entreprises dont le nom contient une chaîne de caractères (recherche partielle)
    public List<Entreprise> findByNomContaining(String nom) {
        return entrepriseRepository.findByNomContaining(nom);
    }
}