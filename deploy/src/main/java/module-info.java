module com.finalproj.deploy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.finalproj.Controller to javafx.fxml;
    opens com.finalproj.Modal to javafx.fxml;
    opens com.finalproj.View to javafx.fxml;
    opens com.finalproj to javafx.fxml;

    exports com.finalproj.Controller;
    exports com.finalproj.Modal;
    exports com.finalproj.View;
    exports com.finalproj.Utils;
    opens com.finalproj.Utils to javafx.fxml;
}