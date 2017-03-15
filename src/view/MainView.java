package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by robin on 13-3-17.
 */
public class MainView extends Application {

    public static void launchApplication(String[] args){
        // Launch the application
        System.out.println("Launching the boggle application");
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("Boggle Opgave");
        View view = new View();
        Scene scene = new Scene(view,view.getWidth(),view.getHeight());
        stage.setScene(scene);
        stage.show();
    }
}
