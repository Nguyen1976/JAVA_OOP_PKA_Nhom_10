module com.finalproj {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.finalproj to javafx.fxml;
    exports com.finalproj;
}
