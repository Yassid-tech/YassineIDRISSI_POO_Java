package com.POO_Java.Exercice1;

import java.io.File;

public class SimulationLS {

    public void simulate(String directoryPath) {
        // Créer un objet File pour représenter le répertoire
        File directory = new File(directoryPath);

        // Vérifier si le chemin est valide
        if (directory.exists() && directory.isDirectory()) {
            // Lister les fichiers et répertoires de manière récursive
            listFiles(directory, "");
        } else {
            System.out.println("Le chemin spécifié n'est pas un répertoire valide.");
        }
    }


    private void listFiles(File file, String indent) {
        // Lister les fichiers et répertoires dans le répertoire courant
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                // Déterminer le type <DIR> ou <FILE>
                String type = f.isDirectory() ? "<DIR>" : "<FILE>";

                // Déterminer les permissions
                String permissions = getPermissions(f);

                // Afficher les informations
                System.out.println(indent + f.getAbsolutePath()
                        + " " + type + " " + permissions);

                // Si c'est un répertoire, appeler la méthode récursive
                if (f.isDirectory()) {
                    listFiles(f, indent + "    ");
                }
            }
        }
    }

    private String getPermissions(File file) {
        StringBuilder permissions = new StringBuilder();

        // Lecture
        permissions.append(file.canRead() ? "r" : "-");

        // Écriture
        permissions.append(file.canWrite() ? "w" : "-");

        // Caché
        permissions.append(file.isHidden() ? "h" : "-");

        return permissions.toString();
    }
}
