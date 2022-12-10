package de.hebk.model.queue;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.*;
import javafx.scene.text.Font;
public class GUI {
    Font font = Font.font("Times New Roman");
    @FXML
    private Button button;
    @FXML
    private ImageView imagePer;
    @FXML
    private AnchorPane mainPanel;
    @FXML
    private MediaView m;
    @FXML
    public void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println("CLICK");
        Glow g = new Glow();
        System.out.println("box geklickt");
        g.setLevel(0.65);
        System.out.println("box geklickt");
        imagePer.setEffect(g);
        System.out.println("box geklickt");
        //Image image = new Image();
        //button.setFont(font);
        imagePer.setStyle("-fx-rotate: 50");
    }

}