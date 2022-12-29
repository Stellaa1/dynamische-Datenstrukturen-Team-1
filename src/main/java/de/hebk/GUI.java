package de.hebk;

import de.hebk.model.list.List;
import de.hebk.model.stack.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.*;

public class GUI extends SystemController {

    private Timer timer = new Timer();
    TimerTask timertask;
    long beforeTimer;
    long afterRun;
    Game game;
    private static String temp_gameMode;
    private static int temp_FragenAnzahl;
    private static String temp_category;
    private static int temp_difficultyValue;
    private static int temp_difficultyRange;
    private static int temp_incrementValue;
    private static int temp_incrementRange;
    private static String temp_currency;

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
    private ImageView profileImage1;
    @FXML
    private ImageView profileImage2;
    @FXML
    private ImageView profileImage3;
    @FXML
    private ImageView profileImage4;
    @FXML
    private ImageView profileImage5;
    @FXML
    private ImageView profileImage6;
    @FXML
    private ImageView profileImage7;
    @FXML
    private ImageView profileImage8;
    @FXML
    private ImageView profileImage9;
    @FXML
    private ImageView profileImage10;
    @FXML
    private ImageView profileImage11;
    @FXML
    private ImageView profileImage12;
    @FXML
    private ImageView profileImage13;
    @FXML
    private ImageView profileImage14;
    @FXML
    private ImageView profileImage15;
    @FXML
    private ImageView profileImage16;
    @FXML
    private ImageView profileImage17;
    @FXML
    private ImageView profileImage18;
    @FXML
    private ImageView profileImage19;
    @FXML
    private ImageView profileImage20;
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
    private Rectangle loader_Top10;
    @FXML
    private Rectangle loader_Top10_Reverse;
    @FXML
    private Rectangle loader_TopAll;
    @FXML
    private Rectangle loader_TopAll_Reverse;
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
    private Text pointsText;
    @FXML
    private Button returnToMenu;
    @FXML
    private Button revive_Button;
    @FXML
    private Text revive_Warning_Text;
    @FXML
    private Button replay_Button;
    @FXML
    private Text timeText;
    @FXML
    private TableView<User> topTable;
    @FXML
    private TableColumn<User, String> topTable_Index;
    @FXML
    private TableColumn<User, String> topTable_Name;
    @FXML
    private TableColumn<User, Integer> topTable_Played;
    @FXML
    private TableColumn<User, Integer> topTable_Won;
    @FXML
    private TableColumn<User, Integer> topTable_Points;
    @FXML
    private TableView<User> topTable_Reverse;
    @FXML
    private TableColumn<User, String> topTable_Index_Reverse;
    @FXML
    private TableColumn<User, String> topTable_Name_Reverse;
    @FXML
    private TableColumn<User, Integer> topTable_Played_Reverse;
    @FXML
    private TableColumn<User, Integer> topTable_Won_Reverse;
    @FXML
    private TableColumn<User, Integer> topTable_Points_Reverse;
    @FXML
    private Rectangle result_Box;
    @FXML
    private Text result_Title;
    @FXML
    private Text result_Answer;
    @FXML
    private Text result_Option1;
    @FXML
    private Text result_Option2;
    @FXML
    private Text result_Option3;
    @FXML
    private Text result_Option4;
    @FXML
    private Text result_Confirm;
    @FXML
    private ImageView result_Option1_Box;
    @FXML
    private ImageView result_Option2_Box;
    @FXML
    private ImageView result_Option3_Box;
    @FXML
    private ImageView result_Option4_Box;
    @FXML
    private CheckBox autoConfirm;
    @FXML
    private ImageView medal_Top1;
    @FXML
    private ImageView medal_Top2;
    @FXML
    private ImageView medal_Top3;
    @FXML
    private ImageView medal_Top4;
    @FXML
    private ImageView medal_Top5;
    @FXML
    private ImageView medal_Top6;
    @FXML
    private ImageView medal_Top7;
    @FXML
    private ImageView medal_Top8;
    @FXML
    private ImageView medal_Top9;
    @FXML
    private ImageView medal_Top10;
    @FXML
    private ImageView image_Top1;
    @FXML
    private ImageView image_Top2;
    @FXML
    private ImageView image_Top3;
    @FXML
    private ImageView image_Top4;
    @FXML
    private ImageView image_Top5;
    @FXML
    private ImageView image_Top6;
    @FXML
    private ImageView image_Top7;
    @FXML
    private ImageView image_Top8;
    @FXML
    private ImageView image_Top9;
    @FXML
    private ImageView image_Top10;
    @FXML
    private Text player_Top1;
    @FXML
    private Text player_Top2;
    @FXML
    private Text player_Top3;
    @FXML
    private Text player_Top4;
    @FXML
    private Text player_Top5;
    @FXML
    private Text player_Top6;
    @FXML
    private Text player_Top7;
    @FXML
    private Text player_Top8;
    @FXML
    private Text player_Top9;
    @FXML
    private Text player_Top10;

    @FXML
    private Text played_Top1;
    @FXML
    private Text played_Top2;
    @FXML
    private Text played_Top3;
    @FXML
    private Text played_Top4;
    @FXML
    private Text played_Top5;
    @FXML
    private Text played_Top6;
    @FXML
    private Text played_Top7;
    @FXML
    private Text played_Top8;
    @FXML
    private Text played_Top9;
    @FXML
    private Text played_Top10;
    @FXML
    private Text won_Top1;
    @FXML
    private Text won_Top2;
    @FXML
    private Text won_Top3;
    @FXML
    private Text won_Top4;
    @FXML
    private Text won_Top5;
    @FXML
    private Text won_Top6;
    @FXML
    private Text won_Top7;
    @FXML
    private Text won_Top8;
    @FXML
    private Text won_Top9;
    @FXML
    private Text won_Top10;
    @FXML
    private Text points_Top1;
    @FXML
    private Text points_Top2;
    @FXML
    private Text points_Top3;
    @FXML
    private Text points_Top4;
    @FXML
    private Text points_Top5;
    @FXML
    private Text points_Top6;
    @FXML
    private Text points_Top7;
    @FXML
    private Text points_Top8;
    @FXML
    private Text points_Top9;
    @FXML
    private Text points_Top10;

    private String[] s = values1;

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

        loadScene("Main_Game.fxml");
    }


    public void setGame(){
        game = new Game();
        game.fragen = new Fragen();
        game.fragen.gameSettings.setGameMode(temp_gameMode);
        game.fragen.gameSettings.setCategory(temp_category);
        game.fragen.gameSettings.setQuestion_Amount(temp_FragenAnzahl);
        game.fragen.gameSettings.setDifficultyValue(temp_difficultyValue);
        game.fragen.gameSettings.setDifficultyRange(temp_difficultyRange);
        game.fragen.gameSettings.setIncrementValue(temp_incrementValue);
        game.fragen.gameSettings.setIncrementRange(temp_incrementRange);

        game.fragen.gameSettings.getJoker().setInfJoker(false);
        game.fragen.gameSettings.getJoker().setRevive(true);
        game.fragen.gameSettings.getJoker().setAudience(true);
        game.fragen.gameSettings.getJoker().setFifty_fifty(true);
        game.fragen.gameSettings.getJoker().setCall(true);


        game.fragen.generateQuestions();
        game.index_frage = 0;
        game.fragen.gameSettings.setCurrency(temp_currency);
    }

    public void startGame() throws Exception {
        loader_Game_Normal.setVisible(false);
        try {
            setGame();
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

            if (game.fragen.gameSettings.getGameMode().equals("Normal")){
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

                if (game.index_frage < game.fragen.gameSettings.getQuestion_Amount()){
                    setQuestionAndAnswers();
                }

            }

            if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
                System.out.println("REVERSE");
                for (int i = 0; i < game.fragen.gameSettings.getQuestion_Amount(); i++){
                    Text questionText = new Text();
                    questionText.setText((game.fragen.gameSettings.getQuestion_Amount() - i) + " ⬩ " + s[(game.fragen.gameSettings.getQuestion_Amount() - i - (1))] + " " + game.fragen.gameSettings.getCurrency());
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

                if (game.index_frage < game.fragen.gameSettings.getQuestion_Amount()){
                    setQuestionAndAnswers();
                }

            }

        } catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            loadScene("Fehler_Game.fxml");
        }



    }

    public void setQuestionAndAnswers() throws Exception{
        if (VALUES[game.index_frage] == null){
            System.out.println("Player Won");
            if (game.fragen.gameSettings.getGameMode().equals("Normal")){
                local_User.setPoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
                local_User.setPlayed(local_User.getPlayed() + 1);
                local_User.setWon(local_User.getWon() + 1);
            }
            if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
                local_User.setReversePoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
                local_User.setPlayed_Reverse(local_User.getPlayed_Reverse() + 1);
                local_User.setWon_Reverse(local_User.getWon_Reverse() + 1);
            }
            return;
        }

        counter();
        if (game.index_frage != 0){
            VALUES[game.index_frage - 1].setStyle("-fx-fill: white");
        }
        VALUES[game.index_frage].setStyle("-fx-fill: #ff8c00");
        if (game.index_frage >= game.fragen.gameSettings.getQuestion_Amount()){
            return;
        }

        List<String> options = null;

        if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            options = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions();
            questionBox.setText(game.fragen.getQuestions().get(game.index_frage).getContext().getQuestion());
        }

        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            options = game.fragen.getQuestions().get(game.fragen.gameSettings.getQuestion_Amount() - 1 - game.index_frage).getContext().getOptions();
            questionBox.setText(game.fragen.getQuestions().get(game.fragen.gameSettings.getQuestion_Amount() - 1 - game.index_frage).getContext().getQuestion());
        }


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
        System.out.println("Reward: " + game.fragen.gameSettings.getReward());
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
        String answer = null;
        if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            answer = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions().get(0).getContext();
        }

        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            answer = game.fragen.getQuestions().get(game.fragen.gameSettings.getQuestion_Amount() - 1 -  game.index_frage).getContext().getOptions().get(0).getContext();
        }

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
        if (result_Box.isVisible()){
            hide_Confirm_Box();
        }
        if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            local_User.setPoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
            local_User.setPlayed(local_User.getPlayed() + 1);
            local_User.setLost(local_User.getLost() + 1);
        }
        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            local_User.setReversePoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
            local_User.setPlayed_Reverse(local_User.getPlayed_Reverse() + 1);
            local_User.setLost_Reverse(local_User.getLost_Reverse() + 1);
        }
        youLostText.setVisible(true);
        pointsText.setText("PUNKTE: " + game.fragen.gameSettings.getReward());
        pointsText.setVisible(true);
        returnToMenu.setVisible(true);
        replay_Button.setVisible(true);
        revive_Button.setVisible(true);
        loader_Game_Normal2.setOpacity(0.65);
        loader_Game_Normal2.setVisible(true);

        if (game.fragen.gameSettings.getJoker().isRevive()){
            revive_Button.setDisable(false);
            revive_Warning_Text.setVisible(true);
        } else{
            revive_Button.setDisable(true);
            revive_Warning_Text.setVisible(false);
        }
    }

    public void walkAway(){
        hide_Confirm_Box();
        if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            local_User.setPoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
            local_User.setPlayed(local_User.getPlayed() + 1);
            local_User.setLost(local_User.getLost() + 1);
        }
        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            local_User.setReversePoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
            local_User.setPlayed_Reverse(local_User.getPlayed_Reverse() + 1);
            local_User.setLost_Reverse(local_User.getLost_Reverse() + 1);
        }
        youLostText.setVisible(true);
        pointsText.setText("PUNKTE: " + game.fragen.gameSettings.getReward());
        pointsText.setVisible(true);
        returnToMenu.setVisible(true);
        replay_Button.setVisible(true);
        loader_Game_Normal2.setOpacity(0.65);
        loader_Game_Normal2.setVisible(true);
    }

    public void hideEndGame(){
        youLostText.setVisible(false);
        pointsText.setVisible(false);
        returnToMenu.setVisible(false);
        replay_Button.setVisible(false);
        revive_Button.setVisible(false);
        revive_Warning_Text.setVisible(false);
        loader_Game_Normal2.setOpacity(1);
        loader_Game_Normal2.setVisible(false);
    }

    public void resetButtons(){
        animateButton(answer_button1, "Normal");
        animateButton(answer_button2, "Normal");
        animateButton(answer_button3, "Normal");
        animateButton(answer_button4, "Normal");
        answer_button1.setStyle("");
        answer_button2.setStyle("");
        answer_button3.setStyle("");
        answer_button4.setStyle("");
    }

    public void resetValues(){
        for (int i = 1; i < VALUES.length; i++){
            if (VALUES[i - 1] == null){
                break;
            }
            VALUES[i - 1].setStyle("-fx-fill: white");
        }
        VALUES[game.index_frage].setStyle("-fx-fill: #ff8c00");
    }
    public void replay() throws Exception {
        hideEndGame();
        setGame();
        setQuestionAndAnswers();
        resetButtons();
        resetValues();
    }

    public void revive(){
        hideEndGame();
        game.fragen.gameSettings.setReward(0);
        resetButtons();
        game.fragen.gameSettings.getJoker().setRevive(game.fragen.gameSettings.getJoker().isInfJoker() ? true : false);
    }

    public void confirm(){
        hide_Confirm_Box();
        result_Box.setVisible(true);
        result_Title.setText("DEINE ANTWORT:");
        result_Title.setVisible(true);
        result_Answer.setVisible(true);
        result_Confirm.setText("BIST DU SICHER?");
        result_Confirm.setVisible(true);
        result_Option1_Box.setVisible(true);
        result_Option1.setVisible(true);
        result_Option2_Box.setVisible(true);
        result_Option2.setVisible(true);
        result_Option3_Box.setVisible(true);
        result_Option3.setVisible(true);
    }

    public void confirm2(){
        hide_Confirm_Box();
        result_Box.setVisible(true);
        result_Title.setVisible(true);
        result_Answer.setVisible(true);
       //if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            //result_Confirm.setText(s[game.index_frage] + " " + game.fragen.gameSettings.getCurrency());
            result_Confirm.setText("PUNKTE: " + game.fragen.gameSettings.getReward());
        //}
        //if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            //result_Confirm.setText(s[(game.fragen.gameSettings.getQuestion_Amount() - game.index_frage - (1))] + " " + game.fragen.gameSettings.getCurrency());
        //}
        result_Confirm.setVisible(true);
        result_Option3_Box.setVisible(true);
        result_Option3.setVisible(true);
        result_Option4_Box.setVisible(true);
        result_Option4.setVisible(true);
    }

    public void hide_Confirm_Box(){
        result_Box.setVisible(false);
        result_Title.setVisible(false);
        result_Answer.setVisible(false);
        result_Confirm.setVisible(false);
        result_Option1_Box.setVisible(false);
        result_Option1.setVisible(false);
        result_Option2_Box.setVisible(false);
        result_Option2.setVisible(false);
        result_Option3_Box.setVisible(false);
        result_Option3.setVisible(false);
        result_Option4.setVisible(false);
        result_Option4_Box.setVisible(false);
    }

    public void continueGame() throws Exception {
        hide_Confirm_Box();
        Button b = getCorrectAnswerFromButtons();
        game.index_frage++;
        setQuestionAndAnswers();
        animateButton(b, "Normal");
        b.setStyle("");
    }

    public Button animateResult() throws Exception{
        Button b = getCorrectAnswerFromButtons();
        timer.cancel();
        animateButton(b, "Answer");
        return b;
    }

    public void answer() throws Exception {
        hide_Confirm_Box();
        Button b = animateResult();
        if (!b.getText().equals(result_Answer.getText())){
            Button b2 = null;
            if (answer_button1.getText().equals(result_Answer.getText())){
                b2 = answer_button1;
            }
            if (answer_button2.getText().equals(result_Answer.getText())){
                b2 = answer_button2;
            }
            if (answer_button3.getText().equals(result_Answer.getText())){
                b2 = answer_button3;
            }            if (answer_button4.getText().equals(result_Answer.getText())){
                b2 = answer_button4;
            }
            endGame();
            animateButton(b, "Answer");
            animateButton(b2, "Wrong");
            return;
        }

        if (super.checkAnswer(game.fragen, questionBox.getText(), result_Answer.getText())){
            System.out.println("Reward " + game.fragen.gameSettings.getReward());
            changeReward();
            System.out.println("Reward " + game.fragen.gameSettings.getReward());
            confirm2();
        }
        b.setStyle("");
    }

    public void changeGameAutoConfirm(){
        game.fragen.gameSettings.setAutoConfirm(autoConfirm.isSelected());
    }
    public void getAnswer1() throws Exception{
        answerFunction(answer_button1);
    }

    public void getAnswer2() throws Exception{
        answerFunction(answer_button2);
    }

    public void getAnswer3() throws Exception{
        answerFunction(answer_button3);
    }

    public void getAnswer4() throws Exception{
        answerFunction(answer_button4);
    }

    public void answerFunction(Button b) throws Exception {
        if (!game.fragen.gameSettings.isAutoConfirm()){
            b.setStyle("");
            result_Answer.setText(b.getText());
            confirm();
        } else {
            Button b2 = getCorrectAnswerFromButtons();
            if (!b.getText().equals(b2.getText())){
                endGame();
                animateButton(b2, "Answer");
                animateButton(b, "Wrong");
                return;
            }

            if (super.checkAnswer(game.fragen, questionBox.getText(), b.getText())){
                game.index_frage++;
                setQuestionAndAnswers();
                animateButton(b, "Normal");
                changeReward();
            }
        }
        b.setStyle("");
    }
    public void changeReward(){
        if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            game.fragen.gameSettings.setReward(game.fragen.gameSettings.getReward() + game.fragen.getQuestions().get(game.index_frage).getContext().getDifficulty());
        }

        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            game.fragen.gameSettings.setReward(game.fragen.gameSettings.getReward() + game.fragen.getQuestions().get(game.fragen.getQuestions().size() - 1 - game.index_frage).getContext().getDifficulty());
        }
    }


    public void showTopPlayersMenu() throws Exception{
        loadScene("TopPlayersMenu.fxml");
    }


    public void showTop10() throws Exception{
        loadScene("Top10.fxml");
    }

    public void showTop10_Reverse() throws Exception{
        loadScene("Top10_Reverse.fxml");
    }

    public void showTopAll() throws Exception{
        loadScene("TopAll.fxml");
    }

    public void showTopAll_Reverse() throws Exception{
        loadScene("TopAllReverse.fxml");
    }

    public void setTop10(String method) throws FileNotFoundException {
        Stack<User> top10 = null;

        top10 = (method.equals("Normal") == true ? calculateTop10("Normal") : calculateTop10("Reverse"));

        int x = 0;

        try {
            boolean t = (top10.get(x).getContext() == null ? true : false);
            System.out.println(t);


            if (!t){
                medal_Top1.setVisible(true);
                image_Top1.setVisible(true);
                player_Top1.setVisible(true);
                played_Top1.setVisible(true);
                won_Top1.setVisible(true);
                points_Top1.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top1.setImage(image);
                player_Top1.setText(users.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top1.setText("" + users.get(x).getContext().getPlayed());
                    won_Top1.setText("" + users.get(x).getContext().getWon());
                    points_Top1.setText("" + users.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top1.setText("" + users.get(x).getContext().getPlayed_Reverse());
                    won_Top1.setText("" + users.get(x).getContext().getWon_Reverse());
                    points_Top1.setText("" + users.get(x).getContext().getReversePoints());
                }
            }

            x = 1;
            t = (top10.get(x).getContext() == null ? true : false);
            System.out.println(t);
            System.out.println(top10.get(x).getContext().getPoints() + " user x");

            if (!t){
                medal_Top2.setVisible(true);
                image_Top2.setVisible(true);
                player_Top2.setVisible(true);
                played_Top2.setVisible(true);
                won_Top2.setVisible(true);
                points_Top2.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(1).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top2.setImage(image);
                player_Top2.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top2.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top2.setText("" + top10.get(x).getContext().getWon());
                    points_Top2.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top2.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top2.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top2.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 2;
            t = (top10.get(x).getContext() == null ? true : false);
            System.out.println(t);
            System.out.println(top10.get(x).getContext().getPoints() + " user x");


            if (!t){
                medal_Top3.setVisible(true);
                image_Top3.setVisible(true);
                player_Top3.setVisible(true);
                played_Top3.setVisible(true);
                won_Top3.setVisible(true);
                points_Top3.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top3.setImage(image);
                player_Top3.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top3.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top3.setText("" + top10.get(x).getContext().getWon());
                    points_Top3.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top3.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top3.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top3.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 3;
            t = (top10.get(x).getContext() == null ? true : false);
            System.out.println(top10.get(x).getContext().getPoints() + " user x");


            if (!t){
                medal_Top4.setVisible(true);
                image_Top4.setVisible(true);
                player_Top4.setVisible(true);
                played_Top4.setVisible(true);
                won_Top4.setVisible(true);
                points_Top4.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top4.setImage(image);
                player_Top4.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top4.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top4.setText("" + top10.get(x).getContext().getWon());
                    points_Top4.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top4.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top4.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top4.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 4;
            t = (top10.get(x).getContext() == null ? true : false);

            if (!t){
                medal_Top5.setVisible(true);
                image_Top5.setVisible(true);
                player_Top5.setVisible(true);
                played_Top5.setVisible(true);
                won_Top5.setVisible(true);
                points_Top5.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top5.setImage(image);
                player_Top5.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top5.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top5.setText("" + top10.get(x).getContext().getWon());
                    points_Top5.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top5.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top5.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top5.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 5;
            t = (top10.get(x).getContext() == null ? true : false);

            if (!t){
                medal_Top6.setVisible(true);
                image_Top6.setVisible(true);
                player_Top6.setVisible(true);
                played_Top6.setVisible(true);
                won_Top6.setVisible(true);
                points_Top6.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top6.setImage(image);
                player_Top6.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top6.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top6.setText("" + top10.get(x).getContext().getWon());
                    points_Top6.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top6.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top6.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top6.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 6;
            t = (top10.get(x).getContext() == null ? true : false);

            if (!t){
                medal_Top7.setVisible(true);
                image_Top7.setVisible(true);
                player_Top7.setVisible(true);
                played_Top7.setVisible(true);
                won_Top7.setVisible(true);
                points_Top7.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top7.setImage(image);
                player_Top7.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top7.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top7.setText("" + top10.get(x).getContext().getWon());
                    points_Top7.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top7.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top7.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top7.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 7;
            t = (top10.get(x).getContext() == null ? true : false);

            if (!t){
                medal_Top8.setVisible(true);
                image_Top8.setVisible(true);
                player_Top8.setVisible(true);
                played_Top8.setVisible(true);
                won_Top8.setVisible(true);
                points_Top8.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top8.setImage(image);
                player_Top8.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top8.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top8.setText("" + top10.get(x).getContext().getWon());
                    points_Top8.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top8.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top8.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top8.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 8;
            t = (top10.get(x).getContext() == null ? true : false);

            if (!t){
                medal_Top9.setVisible(true);
                image_Top9.setVisible(true);
                player_Top9.setVisible(true);
                played_Top9.setVisible(true);
                won_Top9.setVisible(true);
                points_Top9.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top9.setImage(image);
                player_Top9.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top9.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top9.setText("" + top10.get(x).getContext().getWon());
                    points_Top9.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top9.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top9.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top9.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }


            x = 9;
            t = (top10.get(x).getContext() == null ? true : false);

            if (!t){
                medal_Top10.setVisible(true);
                image_Top10.setVisible(true);
                player_Top10.setVisible(true);
                played_Top10.setVisible(true);
                won_Top10.setVisible(true);
                points_Top10.setVisible(true);
                FileInputStream inputStream = new FileInputStream(top10.get(x).getContext().getProfilePicture());
                Image image = new Image(inputStream);
                image_Top10.setImage(image);
                player_Top10.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top10.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top10.setText("" + top10.get(x).getContext().getWon());
                    points_Top10.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top10.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top10.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top10.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return;
        }

    }

    public void setTopAll(){
        loader_TopAll.setVisible(false);
        Stack<User> topAll = calculateTop10("Normal");
        ObservableList<User> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < topAll.size(); i++){
            observableList.add(topAll.get(i).getContext());
        }

        topTable_Name.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        topTable_Played.setCellValueFactory(new PropertyValueFactory<User, Integer>("played"));
        topTable_Won.setCellValueFactory(new PropertyValueFactory<User, Integer>("won"));
        topTable_Points.setCellValueFactory(new PropertyValueFactory<User, Integer>("points"));


        topTable.setItems(observableList);
    }

    public void setTopAll_Reverse(){
        loader_TopAll_Reverse.setVisible(false);
        Stack<User> topAll_Reverse = calculateTop10("Reverse");
        ObservableList<User> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < topAll_Reverse.size(); i++){
            observableList.add(topAll_Reverse.get(i).getContext());
        }

        topTable_Name_Reverse.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        topTable_Played_Reverse.setCellValueFactory(new PropertyValueFactory<User, Integer>("played_Reverse"));
        topTable_Won_Reverse.setCellValueFactory(new PropertyValueFactory<User, Integer>("won_Reverse"));
        topTable_Points_Reverse.setCellValueFactory(new PropertyValueFactory<User, Integer>("reversePoints"));


        topTable_Reverse.setItems(observableList);
    }

    public void close() throws IOException {
        super.saveData();
        System.exit(0);
    }

    public void handle_TopMenu(MouseEvent event) throws Exception{
        System.out.println("HANDLE");
        System.out.println(event.getSource().toString());
        if (event.getSource() == loader_Top10){
            loader_Top10.setVisible(false);
            setTop10("Normal");
        }

        if (event.getSource() == loader_Top10_Reverse){
            System.out.println("Reverse loader");
            loader_Top10_Reverse.setVisible(false);
            setTop10("Reverse");
        }

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
