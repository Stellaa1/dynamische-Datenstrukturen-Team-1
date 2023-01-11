package de.hebk;

import de.hebk.model.list.List;
import de.hebk.model.stack.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GUI extends SystemController {
    static int wait_idle = 4;
    static int wait_win = 4;
    static int wait_lose = 4;
    private Timer timer = new Timer();
    private Timer answer_timer = new Timer();
    private Timer answer_timer_win = new Timer();
    private Timer answer_timer_lose = new Timer();
    TimerTask timertask;
    TimerTask answer_timertask;
    TimerTask answer_timertask_win;
    TimerTask answer_timertask_lose;
    long beforeTimer;
    long afterRun;
    Multiplayer multiplayer;
    Game game;
    private static String temp_gameMode;
    private static int temp_FragenAnzahl;
    private static String temp_category;
    private static int temp_difficultyValue;
    private static int temp_difficultyRange;
    private static int temp_incrementValue;
    private static int temp_incrementRange;
    private static String temp_currency;
    private static boolean temp_cheats_infJoker = false;
    private static boolean temp_cheats_infTime = false;
    private static boolean temp_cheats_infLife = false;
    private static boolean temp_cheats_alwaysFiftyFifty = false;
    private static boolean temp_cheats_alwaysCall = false;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer_Video;
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
    private VBox newVBP1;
    @FXML
    private VBox newVBP2;
    @FXML
    private PasswordField passwordField;
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
    private ImageView profileImage21;
    @FXML
    private ImageView profileImage22;
    @FXML
    private ImageView profileImage23;
    @FXML
    private ImageView profileImage24;
    @FXML
    private ImageView questionImage;
    @FXML
    private VBox questionsVBox;
    @FXML
    private TextArea questionBox;
    @FXML
    private Text answer_text1;
    @FXML
    private Text answer_text2;
    @FXML
    private Text answer_text3;
    @FXML
    private Text answer_text4;
    @FXML
    private Rectangle answer_rectangle1;
    @FXML
    private Rectangle answer_rectangle2;
    @FXML
    private Rectangle answer_rectangle3;
    @FXML
    private Rectangle answer_rectangle4;
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
    private PasswordField anmelden_Password;
    @FXML
    private PasswordField anmelden_PasswortWiederholen;
    @FXML
    private ImageView anmelden_Image1;
    @FXML
    private TextField anmelden_Benutzername1;
    @FXML
    private PasswordField anmelden_Password1;
    @FXML
    private PasswordField anmelden_PasswortWiederholen1;
    @FXML
    private ImageView anmelden_Image2;
    @FXML
    private TextField anmelden_Benutzername2;
    @FXML
    private PasswordField anmelden_Password2;
    @FXML
    private PasswordField anmelden_PasswortWiederholen2;
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
    private Rectangle loader_Game_Multiplayer_Normal;
    @FXML
    private Rectangle loader_Top10;
    @FXML
    private Rectangle loader_Top10_Reverse;
    @FXML
    private Rectangle loader_TopAll;
    @FXML
    private Rectangle loader_TopAll_Reverse;
    @FXML
    private Rectangle loader_User_Statistics;
    @FXML
    private Rectangle loader_Cheats;
    @FXML
    private Rectangle loader_Achievements;
    @FXML
    private Rectangle loader_AccountInformation;
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
    @FXML
    private ImageView joker_fifty_fifty;
    @FXML
    private ImageView joker_audience;
    @FXML
    private ImageView joker_call;
    @FXML
    private ImageView joker_fifty_fiftyP1;
    @FXML
    private ImageView joker_audienceP1;
    @FXML
    private ImageView joker_callP1;
    @FXML
    private ImageView joker_fifty_fiftyP2;
    @FXML
    private ImageView joker_audienceP2;
    @FXML
    private ImageView joker_callP2;
    @FXML
    private Text user_userName;
    @FXML
    private Text user_joinedDate;
    @FXML
    private Text userInformation_Name;
    @FXML
    private Text userInformation_Password;
    @FXML
    private Text userRank_Normal;
    @FXML
    private Text userRank_Reverse;
    @FXML
    private Text userPoints_Normal;
    @FXML
    private Text userPoints_Reverse;
    @FXML
    private Text user_Achievements;
    @FXML
    private LineChart<String, Integer> user_GameResults_Chart;
    @FXML
    private Text user_GameResults_Chart_PlayedText;
    @FXML
    private Text user_GameResults_Chart_WonText;
    @FXML
    private Text user_GameResults_Chart_LostText;
    @FXML
    private Rectangle audienceJoker_Background;
    @FXML
    private BarChart<String, Integer> audienceJoker_Chart;
    @FXML
    private ImageView result_audienceJoker_Box;
    @FXML
    private Text result_audienceJoker_Option;

    @FXML
    private Text user_GameResults_Chart_PlayedText_Reverse;
    @FXML
    private Text user_GameResults_Chart_WonText_Reverse;
    @FXML
    private Text user_GameResults_Chart_LostText_Reverse;
    @FXML
    private Button user_GameResults_Chart_switch;
    @FXML
    private PieChart user_Achievements_Chart;
    @FXML
    private BarChart<String, Integer> user_Joker_Chart;
    @FXML
    private Text user_favoriteSubject;
    @FXML
    private Text percentageOfWin;
    @FXML
    private ImageView user_Profilepicture;
    @FXML
    private CheckBox cheat1;
    @FXML
    private CheckBox cheat2;
    @FXML
    private CheckBox cheat3;
    @FXML
    private CheckBox cheat4;
    @FXML
    private CheckBox cheat5;
    @FXML
    private Text multiplayer_Player1Points;
    @FXML
    private Text multiplayer_Player2Points;
    @FXML
    private Text multiplayer_Player1Name;
    @FXML
    private Text multiplayer_Player2Name;
    @FXML
    private ImageView multiplayer_Crown;
    @FXML
    private ImageView multiplayer_WinnerImage;
    @FXML
    private Text multiplayer_WinnerName;
    @FXML
    private Text multiplayer_GameResults_Winner;
    @FXML
    private Text multiplayer_GameResults_RunnerUp;
    @FXML
    private ImageView achievements_ProfileImage;
    @FXML
    private Text achievements_Username;
    @FXML
    private Pane achievement1;
    @FXML
    private Pane achievement2;
    @FXML
    private Pane achievement3;
    @FXML
    private Pane achievement4;
    @FXML
    private Pane achievement5;
    @FXML
    private Pane achievement6;
    @FXML
    private Pane achievement7;
    @FXML
    private Pane achievement8;
    @FXML
    private Pane achievement9;
    @FXML
    private Pane achievement10;
    @FXML
    private Pane achievement11;
    @FXML
    private Pane achievement12;
    @FXML
    private ImageView image_AccountInformation;
    @FXML
    private PasswordField changePassword_Field1;
    @FXML
    private PasswordField changePassword_Field2;
    @FXML
    private PasswordField changePassword_Field3;
    @FXML
    private Rectangle result_Box_Call;
    @FXML
    private Text result_Box_Call_Description;
    @FXML
    private ImageView result_Option1_Box_Call;
    @FXML
    private Text result_Option1_Call;
    private String[] s = values1;
    private String firstColor = "#49529d";
    private String secondColor = "#ff8c00";
    private MediaView mediaView;
    static private final Text[] VALUES = new Text[20];
    static private final Text[] VALUES2 = new Text[20];
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
            availabilityText.setText("(✕) Mindestens 3 und Maximal 15 Zeichen erfordert");
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
        super.saveData();
        stopSound();
        loadScene("Menu.fxml");
    }


    public void showSettings() throws Exception{
        loadScene("Settings.fxml");
    }

    public void showMultiplayer() throws Exception{
        loadScene("MultiplayerOderQuestionmaker.fxml");
    }

    public void showMultiplayerLogIn() throws Exception{
        loadScene("LogIn_Multiplayer.fxml");
    }


    public void setMultiPlayer(){
        Multiplayer multiplayer;
    }

    public void createUser() throws Exception {

        int index = searchForUser(nameField.getText());

        if (index != -1){
            loadScene("Error_LogIn.fxml");
            return;
        }

        if (!super.checkValidName(nameField.getText())){
            loadScene("Error_LogIn.fxml");
            return;
        }

        if (!super.checkValidPassword(passwordField.getText())){
            loadScene("Error_LogIn.fxml");
            return;
        }

        User u = new User();
        u.setName(nameField.getText());
        u.setPassword(passwordField.getText());
        u.setAchievements(new List<>());
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/y HH:mm:ss");
        u.setJoinDate(simpleDateFormat.format(d));
        u.setFavorite_subjects(new List<Integer>());
        for (int i = 0; i < csvFiles_Questions.length; i++){
            u.getFavorite_subjects().append(0);
        }

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

    public void resetStreak(){
        if (multiplayer != null){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                multiplayer.getPlayer1Settings().setStreak(0);
            } else {
                multiplayer.getPlayer2Settings().setStreak(0);
            }
        } else {
            game.fragen.gameSettings.setStreak(0);
        }
    }
    public void changeStreak(){
        GameSettings gameSettings;
        User u;
        if (multiplayer != null){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                multiplayer.getPlayer1Settings().setStreak(multiplayer.getPlayer1Settings().getStreak() + 1);
                gameSettings = multiplayer.getPlayer1Settings();
                u = multiplayer.getPlayer1();
            } else {
                multiplayer.getPlayer2Settings().setStreak(multiplayer.getPlayer2Settings().getStreak() + 1);
                gameSettings = multiplayer.getPlayer2Settings();
                u = multiplayer.getPlayer2();
            }
        } else {
            game.fragen.gameSettings.setStreak(game.fragen.gameSettings.getStreak() + 1);
            gameSettings = game.fragen.gameSettings;
            u = local_User;
        }
        if (gameSettings.getStreak() >= 5){
            reward(u, "Du hast einen langen Weg vor dir");
        }
        if (gameSettings.getStreak() >= 10){
            reward(u, "Kein Defizit");
        }
        if (gameSettings.getStreak() >= 15){
            reward(u, "Genie");
        }
        if (gameSettings.getStreak() >= 20){
            reward(u, "Ein Stein");
        }
    }

    public void showLogIn() throws Exception{
        super.loadData();
        loadScene("LogIn.fxml");
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
            loadScene("Error_LogIn.fxml");
            return;
        }

        if (!anmelden_Password.getText().equals(anmelden_PasswortWiederholen.getText())){
            loadScene("Error_LogIn.fxml");
            return;
        }


        User u = users.get(index).getContext();
        for (int i = 0; i < csvFiles_Questions.length; i++){
            if (u.getFavorite_subjects().get(i) == null){
                u.getFavorite_subjects().append(0);
            }
        }
        if (!anmelden_Password.getText().equals(u.getPassword())){
            loadScene("Error_LogIn.fxml");
            return;
        }
        local_User = u;

        loadScene("Menu.fxml");
    }

    public void logIn_Multiplayer() throws Exception{
        if (!anmelden_Benutzername1.getText().equals(local_User.getName())){
            loadScene("Error_LogIn.fxml");
            return;
        }


        if (!anmelden_Password1.getText().equals(anmelden_PasswortWiederholen1.getText())){
            loadScene("Error_LogIn.fxml");
            return;
        }


        for (int i = 0; i < csvFiles_Questions.length; i++){
            if (local_User.getFavorite_subjects().get(i) == null){
                local_User.getFavorite_subjects().append(0);
            }
        }
        if (!anmelden_Password1.getText().equals(local_User.getPassword())){
            loadScene("Error_LogIn.fxml");
            return;
        }
        multiPlayer_Player1 = local_User;

        int index = searchForUser(anmelden_Benutzername2.getText());

        if (index == -1){
            loadScene("Error_LogIn.fxml");
            return;
        }

        if (!anmelden_Password2.getText().equals(anmelden_PasswortWiederholen2.getText())){
            loadScene("Error_LogIn.fxml");
            return;
        }


        User u = users.get(index).getContext();
        for (int i = 0; i < csvFiles_Questions.length; i++){
            if (u.getFavorite_subjects().get(i) == null){
                u.getFavorite_subjects().append(0);
            }
        }
        if (!anmelden_Password2.getText().equals(u.getPassword())){
            loadScene("Error_LogIn.fxml");
            return;
        }
        multiPlayer_Player2 = u;
        temp_gameMode = "Multiplayer - Normal";
        loadScene("Fragenzahl.fxml");
    }

    public void counter() throws Exception{
        try {
            System.out.println("Main Timer Started");
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
                        try {
                            endGame();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            timer.schedule(timertask, 0, 1000);
            super.saveData();
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void counter_answer(Text t) throws Exception{
        try {
            Rectangle r = getRectangleFromTexts(t.getText());
            System.out.println(r + " r");
            answer_timer = new Timer();
            timer.cancel();
            double[] time = {3.00};
            answer_timertask = new TimerTask() {
                @Override
                public void run() {
                    if (time[0] >= 0.0){
                        time[0] -= 0.5;
                        System.out.println(time[0]);
                        if (r.getStyle().equals("") || r.getStyle().equals("-fx-fill: rgb(73,82,157)")){
                            r.setStyle("-fx-fill: rgb(255,140,0)");
                        } else {
                            r.setStyle("-fx-fill: rgb(73,82,157)");
                        }
                    }
                    if (time[0] < 0){
                        answer_timer.cancel();
                        try {
                            System.out.println(answerResult_DisabledAutoAnswer(t) + " answerResult_DisabledAutoAnswer(t)");
                            if (answerResult_DisabledAutoAnswer(t)){
                                counter_answer_win(t);
                            } else {
                                counter_answer_lose(t);
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            };
            answer_timer.schedule(answer_timertask, 0, 500);
        } catch (Exception e){
        }
    }

    public void counter_answer_win(Text t) throws Exception{
        try {
            Rectangle r = getRectangleFromTexts(t.getText());
            answer_timer_win = new Timer();
            setSoundOnProgress_Win();
            double[] time = {wait_win};
            answer_timertask_win = new TimerTask() {
                @Override
                public void run() {
                    if (time[0] >= 0.0){
                        time[0] -= 0.2;
                        System.out.println(time[0]);
                        if (r.getStyle().equals("") || r.getStyle().equals("-fx-fill: rgb(73,82,157)")){
                            r.setStyle("-fx-fill: rgb(0,255,140)");
                        } else {
                            r.setStyle("-fx-fill: rgb(73,82,157)");
                        }
                    }
                    if (time[0] < 0){
                        answer_timer_win.cancel();
                        try {
                            game.index_frage++;
                            setQuestionAndAnswers();
                            animateObjects(r, "Normal");
                            changeStreak();
                            changeReward();
                            playBackgroundSound();
                        } catch (Exception e) {
                        }
                    }
                }
            };
            answer_timer_win.schedule(answer_timertask_win, 0, 200);
        } catch (Exception e){
        }
    }

    public void counter_answer_lose(Text t) throws Exception{
        try {
            Rectangle r = getRectangleFromTexts(t.getText());
            answer_timer_lose = new Timer();
            setSoundOnProgress_Lose();
            double[] time = {wait_lose};
            answer_timertask_lose = new TimerTask() {
                @Override
                public void run() {
                    if (time[0] >= 0.0){
                        time[0] -= 0.7;
                        System.out.println(time[0]);
                        if (r.getStyle().equals("") || r.getStyle().equals("-fx-fill: rgb(73,82,157)")){
                            r.setStyle("-fx-fill: rgb(255,0,40)");
                        } else {
                            r.setStyle("-fx-fill: rgb(73,82,157)");
                        }
                    }
                    if (time[0] < 0){
                        answer_timer_lose.cancel();
                        if (!game.fragen.gameSettings.getCheats().isInfLife()){
                            if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
                                try {
                                    resetStreak();
                                    endGame();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                Rectangle r2 = getCorrectAnswerFromRectangels();
                                animateObjects(r2, "Answer");
                                animateObjects(r, "Wrong");
                            } else {
                                try {
                                    game.index_frage++;
                                    setQuestionAndAnswers();
                                    animateObjects(r, "Normal");
                                    playBackgroundSound();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        } else{
                            try {
                                game.index_frage++;
                                setQuestionAndAnswers();
                                animateObjects(r, "Normal");
                                playBackgroundSound();
                            } catch (Exception e){
                            }
                        }
                    }
                }
            };
            answer_timer_lose.schedule(answer_timertask_lose, 0, 700);
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

    public void showAccountInformation() throws Exception{
        loadScene("Profile.fxml");
    }

    public void showProfilePictures1() throws Exception{
        loadScene("ProfilePictures1.fxml");
    }
    public void showProfilePictures2() throws Exception{
        loadScene("ProfilePictures2.fxml");
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
        if (temp_gameMode.equals("Multiplayer - Normal")){
            loadScene("Main_Game_Multiplayer.fxml");
        } else {
            loadScene("Main_Game.fxml");
        }
    }

    public void restartJokerImages(){
        if (joker_fifty_fifty != null){
            joker_fifty_fifty.setDisable(false);
            joker_fifty_fifty.setOpacity(1);
        }
        if (joker_fifty_fiftyP1 != null){
            joker_fifty_fiftyP1.setDisable(false);
            joker_fifty_fiftyP1.setOpacity(1);

        }
        if (joker_fifty_fiftyP2 != null){
            joker_fifty_fiftyP2.setDisable(false);
            joker_fifty_fiftyP2.setOpacity(1);
        }
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

        game.fragen.gameSettings.getJoker().setRevive(true);
        game.fragen.gameSettings.getJoker().setAudience(true);
        game.fragen.gameSettings.getJoker().setFifty_fifty(true);
        game.fragen.gameSettings.getJoker().setCall(true);
        restartJokerImages();

        game.fragen.gameSettings.getCheats().setInfJoker(temp_cheats_infJoker);
        game.fragen.gameSettings.getCheats().setInfTime(temp_cheats_infTime);
        game.fragen.gameSettings.getCheats().setInfLife(temp_cheats_infLife);
        game.fragen.gameSettings.getCheats().setAlwaysFiftyFifty(temp_cheats_alwaysFiftyFifty);
        game.fragen.gameSettings.getCheats().setAlwaysCall(temp_cheats_alwaysCall);

        game.fragen.generateQuestions();
        game.index_frage = 0;
        game.fragen.gameSettings.setCurrency(temp_currency);

        stopSound();
        playSound("/de/hebk/Sounds/Musik/100-1000-Questions.mp3");

        if (autoConfirm.isSelected()){
            game.fragen.gameSettings.setAutoConfirm(true);
        }
        joker_fifty_fifty.setOpacity(1);

    }

    public void startGame() {
        loader_Game_Normal.setVisible(false);

        try {
            setGame();
            System.out.println(temp_category);
            for (int i = 0; i < csvFiles_Questions.length; i++){
                if (csvFiles_Questions[i].equals(temp_category)){
                    System.out.println(true);
                    local_User.getFavorite_subjects().get(i).setContext(local_User.getFavorite_subjects().get(i).getContext() + 1);
                    System.out.println(local_User.getFavorite_subjects().toString());
                    break;
                }
            }

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

            playVideo("/de/hebk/Videos/Win_Effect.mp4");

        } catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            try {
                loadScene("Error_Game.fxml");
            } catch (Exception e2){
            }
        }
    }

    public void startGame_Multiplayer() {
        loader_Game_Multiplayer_Normal.setVisible(false);
        multiplayer_Player1Name.setText(multiPlayer_Player1.getName());
        multiplayer_Player2Name.setText(multiPlayer_Player2.getName());


        try {
            setGame_Multiplayer();
            System.out.println(temp_category);
            for (int i = 0; i < csvFiles_Questions.length; i++){
                if (csvFiles_Questions[i].equals(temp_category)){
                    multiplayer.getPlayer1().getFavorite_subjects().get(i).setContext(multiplayer.getPlayer1().getFavorite_subjects().get(i).getContext() + 1);
                    multiplayer.getPlayer2().getFavorite_subjects().get(i).setContext(multiplayer.getPlayer2().getFavorite_subjects().get(i).getContext() + 1);
                    break;
                }
            }

            int tg = 47;
            if (game.fragen.gameSettings.getQuestion_Amount() == 20){
                tg = 47;
                newVBP1.setSpacing(45);
                newVBP2.setSpacing(45);
                s = values1;
            }

            if (game.fragen.gameSettings.getQuestion_Amount() == 30){
                tg = 38;
                newVBP1.setSpacing(25);
                newVBP2.setSpacing(25);
                s = values2;
            }

            if (game.fragen.gameSettings.getQuestion_Amount() == 40){
                tg = 30;
                newVBP1.setSpacing(17);
                newVBP2.setSpacing(17);
                s = values3;
            }

            newVBP1.getChildren().clear();
            newVBP2.getChildren().clear();

            //if (multiplayer.getGame().fragen.gameSettings.getGameMode().equals("Normal")){
            for (int i = 0; i < game.fragen.gameSettings.getQuestion_Amount() / 2; i++){
                Text questionText = new Text();
                questionText.setText((i + 1) + " ⬩ " + s[i] + " " + game.fragen.gameSettings.getCurrency());
                questionText.setWrappingWidth(350.65087890625);
                questionText.setTextAlignment(TextAlignment.CENTER);
                questionText.setFill(Paint.valueOf("#ffffff"));
                Font questionText_Font = Font.font("Arial",tg);
                questionText.setFont(questionText_Font);
                System.out.println(i + " " + VALUES[i]);
                VALUES[i] = questionText;
                System.out.println(i + " " + VALUES[i]);
                newVBP1.getChildren().add(questionText);
            }

            VALUES[0].setStyle("-fx-fill: #ff8c00");

            for (int i = 0; i < game.fragen.gameSettings.getQuestion_Amount() / 2; i++){
                Text questionText = new Text();
                questionText.setText((i + 1) + " ⬩ " + s[i] + " " + game.fragen.gameSettings.getCurrency());
                questionText.setWrappingWidth(350.65087890625);
                questionText.setTextAlignment(TextAlignment.CENTER);
                questionText.setFill(Paint.valueOf("#ffffff"));
                Font questionText_Font = Font.font("Arial",tg);
                questionText.setFont(questionText_Font);
                System.out.println(i + " " + VALUES[i]);
                VALUES2[i] = questionText;
                System.out.println(i + " " + VALUES[i]);
                newVBP2.getChildren().add(questionText);
            }

            if (game.index_frage < game.fragen.gameSettings.getQuestion_Amount()){
                multiplayer.setCurrentPlayer(multiplayer.getPlayer1());
                setQuestionAndAnswers();
            }

            //}

        } catch(Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            try {
                loadScene("Error_Game.fxml");
            } catch (Exception e2){
            }
        }
    }

    public void setGame_Multiplayer(){
        multiplayer = new Multiplayer();
        multiplayer.setPlayer1(multiPlayer_Player1);
        multiplayer.setPlayer2(multiPlayer_Player2);
        game = new Game();
        game.fragen = new Fragen();
        game.fragen.gameSettings.setGameMode(temp_gameMode);
        game.fragen.gameSettings.setCategory(temp_category);
        game.fragen.gameSettings.setQuestion_Amount(temp_FragenAnzahl);
        game.fragen.gameSettings.setDifficultyValue(temp_difficultyValue);
        game.fragen.gameSettings.setDifficultyRange(temp_difficultyRange);
        game.fragen.gameSettings.setIncrementValue(temp_incrementValue);
        game.fragen.gameSettings.setIncrementRange(temp_incrementRange);
        game.fragen.gameSettings.getCheats().setInfJoker(temp_cheats_infJoker);
        game.fragen.gameSettings.getCheats().setInfTime(temp_cheats_infTime);
        game.fragen.gameSettings.getCheats().setInfLife(temp_cheats_infLife);
        game.fragen.gameSettings.getCheats().setAlwaysFiftyFifty(temp_cheats_alwaysFiftyFifty);
        game.fragen.gameSettings.getCheats().setAlwaysCall(temp_cheats_alwaysCall);
        GameSettings s1 = new GameSettings();
        s1.getJoker().setRevive(false);
        s1.getJoker().setAudience(true);
        s1.getJoker().setFifty_fifty(true);
        s1.getJoker().setCall(true);
        restartJokerImages();
        GameSettings s2 = new GameSettings();
        s2.getJoker().setRevive(false);
        s2.getJoker().setAudience(true);
        s2.getJoker().setFifty_fifty(true);
        s2.getJoker().setCall(true);
        multiplayer.setPlayer1Settings(s1);
        multiplayer.setPlayer2Settings(s2);
        multiplayer.setfIndex1(0);
        multiplayer.setfIndex2(0);
        game.fragen.generateQuestions();
        game.fragen.gameSettings.setCurrency(temp_currency);
        stopSound();
        playSound("/de/hebk/Sounds/Musik/100-1000-Questions.mp3");
        if (autoConfirm.isSelected()){
            game.fragen.gameSettings.setAutoConfirm(true);
        }
    }

    public void setSoundOnProgress_Win(){
        if (VALUES[game.index_frage] == null){
            return;
        }
        int value = Integer.parseInt(s[game.index_frage]);
        System.out.println(value);

        if (value < 4000){
            playSound("/de/hebk/Sounds/Win/2000-Win.mp3");
        }

        if (value > 4000 && value <= 8000){
            wait_win = 4;
            playSound("/de/hebk/Sounds/Win/8000-Win.mp3");
        }

        if (value > 8000 && value <= 32000){
            wait_idle = 5;
            wait_win = 8;
            playSound("/de/hebk/Sounds/Win/32000-Win.mp3");
        }

        if (value > 32000 && value <= 250000){
            wait_idle = 4;
            wait_win = 6;
            playSound("/de/hebk/Sounds/Win/250000-Win.mp3");
        }

        if (value > 250000 && value <= 500000){
            wait_idle = 4;
            wait_lose = 5;
            playSound("/de/hebk/Sounds/Win/500000-Win.mp3");
        }

        if (value > 500000 && value <= 1000000){
            wait_idle = 10;
            wait_win = 26;
            wait_lose = 7;
            playSound("/de/hebk/Sounds/Win/1000000-Win.mp3");
        }
    }

    public void setSoundOnProgress_Lose(){
        if (VALUES[game.index_frage] == null){
            return;
        }
        int value = Integer.parseInt(s[game.index_frage]);
        System.out.println(value);

        if (value < 4000){
            playSound("/de/hebk/Sounds/Loose/2000-Lose.mp3");
        }

        if (value > 4000 && value <= 8000){
            wait_win = 4;
            playSound("/de/hebk/Sounds/Loose/8000-Lose.mp3");
        }

        if (value > 8000 && value <= 32000){
            wait_idle = 5;
            wait_win = 8;
            playSound("/de/hebk/Sounds/Loose/32000-Lose.mp3");
        }

        if (value > 32000 && value <= 250000){
            wait_idle = 4;
            wait_win = 6;
            playSound("/de/hebk/Sounds/Loose/250000-Lose.mp3");
        }

        if (value > 250000 && value <= 500000){
            wait_idle = 4;
            wait_lose = 5;
            playSound("/de/hebk/Sounds/Loose/500000-Lose.mp3");
        }

        if (value > 500000 && value <= 1000000){
            wait_idle = 10;
            wait_win = 26;
            wait_lose = 7;
            playSound("/de/hebk/Sounds/Loose/1000000-Lose.mp3");
        }
    }

    public void setQuestionAndAnswers() throws Exception{
        if (game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal") && game.index_frage != 0){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                multiplayer.setCurrentPlayer(multiPlayer_Player2);
                multiplayer.setfIndex1(multiplayer.getfIndex1() + 1);
            } else {
                multiplayer.setCurrentPlayer(multiPlayer_Player1);
                multiplayer.setfIndex2(multiplayer.getfIndex2() + 1);
            }
        }
        resetObjects();

        if (timer != null){
            timer.cancel();
        }

        if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            if (VALUES[game.index_frage] == null){
                System.out.println("Player Won");
                reward(local_User,"Millionär");
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
        } else{
            if (VALUES[multiplayer.getfIndex2()] == null){
                endGame();
                return;
            }
        }


        if (!game.fragen.gameSettings.getCheats().isInfTime()){
            counter();
        }

        if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            if (game.index_frage != 0){
                VALUES[game.index_frage - 1].setStyle("-fx-fill: white");
            }
            VALUES[game.index_frage].setStyle("-fx-fill: #ff8c00");
        } else{
            if (game.index_frage != 0){
                if (multiplayer.getfIndex1() != 0){
                    VALUES[multiplayer.getfIndex1() - 1].setStyle("-fx-fill: white");
                }
                if (multiplayer.getfIndex2() != 0){
                    VALUES2[multiplayer.getfIndex2() - 1].setStyle("-fx-fill: white");
                }
            }
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                VALUES[multiplayer.getfIndex1()].setStyle("-fx-fill: #ff8c00");
            } else{
                VALUES2[multiplayer.getfIndex2()].setStyle("-fx-fill: #ff8c00");
            }
        }


        if (game.index_frage >= game.fragen.gameSettings.getQuestion_Amount()){
            return;
        }

        List<String> options = null;

        int current = getCurrentQuestion();
        options = game.fragen.getQuestions().get(current).getContext().getOptions();
        questionBox.setText(game.fragen.getQuestions().get(current).getContext().getQuestion());


        int x;
        x = (int) (Math.random() * options.size());
        answer_text1.setText(options.get(x).getContext());

        x = (int) (Math.random() * options.size());
        answer_text2.setText(options.get(x).getContext());

        while (answer_text1.getText().equals(answer_text2.getText())){
            x = (int) (Math.random() * options.size());
            answer_text2.setText(options.get(x).getContext());
        }

        x = (int) (Math.random() * options.size());
        answer_text3.setText(options.get(x).getContext());

        while (answer_text1.getText().equals(answer_text2.getText()) || answer_text1.getText().equals(answer_text3.getText()) || answer_text2.getText().equals(answer_text3.getText())){
            x = (int) (Math.random() * options.size());
            answer_text3.setText(options.get(x).getContext());
        }

        x = (int) (Math.random() * options.size());
        answer_text4.setText(options.get(x).getContext());

        while (answer_text1.getText().equals(answer_text2.getText()) || answer_text1.getText().equals(answer_text3.getText()) || answer_text1.getText().equals(answer_text4.getText()) || answer_text2.getText().equals(answer_text3.getText()) || answer_text2.getText().equals(answer_text4.getText()) || answer_text3.getText().equals(answer_text4.getText())){
            x = (int) (Math.random() * options.size());
            answer_text4.setText(options.get(x).getContext());
        }

        if (options.find("Keine von genannten")){
            String s = answer_text4.getText();

            if (s.equals("Keine von genannten")){
                return;
            }

            if (answer_text1.getText().equals("Keine von genannten")){
                answer_text1.setText(s);
                answer_text4.setText("Keine von genannten");
                return;
            }

            if (answer_text2.getText().equals("Keine von genannten")){
                answer_text2.setText(s);
                answer_text4.setText("Keine von genannten");
                return;
            }

            if (answer_text3.getText().equals("Keine von genannten")){
                answer_text3.setText(s);
                answer_text4.setText("Keine von genannten");
            }
        }
        if (game.fragen.gameSettings.getCheats().isAlwaysFiftyFifty()){
            useJoker_fifty_fifty(null);
        }
        if (game.fragen.gameSettings.getCheats().isAlwaysAudiece()){
            audienceJoker_Chart.getData().clear();
            audienceJoker_Chart.layout();
            useJoker_Audience(null);
        }
    }

    private void disableObjects() {
        answer_rectangle1.setDisable(true);
        answer_rectangle2.setDisable(true);
        answer_rectangle3.setDisable(true);
        answer_rectangle4.setDisable(true);
        answer_text1.setDisable(true);
        answer_text2.setDisable(true);
        answer_text3.setDisable(true);
        answer_text4.setDisable(true);
        if (joker_fifty_fifty != null){
            joker_fifty_fifty.setDisable(true);
        }
        if (joker_fifty_fiftyP1 != null){
            joker_fifty_fiftyP1.setDisable(true);
        }
        if (joker_fifty_fiftyP2 != null){
            joker_fifty_fiftyP2.setDisable(true);
        }
    }

    private void resetObjects() {
        hide_Confirm_Box();
        changeVisibility_audienceJoker(false);
        answer_rectangle1.setStyle("");
        answer_rectangle2.setStyle("");
        answer_rectangle3.setStyle("");
        answer_rectangle4.setStyle("");
        answer_rectangle1.setDisable(false);
        answer_rectangle2.setDisable(false);
        answer_rectangle3.setDisable(false);
        answer_rectangle4.setDisable(false);
        answer_rectangle1.setOpacity(1);
        answer_rectangle2.setOpacity(1);
        answer_rectangle3.setOpacity(1);
        answer_rectangle4.setOpacity(1);
        answer_text1.setDisable(false);
        answer_text2.setDisable(false);
        answer_text3.setDisable(false);
        answer_text4.setDisable(false);
        answer_text1.setOpacity(1);
        answer_text2.setOpacity(1);
        answer_text3.setOpacity(1);
        answer_text4.setOpacity(1);
        if (joker_fifty_fifty != null){
            joker_fifty_fifty.setDisable(false);
        }
        if (joker_fifty_fiftyP1 != null){
            joker_fifty_fiftyP1.setDisable(false);
        }
        if (joker_fifty_fiftyP2 != null){
            joker_fifty_fiftyP2.setDisable(false);
        }
    }

    public void animateObjects(Rectangle b, String t){
        if (t.equals("Normal")){
            b.setStyle("-fx-fill: rgb(73,82,157)");
        }

        if (t.equals("Trigger")){
            b.setStyle("-fx-fill: rgb(255,140,0)");
        }

        if (t.equals("Answer")){
            b.setStyle("-fx-fill: rgb(0,255,140)");
        }

        if (t.equals("Wrong")){
            b.setStyle("-fx-fill: rgb(255,0,40)");
        }
    }

    public Rectangle getCorrectAnswerFromRectangels(){
        String answer = null;
        if (game.fragen.gameSettings.getGameMode().equals("Normal") || game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            answer = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions().get(0).getContext();
        }

        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            answer = game.fragen.getQuestions().get(game.fragen.gameSettings.getQuestion_Amount() - 1 -  game.index_frage).getContext().getOptions().get(0).getContext();
        }

        Rectangle rectangle = null;

        if (answer_text1.getText().equals(answer)){
            rectangle = answer_rectangle1;
        }

        if (answer_text2.getText().equals(answer)){
            rectangle = answer_rectangle2;
        }

        if (answer_text3.getText().equals(answer)){
            rectangle = answer_rectangle3;
        }

        if (answer_text4.getText().equals(answer)){
            rectangle = answer_rectangle4;
        }

        return rectangle;
    }

    public Rectangle getRectangleFromTexts(String s){
        System.out.println(s + " s");
        Rectangle r = null;
        System.out.println(answer_text1.getText());
        System.out.println(s);
        if (answer_text1.getText().equals(s)){
            r = answer_rectangle1;
            return r;
        }

        if (answer_text2.getText().equals(s)){
            r = answer_rectangle2;
            return r;
        }

        if (answer_text3.getText().equals(s)){
            r = answer_rectangle3;
            return r;
        }

        if (answer_text4.getText().equals(s)){
            r = answer_rectangle4;
            return r;
        }
        return r;
    }

    public Text getCorrectAnswerFromTexts(){
        String answer = null;
        if (game.fragen.gameSettings.getGameMode().equals("Normal") || game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            answer = game.fragen.getQuestions().get(game.index_frage).getContext().getOptions().get(0).getContext();
        }

        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            answer = game.fragen.getQuestions().get(game.fragen.gameSettings.getQuestion_Amount() - 1 -  game.index_frage).getContext().getOptions().get(0).getContext();
        }

        Text text = null;

        if (answer_text1.getText().equals(answer)){
            text = answer_text1;
        }

        if (answer_text2.getText().equals(answer)){
            text = answer_text2;
        }

        if (answer_text3.getText().equals(answer)){
            text = answer_text3;
        }

        if (answer_text4.getText().equals(answer)){
            text = answer_text4;
        }

        return text;
    }

    public void endGame() throws Exception {
        timer.cancel();
        if (result_Box.isVisible()){
            hide_Confirm_Box();
        }
        if (audienceJoker_Background.isVisible()){
            changeVisibility_audienceJoker(false);
        }

        if (game.fragen.gameSettings.getGameMode().equals("Normal")){
            local_User.setPoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
            local_User.setPlayed(local_User.getPlayed() + 1);
            local_User.setLost(local_User.getLost() + 1);
            if (game.fragen.getQuestions().get(game.index_frage).getContext().getDifficulty() < 20){
                reward(local_User,"Jonas");
            }
        }
        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            local_User.setReversePoints(local_User.getPoints() + game.fragen.gameSettings.getReward());
            local_User.setPlayed_Reverse(local_User.getPlayed_Reverse() + 1);
            local_User.setLost_Reverse(local_User.getLost_Reverse() + 1);
            if (game.fragen.getQuestions().get(game.index_frage).getContext().getDifficulty() < 20){
                reward(local_User,"Jonas");
            }
        }

        returnToMenu.setVisible(true);
        replay_Button.setVisible(true);
        loader_Game_Normal2.setOpacity(0.65);
        loader_Game_Normal2.setVisible(true);

        if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            youLostText.setVisible(true);
            pointsText.setText("PUNKTE: " + game.fragen.gameSettings.getReward());
            pointsText.setVisible(true);
            revive_Button.setVisible(true);
            if (game.fragen.gameSettings.getJoker().isRevive()){
                revive_Button.setDisable(false);
                revive_Warning_Text.setVisible(true);
            } else{
                revive_Button.setDisable(true);
                revive_Warning_Text.setVisible(false);
            }
        } else {
            if (multiplayer.getPlayer1Settings().getReward() == multiplayer.getPlayer2Settings().getReward()){
                multiplayer_WinnerImage.setVisible(true);
                multiplayer_WinnerName.setVisible(true);
                multiplayer_GameResults_Winner.setVisible(true);
                multiplayer_GameResults_RunnerUp.setVisible(true);
                FileInputStream inputStream = new FileInputStream("src/main/resources/de/hebk/Images/scale.png");
                Image image = new Image(inputStream);
                multiplayer_WinnerImage.setImage(image);
                multiplayer_WinnerName.setText("UNENTSCHIEDEN");
                String m = multiplayer.getPlayer1().getName() + " hatte " + multiplayer.getPlayer1Settings().getReward() + " Punkte mit " + multiplayer.getfIndex1() + 1 + " Fragen";
                multiplayer_GameResults_Winner.setText(m.toUpperCase());
                m = multiplayer.getPlayer2().getName() + " hatte " + multiplayer.getPlayer2Settings().getReward() + " Punkte mit " + multiplayer.getfIndex1() + 1 + " Fragen";
                multiplayer_GameResults_RunnerUp.setText(m.toUpperCase());
                return;
            }
            if (multiplayer.getPlayer1Settings().getReward() != multiplayer.getPlayer2Settings().getReward()){
                multiplayer_Crown.setVisible(true);
                multiplayer_WinnerImage.setVisible(true);
                multiplayer_WinnerName.setVisible(true);
                multiplayer_GameResults_Winner.setVisible(true);
                multiplayer_GameResults_RunnerUp.setVisible(true);
            }
            if (multiplayer.getPlayer1Settings().getReward() > multiplayer.getPlayer2Settings().getReward()){
                FileInputStream inputStream = new FileInputStream(multiplayer.getPlayer1().getProfilePicture());
                Image image = new Image(inputStream);
                multiplayer_WinnerImage.setImage(image);
                multiplayer_WinnerName.setText(multiplayer.getPlayer1().getName());
                String m = multiplayer.getPlayer1().getName() + " hat mit " + multiplayer.getPlayer1Settings().getReward() + " Punkten gewonnen";
                multiplayer_GameResults_Winner.setText(m.toUpperCase());
                m = multiplayer.getPlayer2().getName() + " hat mit " + multiplayer.getPlayer2Settings().getReward() + " Punkten verloren";
                multiplayer_GameResults_RunnerUp.setText(m.toUpperCase());
                reward(multiplayer.getPlayer1(), "Millionär");
            } else{
                FileInputStream inputStream = new FileInputStream(multiplayer.getPlayer2().getProfilePicture());
                Image image = new Image(inputStream);
                multiplayer_WinnerImage.setImage(image);
                multiplayer_WinnerName.setText(multiplayer.getPlayer2().getName());
                String m = multiplayer.getPlayer2().getName() + " hat mit " + multiplayer.getPlayer2Settings().getReward() + " Punkten gewonnen";
                multiplayer_GameResults_Winner.setText(m.toUpperCase());
                m = multiplayer.getPlayer1().getName() + " hat mit " + multiplayer.getPlayer1Settings().getReward() + " Punkten verloren";
                multiplayer_GameResults_RunnerUp.setText(m.toUpperCase());
                reward(multiplayer.getPlayer2(), "Millionär");
            }
        }
    }

    public void walkAway() throws Exception {
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
        if (multiplayer != null){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                if (multiplayer.getPlayer2Settings().getReward() <= multiplayer.getPlayer1Settings().getReward()){
                    multiplayer.getPlayer2Settings().setReward(multiplayer.getPlayer1Settings().getReward() + 1);
                }
            } else{
                if (multiplayer.getPlayer1Settings().getReward() <= multiplayer.getPlayer2Settings().getReward()){
                    multiplayer.getPlayer1Settings().setReward(multiplayer.getPlayer2Settings().getReward() + 1);
                }
            }
        }
        resetStreak();
        endGame();
    }

    public void hideEndGame(){
        if (youLostText != null){
            youLostText.setVisible(false);
            revive_Button.setVisible(false);
            revive_Warning_Text.setVisible(false);
        }
        pointsText.setVisible(false);
        returnToMenu.setVisible(false);
        replay_Button.setVisible(false);
        loader_Game_Normal2.setOpacity(1);
        loader_Game_Normal2.setVisible(false);
        if (multiplayer_Crown != null){
            multiplayer_Crown.setVisible(false);
            multiplayer_WinnerImage.setVisible(false);
            multiplayer_WinnerName.setVisible(false);
            multiplayer_GameResults_Winner.setVisible(false);
            multiplayer_GameResults_RunnerUp.setVisible(false);
        }
    }


    public void resetValues(){
        for (int i = 1; i < VALUES.length; i++){
            if (VALUES[i - 1] == null){
                break;
            }
            VALUES[i - 1].setStyle("-fx-fill: white");
            if (VALUES2[i - 1] != null){
                VALUES2[i - 1].setStyle("-fx-fill: white");
            }
        }
        VALUES[game.index_frage].setStyle("-fx-fill: #ff8c00");
    }
    public void replay() throws Exception {
        hideEndGame();
        if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            setGame();
        } else {
            setGame_Multiplayer();
        }
        setQuestionAndAnswers();
        resetValues();
        super.saveData();
    }

    public int getCurrentQuestion(){
        int index = 0;
        if (game.fragen.gameSettings.getGameMode().equals("Normal") || game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            index = game.index_frage;
        }

        if (game.fragen.gameSettings.getGameMode().equals("Reverse")){
            index = game.fragen.gameSettings.getQuestion_Amount() - 1 - game.index_frage;
        }
        return index;
    }

    public void revive() throws Exception {
        hideEndGame();
        local_User.setUsed_Joker_Revive(local_User.getUsed_Joker_Revive() + 1);
        game.fragen.gameSettings.setReward(0);
        resetObjects();
        game.fragen.gameSettings.getJoker().setRevive(game.fragen.gameSettings.getCheats().isInfJoker() ? true : false);
        if (timer != null){
            timer.cancel();
        }
        counter();
    }

    public void useJoker_fifty_fifty(MouseEvent event){
        ImageView used = null;
        if (event != null){
            used = (ImageView) event.getSource();
        }
        if (multiplayer != null){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1 && !multiplayer.getPlayer1Settings().getJoker().isFifty_fifty()){return;}
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player2 && !multiplayer.getPlayer2Settings().getJoker().isFifty_fifty()){return;}
            if (event != null){
                if (event.getSource() == joker_fifty_fiftyP1 && multiplayer.getCurrentPlayer() != multiPlayer_Player1){return;}
                if (event.getSource() == joker_fifty_fiftyP2 && multiplayer.getCurrentPlayer() != multiPlayer_Player2){return;}
            }
        } else{
            if (!game.fragen.gameSettings.getJoker().isFifty_fifty()){return;}
        }
        String firstOption;
        String secondOption;
        int current = getCurrentQuestion();
        firstOption = game.fragen.getQuestions().get(current).getContext().getOptions().get(2).getContext();
        secondOption = game.fragen.getQuestions().get(current).getContext().getOptions().get(3).getContext();

        if (answer_text1.getText().equals(firstOption) || answer_text1.getText().equals(secondOption)){
            answer_text1.setOpacity(0.5);
            answer_rectangle1.setOpacity(0.5);
            answer_text1.setDisable(true);
            answer_rectangle1.setDisable(true);
        }
        if (answer_text2.getText().equals(firstOption) || answer_text2.getText().equals(secondOption)){
            answer_text2.setOpacity(0.5);
            answer_rectangle2.setOpacity(0.5);
            answer_text2.setDisable(true);
            answer_rectangle2.setDisable(true);
        }
        if (answer_text3.getText().equals(firstOption) || answer_text3.getText().equals(secondOption)){
            answer_text3.setOpacity(0.5);
            answer_rectangle3.setOpacity(0.5);
            answer_text3.setDisable(true);
            answer_rectangle3.setDisable(true);
        }
        if (answer_text4.getText().equals(firstOption) || answer_text4.getText().equals(secondOption)){
            answer_text4.setOpacity(0.5);
            answer_rectangle4.setOpacity(0.5);
            answer_text4.setDisable(true);
            answer_rectangle4.setDisable(true);
        }
        User u;
        game.fragen.gameSettings.getJoker().setFifty_fifty(game.fragen.gameSettings.getCheats().isInfJoker() ? true : false);
        if (multiplayer != null){
            if (!game.fragen.gameSettings.getJoker().isFifty_fifty()){
                if (used != null){
                    used.setOpacity(0.5);
                }
                if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                    multiplayer.getPlayer1().setUsed_Joker_FiftyFifty(multiplayer.getPlayer1().getUsed_Joker_FiftyFifty() + 1);
                    u = multiplayer.getPlayer1();
                }
                if (multiplayer.getCurrentPlayer() == multiPlayer_Player2){
                    multiplayer.getPlayer1().setUsed_Joker_FiftyFifty(multiplayer.getPlayer2().getUsed_Joker_FiftyFifty() + 1);
                    u = multiplayer.getPlayer2();
                }
            }
        } else{
            u = local_User;
            local_User.setUsed_Joker_FiftyFifty(local_User.getUsed_Joker_FiftyFifty() + 1);
            if (!game.fragen.gameSettings.getJoker().isFifty_fifty()){
                joker_fifty_fifty.setOpacity(0.5);
                if (check_AllJokerUsed(u)){
                    reward(u, "Joker-Master");
                }
            }
        }
    }

    public void hideAudienceChart(){
        changeVisibility_audienceJoker(false);
    }

    public void useJoker_Audience(MouseEvent event){
        ImageView used = null;
        if (event != null){
            used = (ImageView) event.getSource();
        }
        if (multiplayer != null){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1 && !multiplayer.getPlayer1Settings().getJoker().isAudience()){return;}
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player2 && !multiplayer.getPlayer2Settings().getJoker().isAudience()){return;}
            if (event != null){
                if (event.getSource() == joker_audienceP1 && multiplayer.getCurrentPlayer() != multiPlayer_Player1){return;}
                if (event.getSource() == joker_audienceP2 && multiplayer.getCurrentPlayer() != multiPlayer_Player2){return;}
            }
        } else{
            if (!game.fragen.gameSettings.getJoker().isAudience()){return;}
        }
        audienceJoker_Chart.getData().clear();
        audienceJoker_Chart.layout();
        changeVisibility_audienceJoker(true);
        int current = getCurrentQuestion();
        int startValue = 100 - game.fragen.getQuestions().get(current).getContext().getDifficulty();
        if (startValue > 20){
            startValue = 20;
        }
        int remaining = 100 - startValue;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        if (answer_text1.getText().equals(game.fragen.getQuestions().get(current).getContext().getOptions().get(0).getContext())){
            c1 = startValue;
        }

        if (answer_text2.getText().equals(game.fragen.getQuestions().get(current).getContext().getOptions().get(0).getContext())){
            c2 = startValue;
        }

        if (answer_text3.getText().equals(game.fragen.getQuestions().get(current).getContext().getOptions().get(0).getContext())){
            c3 = startValue;
        }

        if (answer_text4.getText().equals(game.fragen.getQuestions().get(current).getContext().getOptions().get(0).getContext())){
            c4 = startValue;
        }

        while (remaining > 0){
            int x = (int) (Math.random() * 4);

            if (x == 0){
                c1++;
                remaining--;
            }
            if (x == 1){
                c2++;
                remaining--;
            }
            if (x == 2){
                c3++;
                remaining--;
            }
            if (x == 3){
                c4++;
                remaining--;
            }
        }
        XYChart.Series<String, Integer> series = new XYChart.Series();
        series.getData().add(new XYChart.Data<>("", c1));
        series.setName("1");

        XYChart.Series<String, Integer> series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data<>("", c2));
        series2.setName("2");

        XYChart.Series<String, Integer> series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data<>("", c3));
        series3.setName("3");

        XYChart.Series<String, Integer> series4 = new XYChart.Series();
        series4.getData().add(new XYChart.Data<>("", c4));
        series4.setName("4");

        audienceJoker_Chart.getData().addAll(series);
        audienceJoker_Chart.getData().addAll(series2);
        audienceJoker_Chart.getData().addAll(series3);
        audienceJoker_Chart.getData().addAll(series4);

        User u;
        game.fragen.gameSettings.getJoker().setAudience(game.fragen.gameSettings.getCheats().isInfJoker() ? true : false);
        if (multiplayer != null){
            if (!game.fragen.gameSettings.getJoker().isAudience()){
                if (used != null){
                    used.setOpacity(0.5);
                }
                if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                    multiplayer.getPlayer1().setUsed_Joker_Audience(multiplayer.getPlayer1().getUsed_Joker_Audience() + 1);
                    u = multiplayer.getPlayer1();
                }
                if (multiplayer.getCurrentPlayer() == multiPlayer_Player2){
                    multiplayer.getPlayer1().setUsed_Joker_Audience(multiplayer.getPlayer2().getUsed_Joker_Audience() + 1);
                    u = multiplayer.getPlayer2();
                }
            }
        } else{
            u = local_User;
            local_User.setUsed_Joker_Audience(local_User.getUsed_Joker_Audience() + 1);
            if (check_AllJokerUsed(u)){
                reward(u, "Joker-Master");
            }
            if (!game.fragen.gameSettings.getJoker().isAudience()){
                joker_audience.setOpacity(0.5);
            }
        }
    }

    public void changeVisibility_audienceJoker(boolean v){
        audienceJoker_Background.setVisible(v);
        audienceJoker_Chart.setVisible(v);
        result_audienceJoker_Box.setVisible(v);
        result_audienceJoker_Option.setVisible(v);
    }
    public void hideCallJoker(){
        changeVisibility_CallJoker(false);
    }

    public void useJoker_Call(MouseEvent event){
        ImageView used = null;
        if (event != null){
            used = (ImageView) event.getSource();
        }
        if (multiplayer != null){
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1 && !multiplayer.getPlayer1Settings().getJoker().isCall()){return;}
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player2 && !multiplayer.getPlayer2Settings().getJoker().isCall()){return;}
            if (event != null){
                if (event.getSource() == joker_callP1 && multiplayer.getCurrentPlayer() != multiPlayer_Player1){return;}
                if (event.getSource() == joker_callP2 && multiplayer.getCurrentPlayer() != multiPlayer_Player2){return;}
            }
        } else{
            if (!game.fragen.gameSettings.getJoker().isCall()){return;}
        }

        int chance_correct = 70;
        int change_wrong = 100 - chance_correct;

        int generated = (int) (Math.random() * 100);
        int current = getCurrentQuestion();
        if (generated <= 70){
            result_Box_Call_Description.setText("Dein Freund sagt, dass " + game.fragen.getQuestions().get(current).getContext().getOptions().get(0).getContext() +  " richtig ist");
        } else {
            generated = (int) (Math.random() * 2);
            result_Box_Call_Description.setText("Dein Freund sagt, dass " + game.fragen.getQuestions().get(current).getContext().getOptions().get(generated + 1).getContext() +  " richtig ist");
        }

        changeVisibility_CallJoker(true);

        User u;
        game.fragen.gameSettings.getJoker().setCall(game.fragen.gameSettings.getCheats().isInfJoker() ? true : false);
        if (multiplayer != null){
            if (!game.fragen.gameSettings.getJoker().isCall()){
                if (used != null){
                    used.setOpacity(0.5);
                }
                if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                    multiplayer.getPlayer1().setUsed_Joker_Call(multiplayer.getPlayer1().getUsed_Joker_Call() + 1);
                    u = multiplayer.getPlayer1();
                }
                if (multiplayer.getCurrentPlayer() == multiPlayer_Player2){
                    multiplayer.getPlayer1().setUsed_Joker_Call(multiplayer.getPlayer2().getUsed_Joker_Call() + 1);
                    u = multiplayer.getPlayer2();
                }
            }
        } else{
            u = local_User;
            local_User.setUsed_Joker_Call(local_User.getUsed_Joker_Call() + 1);
            if (!game.fragen.gameSettings.getJoker().isCall()){
                joker_call.setOpacity(0.5);
                if (check_AllJokerUsed(u)){
                    reward(u, "Joker-Master");
                }
            }
        }
    }

    public void changeVisibility_CallJoker(boolean v){
        result_Box_Call.setVisible(v);
        result_Box_Call_Description.setVisible(v);
        result_Option1_Box_Call.setVisible(v);
        result_Option1_Call.setVisible(v);
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
        setSoundOnProgress_Win();
        hide_Confirm_Box();
        result_Box.setVisible(true);
        result_Title.setVisible(true);
        result_Answer.setVisible(true);
        result_Confirm.setText("PUNKTE: " + game.fragen.gameSettings.getReward());
        result_Confirm.setVisible(true);
        if (result_Option3 != null){
            result_Option3_Box.setVisible(true);
            result_Option3.setVisible(true);
        }
        if (result_Option4 != null){
            result_Option4_Box.setVisible(true);
            result_Option4.setVisible(true);
        }
    }

    public void showAchievements() throws Exception{
        loadScene("Achievements.fxml");
    }
    public void loadAchievements() throws Exception {
        loader_Achievements.setVisible(false);
        setUser_Achievements_Chart();
        FileInputStream inputStream = new FileInputStream(local_User.getProfilePicture());
        Image image = new Image(inputStream);
        achievements_ProfileImage.setImage(image);
        achievements_Username.setText(local_User.getName());
        double currentTransparency = local_User.getAchievements().find("Du hast einen langen Weg vor dir") ? 1 : 0.5;
        achievement1.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Kein Defizit") ? 1 : 0.5;
        achievement2.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Genie") ? 1 : 0.5;
        achievement3.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Ein Stein") ? 1 : 0.5;
        achievement4.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Jonas") ? 1 : 0.5;
        achievement5.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Muss Mutti wieder helfen?") ? 1 : 0.5;
        achievement6.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Siri wirf ne Münze") ? 1 : 0.5;
        achievement7.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Du vertraust den?") ? 1 : 0.5;
        achievement8.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Joker-Master") ? 1 : 0.5;
        achievement9.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Hacker") ? 1 : 0.5;
        achievement10.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Indischer Kundensupport") ? 1 : 0.5;
        achievement11.setOpacity(currentTransparency);
        currentTransparency = local_User.getAchievements().find("Millionär") ? 1 : 0.5;
        achievement12.setOpacity(currentTransparency);
    }
    public void loadAccountInformation() throws Exception{
        loader_AccountInformation.setVisible(false);
        FileInputStream inputStream = new FileInputStream(local_User.getProfilePicture());
        Image image = new Image(inputStream);
        image_AccountInformation.setImage(image);

    }
    public void loadCheats(){
        loader_Cheats.setVisible(false);
        if (temp_cheats_infJoker){
            cheat1.setSelected(true);
        }
        if (temp_cheats_infTime){
            cheat2.setSelected(true);
        }
        if (temp_cheats_infLife){
            cheat3.setSelected(true);
        }
        if (temp_cheats_alwaysFiftyFifty){
            cheat4.setSelected(true);
        }
        if (temp_cheats_alwaysCall){
            cheat5.setSelected(true);
        }
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
        //resetObjects();
    }

    public void continueGame() throws Exception {
        //stopSound();
        hide_Confirm_Box();
        Rectangle r = getCorrectAnswerFromRectangels();
        game.index_frage++;
        setQuestionAndAnswers();
        animateObjects(r, "Normal");
        r.setStyle("");
        playBackgroundSound();
    }

    public Rectangle animateResult() throws Exception{
        Rectangle b = getCorrectAnswerFromRectangels();
        timer.cancel();
        animateObjects(b, "Answer");
        return b;
    }

    public void answer() throws Exception {
        hide_Confirm_Box();
        Text t = getCorrectAnswerFromTexts();
        Rectangle r = getCorrectAnswerFromRectangels();
        if (!t.getText().equals(result_Answer.getText())){
            Rectangle r2 = null;
            if (answer_text1.getText().equals(result_Answer.getText())){
                r2 = answer_rectangle1;
            }
            if (answer_text2.getText().equals(result_Answer.getText())){
                r2 = answer_rectangle2;
            }
            if (answer_text3.getText().equals(result_Answer.getText())){
                r2 = answer_rectangle3;
            }
            if (answer_text4.getText().equals(result_Answer.getText())){
                r2 = answer_rectangle4;
            }
            if (!game.fragen.gameSettings.getCheats().isInfLife()){
                if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
                    resetStreak();
                    endGame();
                    animateObjects(r, "Answer");
                    animateObjects(r2, "Wrong");
                    return;
                } else {
                    continueGame();
                }
            } else{
                continueGame();
            }
        }

        if (super.checkAnswer(game.fragen, questionBox.getText(), result_Answer.getText())){
            changeStreak();
            changeReward();
            confirm2();
        }
        r.setStyle("");
    }

    public void changeGameAutoConfirm(){
        game.fragen.gameSettings.setAutoConfirm(autoConfirm.isSelected());
    }
    public void getAnswer1() throws Exception{
        answerFunction(answer_text1);
    }

    public void getAnswer2() throws Exception{
        answerFunction(answer_text2);
    }

    public void getAnswer3() throws Exception{
        answerFunction(answer_text3);
    }

    public void getAnswer4() throws Exception{
        answerFunction(answer_text4);
    }

    public boolean answerResult_DisabledAutoAnswer(Text t) throws Exception{
        Text t2 = getCorrectAnswerFromTexts();
        boolean v = false;
        if (!t.getText().equals(t2.getText())){
            v = false;
        }
        if (super.checkAnswer(game.fragen, questionBox.getText(), t.getText())){
            v = true;
        }
        return v;
    }

    public void answerFunction(Text t) throws Exception {
        //disableObjects();
        if (!game.fragen.gameSettings.isAutoConfirm()){
            t.setStyle("");
            result_Answer.setText(t.getText());
            confirm();
        } else {
            System.out.println("Else answer");
            disableObjects();
            counter_answer(t);
        }
        t.setStyle("");
    }

    public void changeReward(){
        int current = getCurrentQuestion();
        if (!game.fragen.gameSettings.getGameMode().equals("Multiplayer - Normal")){
            game.fragen.gameSettings.setReward(game.fragen.gameSettings.getReward() + game.fragen.getQuestions().get(current).getContext().getDifficulty());
        } else{
            if (multiplayer.getCurrentPlayer() == multiPlayer_Player1){
                multiplayer.getPlayer1Settings().setReward(multiplayer.getPlayer1Settings().getReward() + game.fragen.getQuestions().get(current).getContext().getDifficulty());
            } else{
                multiplayer.getPlayer2Settings().setReward(multiplayer.getPlayer2Settings().getReward() + game.fragen.getQuestions().get(current).getContext().getDifficulty());
            }
            multiplayer_Player1Points.setText("PUNKTE: " + multiplayer.getPlayer1Settings().getReward());
            multiplayer_Player2Points.setText("PUNKTE: " + multiplayer.getPlayer2Settings().getReward());
        }
    }


    public void showTopPlayersMenu() throws Exception{
        loadScene("TopPlayersMenu.fxml");
    }

    public void showCheats() throws Exception{
        loadScene("Cheats.fxml");
    }
    public void showDescriptions() throws Exception{
        loadScene("Descriptions.fxml");
    }

    public void showDescription_Games() throws Exception{
        loadScene("Description_Games.fxml");
    }

    public void showDescription_Cheats() throws Exception{
        loadScene("Description_Cheats.fxml");
    }

    public void showDescription_Joker() throws Exception{
        loadScene("Description_Joker.fxml");
    }

    public void showDescription_TopPlayers() throws Exception{
        loadScene("Description_TopPlayers.fxml");
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

    public void playSound(String filename){
        try {
            stopSound();
            String path = getClass().getResource(filename).toURI().toString();
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void playVideo(String filename){
        try {
            String path = getClass().getResource(filename).toURI().toString();
            Media media = new Media(path);
            mediaPlayer_Video.setAutoPlay(true);
            mediaView.setMediaPlayer(mediaPlayer_Video);
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void playBackgroundSound(){
        if (VALUES[game.index_frage] == null){
            return;
        }
        int value = Integer.parseInt(s[game.index_frage]);

        if (value <= 1000){
            playSound("/de/hebk/Sounds/Musik/100-1000-Questions.mp3");
        }

        if (value >= 2000 && value <= 4000){
            playSound("/de/hebk/Sounds/Musik/2000-Question.mp3");
        }

        if (value >= 4000 && value <= 8000){
            playSound("/de/hebk/Sounds/Musik/4000-Question.mp3");
        }

        if (value >= 8000 && value <= 16000){
            playSound("/de/hebk/Sounds/Musik/8000-Question.mp3");
        }

        if (value >= 16000 && value <= 32000){
            playSound("/de/hebk/Sounds/Musik/16000-Question.mp3");
        }

        if (value >= 32000 && value <= 64000){
            playSound("/de/hebk/Sounds/Musik/32000-Question.mp3");
        }

        if (value >= 64000 && value <= 125000){
            playSound("/de/hebk/Sounds/Musik/64000-Question.mp3");
        }

        if (value >= 125000 && value <= 250000){
            playSound("/de/hebk/Sounds/Musik/125000-Question.mp3");
        }

        if (value >= 250000 && value <= 500000){
            playSound("/de/hebk/Sounds/Musik/250000-Question.mp3");
        }

        if (value >= 500000 && value <= 1000000){
            playSound("/de/hebk/Sounds/Musik/500000-Question.mp3");
        }

        if (value >= 1000000){
            playSound("/de/hebk/Sounds/Musik/1000000-Question.mp3");
        }
    }

    public void stopSound(){
        try {
            if (mediaPlayer != null){
                mediaPlayer.stop();
            }
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void setTop10(String method) throws FileNotFoundException {
        Stack<User> top10 = null;

        top10 = (method.equals("Normal") == true ? calculateTopPlayers("Normal") : calculateTopPlayers("Reverse"));
        System.out.println(top10.toString());

        int x = 0;

        try {
            boolean t = (top10.get(x).getContext() == null ? true : false);
            System.out.println(top10.get(x).getContext().getName());
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
                player_Top1.setText(top10.get(x).getContext().getName());
                if (method.equals("Normal")){
                    played_Top1.setText("" + top10.get(x).getContext().getPlayed());
                    won_Top1.setText("" + top10.get(x).getContext().getWon());
                    points_Top1.setText("" + top10.get(x).getContext().getPoints());
                }
                if (method.equals("Reverse")){
                    played_Top1.setText("" + top10.get(x).getContext().getPlayed_Reverse());
                    won_Top1.setText("" + top10.get(x).getContext().getWon_Reverse());
                    points_Top1.setText("" + top10.get(x).getContext().getReversePoints());
                }
            }

            x = 1;
            t = (top10.get(x).getContext() == null ? true : false);
            System.out.println(top10.get(x).getContext().getName());
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
        Stack<User> topAll = calculateTopPlayers("Normal");
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
        Stack<User> topAll_Reverse = calculateTopPlayers("Reverse");
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

    public String getFavorite_Subject_local_user(){
        int[] points = new int[local_User.getFavorite_subjects().size()];
        for (int i = 0; i < local_User.getFavorite_subjects().size(); i++){
            points[i] = local_User.getFavorite_subjects().get(i).getContext();
        }

        int highest = 0;
        for (int i = 0; i < local_User.getFavorite_subjects().size(); i++){
            for (int x = 0; x < local_User.getFavorite_subjects().size(); x++){
                if (local_User.getFavorite_subjects().get(x).getContext() > highest){
                    highest = i;
                    break;
                }
            }
        }

        int index = 0;
        for (int i = 0; i < local_User.getFavorite_subjects().size(); i++){
            if (local_User.getFavorite_subjects().get(i).getContext() == highest){
                index = i;
            }
        }

        return csvFiles_Questions[index];
    }

    public void showUser_Statistics() throws Exception{
        loadScene("local_user.fxml");
    }

    public void loadUser() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(local_User.getProfilePicture());
        Image image = new Image(inputStream);
        user_Profilepicture.setImage(image);
        user_userName.setText(local_User.getName());
        user_joinedDate.setText(local_User.getJoinDate());
        userInformation_Name.setText("Name: " + local_User.getName());
        userInformation_Password.setText("Passwort: " + local_User.getPassword());

        Stack<User> topAll = calculateTopPlayers("Normal");
        for (int i = 0; i < topAll.size(); i++){
            User current = topAll.get(i).getContext();
            if (local_User.getName().equals(current.getName())){
                userRank_Normal.setText("NORMAL: " + (i + 1));
                break;
            }
            else {
                userRank_Normal.setText("NORMAL: " + topAll.size());
            }
        }

        Stack<User> topAll_Reverse = calculateTopPlayers("Reverse");
        for (int i = 0; i < topAll_Reverse.size(); i++){
            User current = topAll_Reverse.get(i).getContext();
            if (local_User.getName().equals(current.getName())){
                userRank_Reverse.setText("REVERSE: " + (i + 1));
                break;
            } else {
                userRank_Reverse.setText("REVERSE: " + topAll_Reverse.size());
            }
        }

        userPoints_Normal.setText("NORMAL: " + local_User.getPoints());
        userPoints_Reverse.setText("REVERSE: " + local_User.getReversePoints());
        user_Achievements.setText(local_User.getAchievements().size() + "/" + amount_Achievements);
        user_favoriteSubject.setText(getFavorite_Subject_local_user());

        setUser_GameResults_Chart();
        setUser_Achievements_Chart();
        setUser_Joker_Chart();
        if (local_User.getPlayed() > 0){
            percentageOfWin.setText(local_User.getWon() * 100 / local_User.getPlayed() + "%");
        } else{
            percentageOfWin.setText("/");
        }
    }

    public void setUser_GameResults_Chart() {

        user_GameResults_Chart.getData().clear();
        user_GameResults_Chart.layout();

        if (user_GameResults_Chart_switch.getText().equals("Normal")) {
            loader_User_Statistics.setVisible(false);

            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>("0", local_User.getPlayed() / 8));
            series.getData().add(new XYChart.Data<>("1", local_User.getPlayed() / 7));
            series.getData().add(new XYChart.Data<>("2", local_User.getPlayed() / 6));
            series.getData().add(new XYChart.Data<>("3", local_User.getPlayed() / 5));
            series.getData().add(new XYChart.Data<>("4", local_User.getPlayed() / 4));
            series.getData().add(new XYChart.Data<>("5", local_User.getPlayed() / 3));
            series.getData().add(new XYChart.Data<>("6", local_User.getPlayed() / 2));
            series.getData().add(new XYChart.Data<>("7", local_User.getPlayed()));
            series.setName("Gespielt");
            user_GameResults_Chart_PlayedText.setText("Normal: " + local_User.getPlayed());
            user_GameResults_Chart_PlayedText_Reverse.setText("Reverse: " + local_User.getPlayed_Reverse());

            XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
            series2.getData().add(new XYChart.Data<>("0", local_User.getWon() / 8));
            series2.getData().add(new XYChart.Data<>("1", local_User.getWon() / 7));
            series2.getData().add(new XYChart.Data<>("2", local_User.getWon() / 6));
            series2.getData().add(new XYChart.Data<>("3", local_User.getWon() / 5));
            series2.getData().add(new XYChart.Data<>("4", local_User.getWon() / 4));
            series2.getData().add(new XYChart.Data<>("5", local_User.getWon() / 3));
            series2.getData().add(new XYChart.Data<>("6", local_User.getWon() / 2));
            series2.getData().add(new XYChart.Data<>("7", local_User.getWon()));
            series2.setName("Gewonnen");
            user_GameResults_Chart_WonText.setText("Normal: " + local_User.getWon());
            user_GameResults_Chart_WonText_Reverse.setText("Reverse: " + local_User.getWon_Reverse());

            XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
            series3.getData().add(new XYChart.Data<>("0", local_User.getLost() / 8));
            series3.getData().add(new XYChart.Data<>("1", local_User.getLost() / 7));
            series3.getData().add(new XYChart.Data<>("2", local_User.getLost() / 6));
            series3.getData().add(new XYChart.Data<>("3", local_User.getLost() / 5));
            series3.getData().add(new XYChart.Data<>("4", local_User.getLost() / 4));
            series3.getData().add(new XYChart.Data<>("5", local_User.getLost() / 3));
            series3.getData().add(new XYChart.Data<>("6", local_User.getLost() / 2));
            series3.getData().add(new XYChart.Data<>("7", local_User.getLost()));
            series3.setName("Verloren");
            user_GameResults_Chart_LostText.setText("Normal: " + local_User.getLost());
            user_GameResults_Chart_LostText_Reverse.setText("Reverse: " + local_User.getLost_Reverse());

            user_GameResults_Chart.getData().add(series);
            user_GameResults_Chart.getData().add(series2);
            user_GameResults_Chart.getData().add(series3);
            series.getNode().setStyle("-fx-stroke: #FFD6DC");
            series2.getNode().setStyle("-fx-stroke: #8effd5");
            series3.getNode().setStyle("-fx-stroke: #ff8092");
            user_GameResults_Chart_switch.setText("Reverse");
        } else {
            loader_User_Statistics.setVisible(false);

            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.getData().add(new XYChart.Data<>("0", local_User.getPlayed_Reverse() / 8));
            series.getData().add(new XYChart.Data<>("1", local_User.getPlayed_Reverse() / 7));
            series.getData().add(new XYChart.Data<>("2", local_User.getPlayed_Reverse() / 6));
            series.getData().add(new XYChart.Data<>("3", local_User.getPlayed_Reverse() / 5));
            series.getData().add(new XYChart.Data<>("4", local_User.getPlayed_Reverse() / 4));
            series.getData().add(new XYChart.Data<>("5", local_User.getPlayed_Reverse() / 3));
            series.getData().add(new XYChart.Data<>("6", local_User.getPlayed_Reverse() / 2));
            series.getData().add(new XYChart.Data<>("7", local_User.getPlayed_Reverse()));
            series.setName("Gespielt-Reverse");
            user_GameResults_Chart_PlayedText.setText("Normal: " + local_User.getPlayed());
            user_GameResults_Chart_PlayedText_Reverse.setText("Reverse: " + local_User.getPlayed_Reverse());

            XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
            series2.getData().add(new XYChart.Data<>("0", local_User.getWon_Reverse() / 8));
            series2.getData().add(new XYChart.Data<>("1", local_User.getWon_Reverse() / 7));
            series2.getData().add(new XYChart.Data<>("2", local_User.getWon_Reverse() / 6));
            series2.getData().add(new XYChart.Data<>("3", local_User.getWon_Reverse() / 5));
            series2.getData().add(new XYChart.Data<>("4", local_User.getWon_Reverse() / 4));
            series2.getData().add(new XYChart.Data<>("5", local_User.getWon_Reverse() / 3));
            series2.getData().add(new XYChart.Data<>("6", local_User.getWon_Reverse() / 2));
            series2.getData().add(new XYChart.Data<>("7", local_User.getWon_Reverse()));
            series2.setName("Gewonnen-Reverse");
            user_GameResults_Chart_WonText.setText("Normal: " + local_User.getWon());
            user_GameResults_Chart_WonText_Reverse.setText("Reverse: " + local_User.getWon_Reverse());

            XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
            series3.getData().add(new XYChart.Data<>("0", local_User.getLost_Reverse() / 8));
            series3.getData().add(new XYChart.Data<>("1", local_User.getLost_Reverse() / 7));
            series3.getData().add(new XYChart.Data<>("2", local_User.getLost_Reverse() / 6));
            series3.getData().add(new XYChart.Data<>("3", local_User.getLost_Reverse() / 5));
            series3.getData().add(new XYChart.Data<>("4", local_User.getLost_Reverse() / 4));
            series3.getData().add(new XYChart.Data<>("5", local_User.getLost_Reverse() / 3));
            series3.getData().add(new XYChart.Data<>("6", local_User.getLost_Reverse() / 2));
            series3.getData().add(new XYChart.Data<>("7", local_User.getLost_Reverse()));
            series3.setName("Verloren-Reverse");
            user_GameResults_Chart_LostText.setText("Normal: " + local_User.getLost());
            user_GameResults_Chart_LostText_Reverse.setText("Reverse: " + local_User.getLost_Reverse());

            user_GameResults_Chart.getData().add(series);
            user_GameResults_Chart.getData().add(series2);
            user_GameResults_Chart.getData().add(series3);
            series.getNode().setStyle("-fx-stroke: #FFD6DC");
            series2.getNode().setStyle("-fx-stroke: #8effd5");
            series3.getNode().setStyle("-fx-stroke: #ff8092");
            user_GameResults_Chart_switch.setText("Normal");
        }
    }

    public void setUser_Achievements_Chart(){
        ObservableList<PieChart.Data> achievementsData = FXCollections.observableArrayList(
                new PieChart.Data("übrig",amount_Achievements - local_User.getAchievements().size()),
                new PieChart.Data("erzielt",local_User.getAchievements().size())
        );
        user_Achievements_Chart.setData(achievementsData);
    }

    public void setUser_Joker_Chart(){
        loader_User_Statistics.setVisible(false);

        XYChart.Series<String, Integer> series = new XYChart.Series();
        series.getData().add(new XYChart.Data<>("", local_User.getUsed_Joker_Audience()));
        series.setName("Publikum");

        XYChart.Series<String, Integer> series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data<>("", local_User.getUsed_Joker_FiftyFifty()));
        series2.setName("50%50");

        XYChart.Series<String, Integer> series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data<>("", local_User.getUsed_Joker_Call()));
        series3.setName("Telefon");

        XYChart.Series<String, Integer> series4 = new XYChart.Series();
        series4.getData().add(new XYChart.Data<>("", local_User.getUsed_Joker_Revive()));
        series4.setName("Revive");

        user_Joker_Chart.getData().addAll(series);
        user_Joker_Chart.getData().addAll(series2);
        user_Joker_Chart.getData().addAll(series3);
        user_Joker_Chart.getData().addAll(series4);
    }
    public boolean check_AllCheatsUsed(){
        boolean b = false;
        if (temp_cheats_infJoker && temp_cheats_infTime && temp_cheats_infLife && temp_cheats_alwaysCall && temp_cheats_alwaysFiftyFifty){
            b = true;
        }
        return b;
    }

    public boolean check_AllJokerUsed(User u){
        boolean b = false;
        if (u.getUsed_Joker_FiftyFifty() > 0 && u.getUsed_Joker_Audience() > 0 && u.getUsed_Joker_Call() > 0 && u.getUsed_Joker_Revive() > 0){
            b = true;
        }
        return b;
    }
    public void showChangePassword() throws Exception{
        loadScene("ChangePassword.fxml");
    }
    public void showError_ChangePassword() throws Exception{
        loadScene("Error_ChangePassword.fxml");
    }
    public void changePassword() throws Exception {
        if (!changePassword_Field1.getText().equals(local_User.getPassword())){showError_ChangePassword();}
        if (!changePassword_Field2.getText().equals(changePassword_Field3.getText())){showError_ChangePassword();}
        local_User.setPassword(changePassword_Field2.getText());
        changePassword_Field1.setText("");
        changePassword_Field2.setText("");
        changePassword_Field3.setText("");
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
            if (!temp_gameMode.equals("Multiplayer - Normal")){
                temp_FragenAnzahl = 10;
            } else {
                temp_FragenAnzahl = 20;
            }
        }
        if (event.getSource() == amount_Questions15){
            if (!temp_gameMode.equals("Multiplayer - Normal")){
                temp_FragenAnzahl = 15;
            } else {
                temp_FragenAnzahl = 30;
            }
        }
        if (event.getSource() == amount_Questions20){
            if (!temp_gameMode.equals("Multiplayer - Normal")){
                temp_FragenAnzahl = 20;
            } else {
                temp_FragenAnzahl = 40;
            }
        }
        loadScene("Game_Settings1.fxml");
    }

    public void handle_BoxColor(MouseEvent event){
        String s1 = "-fx-fill: " + firstColor;
        String s2 = "-fx-fill: " + secondColor;
        if (event.getEventType().getName().equals("MOUSE_ENTERED")){
            if (event.getSource() == answer_rectangle1 || event.getSource() == answer_text1){
                answer_rectangle1.setStyle(s2);
            }
            if (event.getSource() == answer_rectangle2 || event.getSource() == answer_text2){
                answer_rectangle2.setStyle(s2);
            }
            if (event.getSource() == answer_rectangle3 || event.getSource() == answer_text3){
                answer_rectangle3.setStyle(s2);
            }
            if (event.getSource() == answer_rectangle4 || event.getSource() == answer_text4){
                answer_rectangle4.setStyle(s2);
            }
        }

        if (event.getEventType().getName().equals("MOUSE_EXITED")){
            if (event.getSource() == answer_rectangle1 || event.getSource() == answer_text1){
                answer_rectangle1.setStyle(s1);
            }
            if (event.getSource() == answer_rectangle2 || event.getSource() == answer_text2){
                answer_rectangle2.setStyle(s1);
            }
            if (event.getSource() == answer_rectangle3 || event.getSource() == answer_text3){
                answer_rectangle3.setStyle(s1);
            }
            if (event.getSource() == answer_rectangle4 || event.getSource() == answer_text4){
                answer_rectangle4.setStyle(s1);
            }
        }
    }

    public void handle_TopMenu(MouseEvent event) throws Exception{
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

    public void handle_cheats(MouseEvent event) throws Exception{
        reward(local_User,"Hacker");
        if (event.getSource() == cheat1){
            temp_cheats_infJoker = cheat1.isSelected();
            if (!cheat1.isSelected() && cheat4.isSelected()) {
                cheat4.setSelected(false);
            }
            if (!cheat1.isSelected() && cheat5.isSelected()) {
                cheat5.setSelected(false);
            }
        }
        if (event.getSource() == cheat2){
            temp_cheats_infTime = cheat2.isSelected();
        }
        if (event.getSource() == cheat3){
            temp_cheats_infLife = cheat3.isSelected();
        }
        if (event.getSource() == cheat4){
            if (cheat4.isSelected()){
                cheat1.setSelected(true);
                temp_cheats_infJoker = cheat1.isSelected();
            }
            temp_cheats_alwaysFiftyFifty = cheat4.isSelected();
        }
        if (event.getSource() == cheat5){
            if (cheat5.isSelected()){
                cheat1.setSelected(true);
                temp_cheats_infJoker = cheat1.isSelected();
            }
            temp_cheats_alwaysCall = cheat5.isSelected();
        }
        if (check_AllCheatsUsed()){
            reward(local_User,"Indischer Kundensupport");
        }
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
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/19.PNG";
        }
        if (event.getSource() == profileImage20){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/20.PNG";
        }
        if (event.getSource() == profileImage22){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/22.PNG";
        }
        if (event.getSource() == profileImage23){
            local_Profile_Picure = "src/main/resources/de/hebk/Profilbilder/Unbenannt.PNG";
        }
        local_User.setProfilePicture(local_Profile_Picure);
        showAccountInformation();
        super.saveData();
    }
}