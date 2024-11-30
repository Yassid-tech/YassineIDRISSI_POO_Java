package com.POO_Java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier{

    private SignletonConnexionDB signletonConnexionDB = new SignletonConnexionDB();
    private Connection connection = signletonConnexionDB.getConnection();

    @Override
    public void addProfesseur(Professeur professeur) {
        String query = "INSERT INTO Professeur(nom, prenom, cin, adresse, telephone, email, date_recrutement, id_deprat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(6, professeur.getEmail());
            ps.setString(5, professeur.getTelephone());
            ps.setDate(7, new Date(professeur.getDateRecrutement().getTime()));
            ps.setInt(8, professeur.getIdDeprat());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProfesseur(int id) {
        String query = "DELETE FROM Professeur WHERE id_prof = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfesseur(Professeur professeur) {
        String query = "UPDATE Professeur SET nom = ?, prenom = ?, cin = ?, adresse = ?, telephone = ?, email = ?, date_recrutement = ?, id_deprat = ? WHERE id_prof = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getPrenom());
            ps.setString(3, professeur.getCin());
            ps.setString(4, professeur.getAdresse());
            ps.setString(5, professeur.getTelephone());
            ps.setString(6, professeur.getEmail());
            ps.setDate(7, new java.sql.Date(professeur.getDateRecrutement().getTime()));
            ps.setInt(8, professeur.getIdDeprat());
            ps.setInt(9, professeur.getIdProf());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Professeur> getAllProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM Professeur";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                professeurs.add(new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getDate("date_recrutement"),
                        rs.getInt("id_deprat")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public List<Professeur> searchProfesseurs(String keyword) {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM Professeur WHERE nom LIKE ? OR prenom LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    professeurs.add(new Professeur(
                            rs.getInt("id_prof"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("cin"),
                            rs.getString("adresse"),
                            rs.getString("telephone"),
                            rs.getString("email"),
                            rs.getDate("date_recrutement"),
                            rs.getInt("id_deprat")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    @Override
    public void addDepartement(Departement departement) {
        String query = "INSERT INTO Departement(nom) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, departement.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDepartement(int id) {
        String query = "DELETE FROM Departement WHERE id_deprat = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartement(Departement departement) {
        String query = "UPDATE Departement SET nom = ? WHERE id_deprat = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, departement.getNom());
            ps.setInt(2, departement.getIdDeprat());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Departement> getAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        String query = "SELECT * FROM Departement";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                departements.add(new Departement(
                        rs.getInt("id_deprat"),
                        rs.getString("nom")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public List<Professeur> getProfesseursByDepartement(int departementId) {
        List<Professeur> professeurs = new ArrayList<>();
        String query = "SELECT * FROM Professeur WHERE id_deprat = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, departementId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    professeurs.add(new Professeur(
                            rs.getInt("id_prof"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("cin"),
                            rs.getString("adresse"),
                            rs.getString("telephone"),
                            rs.getString("email"),
                            rs.getDate("date_recrutement"),
                            rs.getInt("id_deprat")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }
}
