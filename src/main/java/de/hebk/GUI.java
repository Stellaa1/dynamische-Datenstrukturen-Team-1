package de.hebk;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField nameField;
    @FXML
    private TextField passwordField;

    @FXML
    private Pane achievementPane;

    @FXML
    private VBox achievementsFrame;


    private SystemController systemController = new SystemController();
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

    public void showEinloggen() throws Exception{
        systemController.loadData();
        loadScreen("Einloggen.fxml");
        System.out.println(systemController.names.toString());
    }

    public void generateName(){
        String s = systemController.randomName();
        nameField.setText(s);
    }

    public void generatePassword(){
        String s = systemController.randomName();
        passwordField.setText(s);
    }


    public void createUser(){

        int index = systemController.dataStore.searchForUser(nameField.getText());

        if (index == -1){
            User user = new User();
            user.setName(nameField.getText());
            user.setPassword(passwordField.getText());
            user.getAchievements().append("START");
            systemController.names.append(user.getName());
            systemController.passwords.append(user.getPassword());
            systemController.achievements.append(user.getAchievements());
            System.out.println("USER CREATED");
            systemController.saveData();
        }

        System.out.println(systemController.names.toString());

    }

    public void close(){
        System.exit(0);
    }

}