module com.mycompany.assignment02 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.assignment02 to javafx.fxml;
    exports com.mycompany.assignment02;
}
