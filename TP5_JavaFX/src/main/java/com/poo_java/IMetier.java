package com.poo_java;

import java.util.List;

public interface IMetier {
    void addProfesseur(Professeur professeur);
    boolean removeProfesseur(int id);
    Boolean updateProfesseur(Professeur professeur);
    List<Professeur> getAllProfesseurs();
    List<Professeur> searchProfesseurs(String keyword);

    void addDepartement(Departement departement);
    void removeDepartement(int id);
    void updateDepartement(Departement Departement);
    List<Departement> getAllDepartements();
    List<Professeur> getProfesseursByDepartement(int departementId);
}
