package com.poo_java;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.time.LocalDate;

public class ManagementController {

    // Ajputer professeur
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField cinField;
    @FXML
    private TextField adresseField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telephoneField;
    @FXML
    private DatePicker dateRecrutementPicker;
    @FXML
    private TextField idDepartField;
    @FXML
    private Button addProfessorButton;

    // Modifier Professeur

    @FXML
    private TextField idProfField;
    @FXML
    private Button searchButton;
    @FXML
    private TextField nomField1;
    @FXML
    private TextField prenomField1;
    @FXML
    private TextField cinField1;
    @FXML
    private TextField adresseField1;
    @FXML
    private TextField emailField1;
    @FXML
    private TextField telephoneField1;
    @FXML
    private DatePicker dateRecruitmentPicker1;
    @FXML
    private TextField idDepartementField1;
    @FXML
    private Button modifyButton;

    // Supprimer Professeur
    @FXML
    private Button supprimerProfButton;
    @FXML
    private TextField idProfSupprimer;

    // Ajouter Departement
    @FXML
    private Button ajouterDepartementButton;
    @FXML
    private TextField nomDepartNew;
    @FXML
    private TextField idDepartNew;


    // Tableaux de professeurs et departements
    @FXML
    private TableView<Departement> departementTable;

    @FXML
    private TableColumn<Departement, Integer> idDepart;
    @FXML
    private TableColumn<Departement, String> nomDepart;

    @FXML
    private TableView<Professeur> professeursTable;

    @FXML
    private TableColumn<Professeur, Integer> idProf;
    @FXML
    private TableColumn<Professeur, String> nom;
    @FXML
    private TableColumn<Professeur, String> prenom;
    @FXML
    private TableColumn<Professeur, String> cin;
    @FXML
    private TableColumn<Professeur, String> adresse;
    @FXML
    private TableColumn<Professeur, String> email;
    @FXML
    private TableColumn<Professeur, String> telephone;
    @FXML
    private TableColumn<Professeur, java.util.Date> dateRecrutement;
    @FXML
    private TableColumn<Professeur, Integer> idDeprat;

    private MetierImpl metier = new MetierImpl();


    @FXML
    public void initialize() {
        setupTables();

        addProfessorButton.setOnAction(this::handleAddProfessor);
        searchButton.setOnAction(this::handleSearchButtonAction);
        modifyButton.setOnAction(this::handleModifyButtonAction);
        ajouterDepartementButton.setOnAction(this::handleAjouterDepartement);
        supprimerProfButton.setOnAction(this::handleDeleteProfessor);
    }

    private void handleAddProfessor(ActionEvent event) {
        try {
            // Collect data from the form
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String cin = cinField.getText();
            String adresse = adresseField.getText();
            String email = emailField.getText();
            String telephone = telephoneField.getText();
            Date dateRecrutement = Date.valueOf(dateRecrutementPicker.getValue());
            int idDepart = Integer.parseInt(idDepartField.getText());

            // Create a Professeur object
            Professeur professeur = new Professeur();
            professeur.setNom(nom);
            professeur.setPrenom(prenom);
            professeur.setCin(cin);
            professeur.setAdresse(adresse);
            professeur.setEmail(email);
            professeur.setTelephone(telephone);
            professeur.setDateRecrutement(new java.util.Date(dateRecrutement.getTime()));
            professeur.setIdDeprat(idDepart);

            // Use MetierImpl to save the Professeur
            metier.addProfesseur(professeur);

            // Show success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Professeur added successfully!");
            alert.showAndWait();

            // Clear the form fields
            clearForm();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            // Handle and show any errors
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Echec d'ajout");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    private void handleSearchButtonAction(ActionEvent event) {
        String id = idProfField.getText(); // Get the ID entered by the user

        if (id == null || id.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a valid Professor ID.");
            return;
        }

        // Retrieve the professor's information
        Professeur professor = metier.getProfesseurById(id);

        if (professor == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Professor not found with the given ID.");
            return;
        }

        // Populate the form fields with the professor's information
        nomField1.setText(professor.getNom());
        prenomField1.setText(professor.getPrenom());
        cinField1.setText(professor.getCin());
        adresseField1.setText(professor.getAdresse());
        emailField1.setText(professor.getEmail());
        telephoneField1.setText(professor.getTelephone());
        System.out.println(LocalDate.parse(professor.getDateRecrutement().toString()));
        dateRecruitmentPicker1.setValue(LocalDate.parse(professor.getDateRecrutement().toString()));
        idDepartementField1.setText(String.valueOf(professor.getIdDeprat()));

        // Enable the "Modifier" button
        modifyButton.setDisable(false);
    }

    private void handleModifyButtonAction(ActionEvent event) {
        try {
            // Collect updated data from the form
            String id = idProfField.getText();
            String nom = nomField1.getText();
            String prenom = prenomField1.getText();
            String cin = cinField1.getText();
            String adresse = adresseField1.getText();
            String email = emailField1.getText();
            String telephone = telephoneField1.getText();
            java.util.Date dateRecrutement = java.sql.Date.valueOf(dateRecruitmentPicker1.getValue());
            int idDepart = Integer.parseInt(idDepartementField1.getText());

            // Create an updated Professeur object
            Professeur updatedProfessor = new Professeur();
            updatedProfessor.setIdProf(Integer.parseInt(id)); // ID is critical for the update
            updatedProfessor.setNom(nom);
            updatedProfessor.setPrenom(prenom);
            updatedProfessor.setCin(cin);
            updatedProfessor.setAdresse(adresse);
            updatedProfessor.setEmail(email);
            updatedProfessor.setTelephone(telephone);
            updatedProfessor.setDateRecrutement(dateRecrutement);
            updatedProfessor.setIdDeprat(idDepart);

            // Save the updated professor to the database
            boolean success = metier.updateProfesseur(updatedProfessor);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Professeur details updated successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Failed to update professor details.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        // Clear the form fields
        clearForm1();
    }

    private void handleDeleteProfessor(ActionEvent event) {
        try {
            int idProf = Integer.parseInt(idProfSupprimer.getText());


            // Save the updated professor to the database
            boolean success = metier.removeProfesseur(idProf);

            if (success) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Professeur supprime avec succes.");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error", "Echec de suppression.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        // Clear the form fields
        clearForm2();
    }

    private void handleAjouterDepartement(ActionEvent event) {
        try {

            // Create a Professeur object
            Departement departement = new Departement();
            departement.setNomDepart(nomDepartNew.getText());
            departement.setIdDepart(Integer.parseInt(idDepartNew.getText()));

            // Use MetierImpl to save the Professeur
            metier.addDepartement(departement);

            // Show success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Departement ajouter avec succes!");
            alert.showAndWait();

            // Clear the form fields
            clearForm3();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Echec d'ajout");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    // Tableaux de professeurs et departements
    private void setupTables() {
        // Departement
        idDepart.setCellValueFactory(new PropertyValueFactory<Departement, Integer>("idDepart"));
        nomDepart.setCellValueFactory(new PropertyValueFactory<Departement, String>("nomDepart"));
        departementTable.setEditable(true);
        departementTable.setItems(FXCollections.observableArrayList(metier.getAllDepartements()));
        System.out.println("Professors List: " + FXCollections.observableArrayList(metier.getAllDepartements()));
        System.out.println("Table Columns: " + departementTable.getColumns());
        System.out.println("Table Items: " + departementTable.getItems());


        // Professeur
        idProf.setCellValueFactory(new PropertyValueFactory<Professeur, Integer>("idProf"));
        nom.setCellValueFactory(new PropertyValueFactory<Professeur, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Professeur, String>("prenom"));
        cin.setCellValueFactory(new PropertyValueFactory<Professeur, String>("cin"));
        adresse.setCellValueFactory(new PropertyValueFactory<Professeur, String>("adresse"));
        email.setCellValueFactory(new PropertyValueFactory<Professeur, String>("email"));
        telephone.setCellValueFactory(new PropertyValueFactory<Professeur, String>("telephone"));
        dateRecrutement.setCellValueFactory(new PropertyValueFactory<Professeur, java.util.Date>("dateRecrutement"));
        idDeprat.setCellValueFactory(new PropertyValueFactory<Professeur, Integer>("idDeprat"));


        professeursTable.setEditable(true);
        professeursTable.setItems(FXCollections.observableArrayList(metier.getAllProfesseurs()));

    }



    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearForm() {
        nomField.clear();
        prenomField.clear();
        cinField.clear();
        adresseField.clear();
        emailField.clear();
        telephoneField.clear();
        dateRecrutementPicker.setValue(null);
        idDepartField.clear();
    }
    private void clearForm1() {
        idProfField.clear();
        nomField1.clear();
        prenomField1.clear();
        cinField1.clear();
        adresseField1.clear();
        emailField1.clear();
        telephoneField1.clear();
        dateRecruitmentPicker1.setValue(null);
        idDepartementField1.clear();
    }

    private void clearForm2() {
        idProfSupprimer.clear();
    }

    private void clearForm3() {
        idDepartNew.clear();
        nomDepartNew.clear();
    }
}
