module gbrl.ue {
    requires javafx.controls;
    requires javafx.fxml;


    opens gbrl.ue to javafx.fxml;
    opens gbrl.ue.controllers to javafx.fxml;
    exports gbrl.ue;
}