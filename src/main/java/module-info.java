module com.example.piaoletnew {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.piaoletnew to javafx.fxml;
//    exports com.piaoletnew.*;
    exports com.piaoletnew.domain;
    opens com.piaoletnew.domain to javafx.fxml;
    exports com.piaoletnew.view;
    opens com.piaoletnew.view to javafx.fxml;
}