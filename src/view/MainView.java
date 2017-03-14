package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by robin on 13-3-17.
 */
public class MainView extends Application {

    public static void launchApplication(String[] args){
        System.out.println("Launching the boggle application");
        launch(args);
    }
    public void start(Stage stage){
        stage.setTitle("Boggle Opgave");
        View view = new View();
        Scene scene = new Scene(view,600,600);
        stage.setScene(scene);
        stage.show();
    }
}
