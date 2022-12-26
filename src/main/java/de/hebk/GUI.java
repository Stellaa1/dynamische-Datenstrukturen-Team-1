package de.hebk;

import de.hebk.model.list.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class GUI extends SystemController {

    Timer timer = new Timer();
    TimerTask timertask;
    long beforeTimer;
    long afterRun;
    Game game;
    static String temp_gameMode;
    static int temp_FragenAnzahl;
    static String temp_category;
    static int temp_difficultyValue;
    static int temp_difficultyRange;
    static int temp_incrementValue;
    static int temp_incrementRange;
    static String temp_currency;

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
    @FXML
    private TextField topicTitle;
    @FXML
    private Text topicText;
    @FXML
    private Polygon nextTopicTrigger;
    @FXML
    private CheckBox advancedGameSettingsOptions;

    @FXML
    private TextField minimum_DifficultyField;
    @FXML
    private TextField maximum_DifficultyField;
    @FXML
    private TextField incrementValueField;
    @FXML
    private TextField incrementRangeField;
    @FXML
    private Text incrementValueText;
    @FXML
    private Text incrementRangeText;
    @FXML
    private ImageView currency_Dice;
    @FXML
    private Text currencyText;
    @FXML
    private TextField currencyField;
    @FXML
    private ImageView anmelden_Image;
    @FXML
    private TextField anmelden_Benutzername;
    @FXML
    private TextField anmelden_Password;
    @FXML
    private TextField anmelden_PasswortWiederholen;
    @FXML
    private ImageView menu_UserImage;
    @FXML
    private Text menu_UserName;
    @FXML
    private Rectangle loader_Menu;
    @FXML
    private Rectangle loader_Game_Normal;
    @FXML
    private Rectangle loader_Game_Normal2;
    @FXML
    private Button gameMode_Normal;
    @FXML
    private Button gameMode_Reverse;
    @FXML
    private Button amount_Questions10;
    @FXML
    private Button amount_Questions15;
    @FXML
    private Button amount_Questions20;
    @FXML
    private Text youLostText;
    @FXML
    private Button returnToMenu;
    @FXML
    private Text timeText;
    @FXML
    static private final Text[] VALUES = new Text[20];

    
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

    public void showRegister() throws Exception{
        super.loadData();
        loadScene("Registrieren.fxml");
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


    public void showSettings() throws Exception{
        loadScene("Einstellungen.fxml");
    }


    public void createUser() throws Exception {

        int index = searchForUser(nameField.getText());

        if (index != -1){
            loadScene("Fehler_Einloggen.fxml");
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
        local_User = u;

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

    public void showLogIn() throws Exception{
        super.loadData();
        loadScene("Anmelden.fxml");
    }

    public void logIn_showProfilePicture() throws FileNotFoundException {
        int index = searchForUser(anmelden_Benutzername.getText());

        if (index != -1){
            FileInputStream inputStream = new FileInputStream(users.get(index).getContext().getProfilePicture());
            Image image = new Image(inputStream);
            anmelden_Image.setImage(image);
        } else{
            FileInputStream inputStream = new FileInputStream("src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG");
            Image image = new Image(inputStream);
            anmelden_Image.setImage(image);
        }
    }

    public void logIn() throws Exception{
        int index = searchForUser(anmelden_Benutzername.getText());

        if (index == -1){
            loadScene("Fehler_Einloggen.fxml");
            return;
        }

        if (!anmelden_Password.getText().equals(anmelden_PasswortWiederholen.getText())){
            loadScene("Fehler_Einloggen.fxml");
            return;
        }


        User u = users.get(index).getContext();
        if (!anmelden_Password.getText().equals(u.getPassword())){
            loadScene("Fehler_Einloggen.fxml");
            return;
        }
        local_User = u;

        loadScene("Menu.fxml");
    }

    public void counter() throws Exception{
        try {
            beforeTimer = System.currentTimeMillis();
            timer = new Timer();
            final int[] time = {30};
            timertask = new TimerTask() {
                @Override
                public void run() {
                    if (time[0] >= 0){
                        System.out.println(time[0]);
                        afterRun = System.currentTimeMillis();
                        timeText.setText("Zeit - " + ((int) 30 - (afterRun - beforeTimer) / 1000));
                        time[0] -= 1;
                    }
                    if (time[0] == -1){
                        timer.cancel();
                        endGame();
                    }
                }
            };
            timer.schedule(timertask, 0, 1000);
        } catch (Exception e){
        }

    }

    public void loadUserInMenu() throws FileNotFoundException {
        loader_Menu.setVisible(false);
        FileInputStream inputStream = new FileInputStream(local_User.getProfilePicture());
        Image image = new Image(inputStream);
        menu_UserImage.setImage(image);
        menu_UserName.setText(local_User.getName());
    }

    public void showProfilePicture1() throws Exception{
        loadScene("Profilbilder1.fxml");
    }
    public void showProfilePicture2() throws Exception{
        loadScene("Profilbilder2.fxml");
    }

    public void logOut() throws Exception{
        local_User = null;
        loadScene("GUI.fxml");
    }

    public void showGameModes() throws Exception{
        loadScene("NormalOderReverse.fxml");
    }

    public void showHowManyQuestions() throws Exception{
        loadScene("Fragenzahl.fxml");
    }

    public void nextTopic(){
        try {
            for (int i = 0; i < csvFiles_Questions.length; i++){
                if (topicText.getText().equals(csvFiles_Questions[i])){
                        topicText.setText(csvFiles_Questions[i + 1]);
                        break;
                }
            }
        } catch (Exception e){
            topicText.setText(csvFiles_Questions[0]);
        }
        topicTitle.setText("doku/Fragen/" + topicText.getText() + ".csv");
    }

    public void showGame_Settings2() throws Exception{
        loadScene("Game_Settings2.fxml");
        temp_category = topicText.getText().toString();
    }

    public void modifyAdvancedOptions(){
        incrementRangeField.setVisible(advancedGameSettingsOptions.isSelected());
        incrementRangeText.setVisible(advancedGameSettingsOptions.isSelected());
        incrementValueField.setVisible(advancedGameSettingsOptions.isSelected());
        incrementValueText.setVisible(advancedGameSettingsOptions.isSelected());
        currencyField.setVisible(advancedGameSettingsOptions.isSelected());
        currency_Dice.setVisible(advancedGameSettingsOptions.isSelected());
        currencyText.setVisible(advancedGameSettingsOptions.isSelected());
    }

    public void generateCurrency(){
        int x = (int) (Math.random() * currencies.length);
        currencyField.setText(currencies[x]);
    }

    public void showGame() throws Exception{
        try {
            temp_difficultyValue = Integer.parseInt(maximum_DifficultyField.getText());
            temp_difficultyRange = Integer.parseInt(minimum_DifficultyField.getText());
            temp_incrementValue = Integer.parseInt(incrementValueField.getText());
            temp_incrementRange = Integer.parseInt(incrementRangeField.getText());
            temp_currency = currencyField.getText();
        } catch (Exception e){
            temp_gameMode = "Normal";
            temp_difficultyValue = 20;
            temp_difficultyRange = 0;
            temp_incrementValue = 2;
            temp_incrementRange = 2;
            temp_currency = "€";
        }


        //game.fragen.gameSettings.setDifficultyRange(Integer.parseInt(minimum_DifficultyField.getText()));
        //game.fragen.gameSettings.setDifficultyValue(Integer.parseInt(maximum_DifficultyField.getText()));
        //game.fragen.gameSettings.setIncrementValue(Integer.parseInt(incrementValueField.getText()));
        //game.fragen.gameSettings.setIncrementRange(Integer.parseInt(incrementRangeField.getText()));

        loadScene("Normal10.fxml");
    }

    public void startGame() throws Exception {
        System.out.println("startGame()");
        loader_Game_Normal.setVisible(false);

        try {
            game = new Game();
            game.fragen = new Fragen();
            game.fragen.gameSettings.setGameMode(temp_gameMode);
            game.fragen.gameSettings.setCategory(temp_category);
            game.fragen.gameSettings.setQuestion_Amount(temp_FragenAnzahl);
            game.fragen.gameSettings.setDifficultyValue(temp_difficultyValue);
            game.fragen.gameSettings.setDifficultyRange(temp_difficultyRange);
            game.fragen.gameSettings.setIncrementValue(temp_incrementValue);
            game.fragen.gameSettings.setIncrementRange(temp_incrementRange);

            game.fragen.generateQuestions();
            game.index_frage = 0;
            game.fragen.gameSettings.setCurrency(temp_currency);

            String[] s = values1;
            int tg = 61;

            if (game.fragen.gameSettings.getQuestion_Amount() == 10){
                tg = 61;
                newVB.setSpacing(40);
                s = values1;
            }

            if (game.fragen.gameSettings.getQuestion_Amount() == 15){
                tg = 42;
                newVB.setSpacing(25);
                s = values2;
            }

            if (game.fragen.gameSettings.getQuestion_Amount() == 20){
                tg = 34;
                newVB.setSpacing(15);
                s = values3;
            }



            newVB.getChildren().clear();

            for (int i = 0; i < game.fragen.gameSettings.getQuestion_Amount(); i++){
                Text questionText = new Text();
                questionText.setText((i + 1) + " ⬩ " + s[i] + " " + game.fragen.gameSettings.getCurrency());
                questionText.setWrappingWidth(618.65087890625);
                questionText.setTextAlignment(TextAlignment.CENTER);
                questionText.setFill(Paint.valueOf("#ffffff"));
                Font questionText_Font = Font.font("Arial",tg);
                questionText.setFont(questionText_Font);
                System.out.println(i + " " + VALUES[i]);
                VALUES[i] = questionText;
                System.out.println(i + " " + VALUES[i]);
                newVB.getChildren().add(questionText);
            }
        } catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            loadScene("Fehler_Game.fxml");
        }

        if (game.index_frage < game.fragen.gameSettings.getQuestion_Amount()){
            setQuestionAndAnswers();
        }

    }

    public void setQuestionAndAnswers() throws Exception{
        counter();
        if (game.index_frage != 0){
            VALUES[game.index_frage - 1].setStyle("-fx-fill: white");
        }
        VALUES[game.index_frage].setStyle("-fx-fill: #ff8c00");
        if (game.index_frage >= game.fragen.gameSettings.getQuestion_Amount()){
            return;
        }

        List<String> options = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions();
        questionBox.setText(game.fragen.getQuestions().get(game.index_frage).getContext().getQuestion());

        for (int i = 0; i < game.fragen.gameSettings.getQuestion_Amount(); i++){
            System.out.println(game.fragen.getQuestions().get(i).getContext().getOptions().toString());
        }

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

        if (options.find("Keine von genannten")){
            String s = answer_button4.getText();

            if (s.equals("Keine von genannten")){
                return;
            }

            if (answer_button1.getText().equals("Keine von genannten")){
                answer_button1.setText(s);
                answer_button4.setText("Keine von genannten");
                return;
            }

            if (answer_button2.getText().equals("Keine von genannten")){
                answer_button2.setText(s);
                answer_button4.setText("Keine von genannten");
                return;
            }

            if (answer_button3.getText().equals("Keine von genannten")){
                answer_button3.setText(s);
                answer_button4.setText("Keine von genannten");
            }
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

    public void animateButton(Button b, String t){
        if (t.equals("Normal")){
            b.setStyle("-fx-background-color: rgb(73,82,157)");
        }

        if (t.equals("Trigger")){
            b.setStyle("-fx-background-color: rgb(255,140,0)");
        }

        if (t.equals("Answer")){
            b.setStyle("-fx-background-color: rgb(0,255,140)");
        }

        if (t.equals("Wrong")){
            b.setStyle("-fx-background-color: rgb(255,0,40)");
        }
    }

    public Button getCorrectAnswerFromButtons(){
        String answer = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions().get(0).getContext();
        Button button = null;

        if (answer_button1.getText().equals(answer)){
            button = answer_button1;
        }

        if (answer_button2.getText().equals(answer)){
            button = answer_button2;
        }

        if (answer_button3.getText().equals(answer)){
            button = answer_button3;
        }

        if (answer_button4.getText().equals(answer)){
            button = answer_button4;
        }

        return button;
    }

    public void endGame(){
        youLostText.setVisible(true);
        returnToMenu.setVisible(true);
        loader_Game_Normal2.setOpacity(0.65);
        loader_Game_Normal2.setVisible(true);
    }

    public Button animateResult() throws Exception{
        Button b = getCorrectAnswerFromButtons();
        timer.cancel();
        Thread.sleep(2000);
        animateButton(b, "Answer");
        return b;
    }

    public void getAnswer1() throws Exception{
        Button b = animateResult();
        if (!b.getText().equals(answer_button1.getText())){
            endGame();
            animateButton(answer_button1, "Wrong");
            return;
        }

        if (super.checkAnswer(game.fragen, questionBox.getText(), answer_button1.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
            animateButton(answer_button1, "Normal");
        }
        answer_button1.setStyle("");
    }

    public void getAnswer2() throws Exception{
        Button b = animateResult();
        if (!b.getText().equals(answer_button2.getText())){
            endGame();
            animateButton(answer_button2, "Wrong");
            return;
        }

        if (super.checkAnswer(game.fragen, questionBox.getText(), answer_button2.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
            animateButton(answer_button2, "Normal");
        }
        answer_button2.setStyle("");
    }

    public void getAnswer3() throws Exception{
        Button b = animateResult();
        if (!b.getText().equals(answer_button3.getText())){
            endGame();
            animateButton(answer_button3, "Wrong");
            return;
        }

        if (super.checkAnswer(game.fragen, questionBox.getText(), answer_button3.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
            animateButton(answer_button3, "Normal");
        }
        answer_button3.setStyle("");
    }

    public void getAnswer4() throws Exception{
        Button b = animateResult();
        if (!b.getText().equals(answer_button4.getText())){
            endGame();
            animateButton(answer_button4, "Wrong");
            return;
        }
        if (super.checkAnswer(game.fragen, questionBox.getText(), answer_button4.getText())){
            game.index_frage++;
            setQuestionAndAnswers();
            animateButton(answer_button4, "Normal");
        }
        answer_button4.setStyle("");
    }

    public void close() throws IOException {
        super.saveData();
        System.exit(0);
    }

    public void handle_gameModes(MouseEvent event) throws Exception {
        if (event.getSource() == gameMode_Normal){
            temp_gameMode = "Normal";
        }

        if (event.getSource() == gameMode_Reverse){
            temp_gameMode = "Reverse";
        }
        showHowManyQuestions();
    }

    public void handle_HowManyQuestions(MouseEvent event) throws Exception {
        if (event.getSource() == amount_Questions10){
            temp_FragenAnzahl = 10;
        }

        if (event.getSource() == amount_Questions15){
            temp_FragenAnzahl = 15;
        }

        if (event.getSource() == amount_Questions20){
            temp_FragenAnzahl = 20;
        }
        loadScene("Game_Settings1.fxml");
    }

    public void handle_ProfileImages(MouseEvent event) throws Exception {
        String local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG";
        if (event.getSource() == profileImage1){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/1.PNG";
        }

        if (event.getSource() == profileImage2){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/2.PNG";
        }

        if (event.getSource() == profileImage3){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/3.PNG";
        }

        if (event.getSource() == profileImage4){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/4.PNG";
        }

        if (event.getSource() == profileImage5){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/5.PNG";
        }

        if (event.getSource() == profileImage6){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/6.PNG";
        }

        if (event.getSource() == profileImage7){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/7.PNG";
        }

        if (event.getSource() == profileImage8){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/8.PNG";
        }

        if (event.getSource() == profileImage9){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/9.PNG";
        }

        if (event.getSource() == profileImage10){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/10.PNG";
        }

        if (event.getSource() == profileImage11){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/11.PNG";
        }

        if (event.getSource() == profileImage12){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/12.PNG";
        }

        if (event.getSource() == profileImage13){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/13.PNG";
        }

        if (event.getSource() == profileImage14){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/14.PNG";
        }

        if (event.getSource() == profileImage15){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/15.PNG";
        }

        if (event.getSource() == profileImage16){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/16.PNG";
        }

        if (event.getSource() == profileImage17){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/17.PNG";
        }

        if (event.getSource() == profileImage18){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/18.PNG";
        }

        if (event.getSource() == profileImage19){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/GG.PNG";
        }

        if (event.getSource() == profileImage20){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG";
        }

        local_User.setProfilePicture(local_Profile_Picure);
        openMenu();
        super.saveData();
        loadScene("Menu.fxml");
    }
}
