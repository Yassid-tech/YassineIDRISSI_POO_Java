module com.poo_java{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.poo_java to javafx.fxml;
    exports com.poo_java;
}