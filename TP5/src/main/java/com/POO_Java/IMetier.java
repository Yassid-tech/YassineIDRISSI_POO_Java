package com.POO_Java;

import java.util.List;

public interface IMetier {
    void addProfesseur(Professeur professeur);
    void removeProfesseur(int id);
    void updateProfesseur(Professeur professeur);
    List<Professeur> getAllProfesseurs();
    List<Professeur> searchProfesseurs(String keyword);

    void addDepartement(Departement departement);
    void removeDepartement(int id);
    void updateDepartement(Departement Departement);
    List<Departement> getAllDepartements();
    List<Professeur> getProfesseursByDepartement(int departementId);
}
