module de.hebk {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swt;
    requires javafx.media;


    opens de.hebk to javafx.fxml;
    exports de.hebk;
}