package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by robin on 13-3-17.
 */
public class MainView extends Application {

    // The GridPaneView that extends the GridPane
    private GridPaneView gridPaneView;

    // The field that holds the random generated characters
    private String[][] generatedCharacters;

    /**
     * Constructor
     */
    public MainView() {
        // Constructor
    }

    /**
     * Launches the application
     */
    public void launchApplication() {
        launch();
    }

    /**
     * Starts the GUI.
     *
     * @param stage
     */
    @Override
    public void start(Stage stage){

        stage.setTitle("Boggle Opgave");

        // Instantiate the GridPaneView
        this.gridPaneView = new GridPaneView(this);

        Scene scene = new Scene(gridPaneView,gridPaneView.getWidth(),gridPaneView.getHeight());
        stage.setScene(scene);
        stage.show();

    }


}
