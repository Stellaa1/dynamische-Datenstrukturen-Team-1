package de.hebk;

import de.hebk.model.list.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {
    public static Stage mainStage;
    public static String currentScene;
    public static String previousScene;
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("GUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920,1480);
        stage.setTitle("GUI.fxml");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Fragen f = new Fragen(16,"Geschichte");
        f.generateQuestions();
        List<String> l = new List<>();
        launch();
        //SystemController s = new SystemController();
        //s.loadData();
    }
}