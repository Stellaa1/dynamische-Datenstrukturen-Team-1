module de.hebk {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.hebk to javafx.fxml;
    exports de.hebk;
}