package de.hebk;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class GUI extends SystemController {

    String local_Profile_Picure = "src/main/resources/de/hebk/Images/blank-profile-picture-973460_960_720.webp";

    DataStore dataStore = new DataStore();
    @FXML
    private Button button;
    @FXML
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
    private Text warningText;
    @FXML
    private Text availabilityText;
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
        showAvailabilityText();
        checkAvailabilityName();
    }

    public void generatePassword(){
        String s = super.randomName();
        passwordField.setText(s);
        hideAvailabilityText();
    }

    public void showAvailabilityText(){
        availabilityText.setVisible(true);
        checkAvailabilityName();
    }

    public void hideAvailabilityText(){
        availabilityText.setVisible(false);
    }

    public void checkAvailabilityName(){

        if (!checkValidName(nameField.getText())){
            availabilityText.setText("(✕) Mindestens 3 Zeichen erfordert");
            availabilityText.setStyle("-fx-fill: rgb(255,140,0)");
            return;
        }

        if (users.get(0) == null){
            availabilityText.setText("(✓) Gültiger Name");
            availabilityText.setStyle("-fx-fill: rgb(0,255,140)");
            return;
        }

        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getContext().getName().equals(nameField.getText())){
                availabilityText.setText("(✕) Ungültiger Name");
                availabilityText.setStyle("-fx-fill: rgb(255,0,80)");
                break;
            } else{
                availabilityText.setText("(✓) Gültiger Name");
                availabilityText.setStyle("-fx-fill: rgb(0,255,140)");
            }
        }
    }

    public void openMenu() throws Exception {
        loadScreen("Menu.fxml");
    }


    public void createUser() throws Exception {

        int index = searchForUser(nameField.getText());

        System.out.println(users.toString());
        System.out.println(index + " index");

        if (index != -1){
            loadScreen("Warning.fxml");
            System.out.println(warningText);
            System.out.println(passwordField);
            warningText.setText("Es gibt einen registrierten Nutzer mit dem selben Namen, bitte nehmen sie einen anderen Namen");
            return;
        }

        if (!super.checkValidName(nameField.getText())){
            loadScreen("Warning.fxml");
            return;
        }

        if (!super.checkValidPassword(passwordField.getText())){
            loadScreen("Warning.fxml");
            return;
        }

        User u = new User();
        u.setName(nameField.getText());
        u.setPassword(passwordField.getText());
        users.append(u);

        loadScreen("Menu.fxml");

        //handle_ProfileImages(new MouseEvent(), u);

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
            local_Profile_Picure = profileImage1.getImage().getUrl();
        }

        if (event.getSource() == profileImage2){
            local_Profile_Picure = profileImage2.getImage().getUrl();
        }

        if (event.getSource() == profileImage3){
            local_Profile_Picure = profileImage3.getImage().getUrl();
        }

        if (event.getSource() == profileImage4){
            local_Profile_Picure = profileImage4.getImage().getUrl();
        }

        if (event.getSource() == profileImage5){
            local_Profile_Picure = profileImage5.getImage().getUrl();
        }

        if (event.getSource() == profileImage6){
            local_Profile_Picure = profileImage6.getImage().getUrl();
        }

        if (event.getSource() == profileImage7){
            local_Profile_Picure = profileImage7.getImage().getUrl();
        }

        if (event.getSource() == profileImage8){
            local_Profile_Picure = profileImage8.getImage().getUrl();
        }

        if (event.getSource() == profileImage9){
            local_Profile_Picure = profileImage9.getImage().getUrl();
        }

        if (event.getSource() == profileImage10){
            local_Profile_Picure = profileImage10.getImage().getUrl();
        }

        if (event.getSource() == profileImage11){
            local_Profile_Picure = profileImage10.getImage().getUrl();
        }

        if (event.getSource() == profileImage12){
            local_Profile_Picure = profileImage12.getImage().getUrl();
        }

        if (event.getSource() == profileImage13){
            local_Profile_Picure = profileImage13.getImage().getUrl();
        }

        if (event.getSource() == profileImage14){
            local_Profile_Picure = profileImage14.getImage().getUrl();
        }

        if (event.getSource() == profileImage15){
            local_Profile_Picure = profileImage15.getImage().getUrl();
        }

        //local_Player.setProfilePicture(imageUrl);
        super.saveData();
        loadScreen("Menu.fxml");
    }
}
