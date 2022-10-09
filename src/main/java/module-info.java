module br.gbrl.projurnaeletronica {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens br.gbrl.projurnaeletronica to javafx.fxml;
    exports br.gbrl.projurnaeletronica;
}