module com.mycompany.lab09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.lab09 to javafx.fxml;
    exports com.mycompany.lab09;
}
