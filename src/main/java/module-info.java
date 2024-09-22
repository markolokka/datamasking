module com.girbola.datamasking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.girbola.datamasking to javafx.fxml;
    exports com.girbola.datamasking;
}