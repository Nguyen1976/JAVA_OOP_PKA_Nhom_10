module com.finalproj.deploy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.finalproj.deploy to javafx.fxml;
    exports com.finalproj.deploy;
}