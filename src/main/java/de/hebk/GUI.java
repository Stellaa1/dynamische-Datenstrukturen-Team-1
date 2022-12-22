package de.hebk;

import de.hebk.model.list.List;
import javafx.css.converter.PaintConverter;
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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import javax.security.auth.callback.TextInputCallback;
import java.io.IOException;

public class GUI extends SystemController {


    Game game;
    Fragen f;
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
    private VBox newVB;
    @FXML
    private TextField passwordField;
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
    @FXML
    private ImageView questionImage;
    @FXML
    private VBox questionsVBox;
    @FXML
    private TextArea questionBox;
    @FXML
    private Button answer_button1;
    @FXML
    private Button answer_button2;
    @FXML
    private Button answer_button3;
    @FXML
    private Button answer_button4;


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




    public void loadScene(String screen) throws Exception{
        Start.previousScene = Start.mainStage.getTitle();
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource(screen));
        Scene scene = new Scene(fxmlLoader.load(), 1920,1280);
        Start.mainStage.setTitle(screen);
        Start.mainStage.setScene(scene);
        Start.mainStage.show();
        Start.currentScene = screen;
    }

    public void showMainMenu() throws Exception{
        loadScene("GUI.fxml");
    }
    public void closeNotification() throws Exception {
        loadScene("WillstDuWirklichSchliessen.fxml");
    }

    public void showPreviousScene() throws Exception {
        loadScene(Start.previousScene);
    }

    public void showEinloggen() throws Exception{
        super.loadData();
        loadScene("Regestrieren.fxml");
    }

    public void generateName(){
        //super.loadData();
        String s = super.randomName();
        nameField.setText(s);
        checkAvailabilityName();
        showAvailabilityText();
    }

    public void generatePassword(){
        String s = super.randomName();
        passwordField.setText(s);
        hideAvailabilityText();
    }

    public void showAvailabilityText(){
        checkAvailabilityName();
        availabilityText.setVisible(true);
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
        loadScene("Menu.fxml");
    }


    public void createUser() throws Exception {

        int index = searchForUser(nameField.getText());

        System.out.println(users.toString());
        System.out.println(index + " index");

        if (index != -1){
            loadScene("Fehler_Einloggen.fxml");
            System.out.println(passwordField);
            return;
        }

        if (!super.checkValidName(nameField.getText())){
            loadScene("Fehler_Einloggen.fxml");
            return;
        }

        if (!super.checkValidPassword(passwordField.getText())){
            loadScene("Fehler_Einloggen.fxml");
            return;
        }

        User u = new User();
        u.setName(nameField.getText());
        u.setPassword(passwordField.getText());
        users.append(u);

        loadScene("Menu.fxml");

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

    public void showHowManyQuestions() throws Exception{
        loadScene("Fragenzahl.fxml");
    }

    public void showGame() throws Exception{
        loadScene("Normal10.fxml");

    }

    public void startGame(){

        String[] values1 = {"100", "500", "2500", "10000", "25000", "75000", "150000", "250000", "500000", "1000000"};
        String[] values2 = {"100", "250", "500", "1000", "2500", "5000", "7500", "10000", "25000", "50000", "100000", "150000", "250000", "500000", "1000000"};
        String[] values3 = {"100", "150", "250", "500", "1000", "2500", "5000", "7500", "10000", "15000", "25000", "350000", "50000", "750000", "1000000", "150000", "225000", "350000", "500000", "1000000"};

        f = new Fragen(15,"Geschichte");
        f.generateQuestions();
        game = new Game();
        game.index_frage = 0;
        game.fragen = f;
        game.currency = "¥";

        String[] s = values1;
        int tg = 61;

        if (game.fragen.getAnzahl() == 10){
            tg = 61;
            newVB.setSpacing(40);
            s = values1;
        }

        if (game.fragen.getAnzahl() == 15){
            tg = 42;
            newVB.setSpacing(25);
            s = values2;
        }

        if (game.fragen.getAnzahl() == 20){
            tg = 34;
            newVB.setSpacing(15);
            s = values3;
        }

        if (game.index_frage < f.getAnzahl()){
            setQuestionAndAnswers();
        }

        newVB.getChildren().clear();

        for (int i = 0; i < game.fragen.getAnzahl(); i++){
            Text questionText = new Text();
            questionText.setText((i + 1) + " ⬩ " + s[i] + " " + game.currency);
            questionText.setId("questionText_" + i);
            questionText.setWrappingWidth(618.65087890625);
            System.out.println(questionText.getTextAlignment());
            questionText.setTextAlignment(TextAlignment.CENTER);
            questionText.setFill(Paint.valueOf("#ffffff"));
            Font questionText_Font = Font.font("Arial",tg);
            questionText.setFont(questionText_Font);
            newVB.getChildren().add(questionText);
        }
    }

    public void setQuestionAndAnswers(){
        if (game.index_frage >= f.getAnzahl()){
            return;
        }



        List<String> options = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions();
        questionBox.setText(game.fragen.getQuestions().get(game.index_frage).getContext().getQuestion());

        int x;
        x = (int) (Math.random() * options.size());
        answer_button1.setText(options.get(x).getContext());

        x = (int) (Math.random() * options.size());
        answer_button2.setText(options.get(x).getContext());

        while (answer_button1.getText().equals(answer_button2.getText())){
            x = (int) (Math.random() * options.size());
            answer_button2.setText(options.get(x).getContext());
        }

        x = (int) (Math.random() * options.size());
        answer_button3.setText(options.get(x).getContext());

        while (answer_button1.getText().equals(answer_button2.getText()) || answer_button1.getText().equals(answer_button3.getText()) || answer_button2.getText().equals(answer_button3.getText())){
            x = (int) (Math.random() * options.size());
            answer_button3.setText(options.get(x).getContext());
        }

        x = (int) (Math.random() * options.size());
        answer_button4.setText(options.get(x).getContext());

        while (answer_button1.getText().equals(answer_button2.getText()) || answer_button1.getText().equals(answer_button3.getText()) || answer_button1.getText().equals(answer_button4.getText()) || answer_button2.getText().equals(answer_button3.getText()) || answer_button2.getText().equals(answer_button4.getText()) || answer_button3.getText().equals(answer_button4.getText())){
            x = (int) (Math.random() * options.size());
            answer_button4.setText(options.get(x).getContext());
        }

    }
    public void addQuestions(){
        for (int i = 0; i < 5; i++){
            Text questionText = new Text();
            questionText.setText(i + " ⬩ € 150");
            questionText.setId("questionText_" + i);
            Font questionText_Font = Font.font("Arial",52);
            questionText.setFont(questionText_Font);
            newVB.getChildren().add(questionText);
        }
    }

    public void getAnswer1(){
        if (super.checkAnswer(f, questionBox.getText(), answer_button1.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
            return;
        }
    }

    public void getAnswer2(){
        if (super.checkAnswer(f, questionBox.getText(), answer_button2.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
        }
    }

    public void getAnswer3(){
        if (super.checkAnswer(f, questionBox.getText(), answer_button3.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
        }
    }

    public void getAnswer4(){
        if (super.checkAnswer(f, questionBox.getText(), answer_button4.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
        }
    }

    public void showProfilePicture2() throws Exception{
        loadScene("Profilbilder2.fxml");
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
        loadScene("Menu.fxml");
    }
}
