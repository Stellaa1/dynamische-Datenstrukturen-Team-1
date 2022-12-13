package de.hebk;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GUI {
    Font font = Font.font("Times New Roman");
    @FXML
    private Button button;

    private Button activator;
    @FXML
    private ImageView imagePer;
    @FXML
    private AnchorPane mainPanel;

    @FXML
    private Pane achievementPane;

    @FXML
    private VBox achievementsFrame;

    @FXML
    public void onHelloButtonClick() throws Exception{
        //welcomeText.setText("Welcome to JavaFX Application!");
        System.out.println(achievementPane);
        System.out.println(achievementPane.getParent());
        System.out.println(achievementPane.getId());

        for( int i=0; i < 10; i++) {
           Button p = new Button();
            p.setId("Item" + i);
            System.out.println(p.getId());
            achievementsFrame.getChildren().add(p);
        }
    }


    public void loadScreen(String screen) throws Exception{
        Start.previousScene = Start.mainStage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource(screen));
        Scene scene = new Scene(fxmlLoader.load(), 1920,1280);
        Start.mainStage.setTitle(screen);
        Start.mainStage.setScene(scene);
        Start.mainStage.show();
        Start.currentScene = screen;
    }

    public void closeNotification() throws Exception {
        System.out.println("STARTED");
        loadScreen("WillstDuWirklichSchliessen.fxml");
    }

    public void showPreviousScene() throws Exception {
        System.out.println(Start.currentScene);
        System.out.println(Start.previousScene);
        loadScreen(Start.previousScene);
    }

    public void close(){
        System.exit(0);
    }

}