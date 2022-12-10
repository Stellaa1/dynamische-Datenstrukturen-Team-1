package de.hebk.model.queue;

import de.hebk.model.queue.model.list.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("GUI2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,960);
        stage.setTitle("Wer Wird Millionär");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        Fragen f = new Fragen(16,"Geschichte");
        f.generateQuestions();
        List<String> l = new List<>();
        //launch();
    }
}