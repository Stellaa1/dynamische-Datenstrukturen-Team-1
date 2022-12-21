package de.hebk;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;

public class GUI extends SystemController {

    DataStore dataStore = new DataStore();
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

    @FXML
    ImageView profileImage1;
    @FXML
    ImageView profileImage2;
    @FXML
    ImageView profileImage3;
    @FXML
    ImageView profileImage4;
    @FXML
    ImageView profileImage5;
    @FXML
    ImageView profileImage6;
    @FXML
    ImageView profileImage7;
    @FXML
    ImageView profileImage8;
    @FXML
    ImageView profileImage9;
    @FXML
    ImageView profileImage10;
    @FXML
    ImageView profileImage11;
    @FXML
    ImageView profileImage12;
    @FXML
    ImageView profileImage13;
    @FXML
    ImageView profileImage14;
    @FXML
    ImageView profileImage15;
    @FXML
    ImageView profileImage16;
    @FXML
    ImageView profileImage17;
    @FXML
    ImageView profileImage18;
    @FXML
    ImageView profileImage19;
    @FXML
    ImageView profileImage20;




    //private SystemController systemController = new SystemController();
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

    public void showMainMenu() throws Exception{
        loadScreen("GUI.fxml");
    }
    public void closeNotification() throws Exception {
        loadScreen("WillstDuWirklichSchliessen.fxml");
    }

    public void showPreviousScene() throws Exception {
        System.out.println(Start.currentScene);
        System.out.println(Start.previousScene);
        loadScreen(Start.previousScene);
    }

    public void showEinloggen() throws Exception{
        super.loadData();
        loadScreen("Einloggen.fxml");
    }

    public void generateName(){
        //super.loadData();
        String s = super.randomName();
        nameField.setText(s);
    }

    public void generatePassword(){
        String s = super.randomName();
        passwordField.setText(s);
    }

    public void openMenu() throws Exception {
        loadScreen("Menu.fxml");
    }


    public void createUser() throws Exception {

        int index = 1;//super.dataStore.searchForUser(nameField.getText());

        if (!super.checkValidName(nameField.getText())){
            loadScreen("EinloggenFehler.fxml");
            return;
        }

        if (!super.checkValidPassword(passwordField.getText())){
            loadScreen("EinloggenFehler.fxml");
            return;
        }

        loadScreen("Profilbilder1.fxml");
        User u = new User();
        u.setName("Player");
        u.setPassword("Password");
        users.append(u);
        System.out.println(users.toString() + " S");
        super.saveData();

        if (index == -1){
            User user = new User();
            user.setName(nameField.getText());
            user.setPassword(passwordField.getText());
            user.getAchievements().append("START");
        }

        //super.saveData();
    }

    public void showProfilePicture2() throws Exception{
        loadScreen("Profilbilder2.fxml");
    }

    public void close() throws IOException {
        super.saveData();
        System.exit(0);
    }


    public void handle_ProfileImages(MouseEvent event) throws Exception {
        if (event.getSource() == profileImage1){
            System.out.println("IMAGE1");
            System.out.println(profileImage1.getImage().getUrl());
            super.saveData();
        }

        if (event.getSource() == profileImage11){
            System.out.println("IMAGE11");
            System.out.println(profileImage11.getImage().getUrl());
        }

    }
}