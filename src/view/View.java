package view;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.BoardCharacter;
import model.Model;

import java.util.ArrayList;

/**
 * Class which contains the View for the application and starts it.
 * Created by robin on 13-3-17.
 */
public class View extends Application {

    // Variables to create the BoggleField
    private static final int gap = 7;               // The size of the gaps between the labels
    private static final double labelSize = 100;    // The height and width of the labels
    private TextArea textArea;                      // TextArea which displays the found words

    private Model model;
    private Controller controller;


    /**
     * Constructs the mainView of the application.
     */
    public View(){
        this.model = new Model();
        this.controller = new Controller(model, this);
    }

    /**
     * Launches the JavaFX application
     */
    public void launchApplication() {
        launch();
    }


    /**
     * Constructs the JavaFX GUI.
     * @param stage
     */
    @Override
    public void start(Stage stage){

        stage.setTitle("Boggle Solver");

        // Instantiate the GridPane with the boggleField
        GridPane boggleField = createBoggleField();

        // Instantiate the textArea for the found words.
        textArea = createFoundWordArea();

        // Instantiate an HBox to add the solve button to
        HBox hBox = createButtonBox();
        Button button = createSolveButton();
        hBox.getChildren().addAll(button);

        // Instantiate a BorderPane to which we add the boggleField and the Hbox.
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(boggleField);
        borderPane.setBottom(hBox);
        borderPane.setRight(textArea);

        //Add the BorderPane to the javaFX scene and display the application.
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    /**
     * Constructs a GridPane with the boggle field with the characters in it.
     * @return GridPane
     */
    private GridPane createBoggleField() {
        GridPane gridPane = new GridPane();

        // Set the layout of the boggleField
        setBoggleFieldLayout(gridPane);

        // Adds characters from the 2d array of BoardCharacters to the gridPane
        BoardCharacter[][] field = model.getField();
        int x = 0;
        for (BoardCharacter[] boardCharacters : field) {
            int y = 0;
            for (BoardCharacter boardCharacter : boardCharacters) {
                Label label = createBoggleLabel(boardCharacter.getCharacter());
                gridPane.add(label, y, x);
                y++;
            }
            x++;
        }
        return gridPane;
    }


    /**
     * Sets the correct layout for the boggleField
     */
    private void setBoggleFieldLayout(GridPane gridPane){
        // Set the alignment
        gridPane.setAlignment(Pos.CENTER);

        // Set the spacing and padding
        gridPane.setVgap(gap);
        gridPane.setHgap(gap);
        gridPane.setPadding(new Insets(gap, gap, gap, gap));

        // Set the background color to the original boggle orange/yellow.
        gridPane.setStyle(  "-fx-background-color: #FE9A2E;" +
                            "-fx-border-color: black;" +
                            "-fx-border-width: 2;");
    }


    /**
     * Creates and returns a Label with a random character from the alphabet in it, and sets the correct style.
     * @return Label
     */
    private Label createBoggleLabel(String randomCharacter){
        //Create new label with a random character in it
        Label label = new Label(randomCharacter);

        // Set the layout of the label
        label.setFont(new Font(35));
        label.setPrefSize(labelSize,labelSize);
        label.setAlignment(Pos.CENTER);
        label.setStyle( "-fx-border-color: black;" +
                        "-fx-border-width: 2;"+
                        "-fx-background-color: white;");
        return label;
    }


    /**
     * Creates and returns a HBox in which buttons can be placed.
     * @return HBox
     */
    private HBox createButtonBox(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(gap, gap, gap, gap));
        hBox.setStyle(  "-fx-background-color: grey;");

        return hBox;
    }


    /**
     * Creates and returns a single "Solve" button
     * @return Button
     */
    private Button createSolveButton(){
        Button button = new Button("Solve");
        button.setPrefSize(90,40);
        button.setFont(new Font(17));
        button.setOnAction(event ->
                controller.solve());

        return button;
    }

    /**
     * creates the Stage for the found words.
     */
    private TextArea createFoundWordArea(){
        TextArea textArea = new TextArea();
        textArea.appendText("\nNo words found yet.");
        textArea.appendText("\n\nClick solve to search words");
        textArea.setEditable(false);
        textArea.setMaxWidth(250);
        textArea.setFont(new Font(15));

        return textArea;
    }

    /**
     * Gets called by the controller and update the textArea with the found words.
     * @param words
     */
    public void updateFoundWordArea(ArrayList<String> words){
        textArea.setText("\nNumber of words found: " + words.size());
        textArea.appendText("\n\nWords found: ");
        for (Object word : words){
            textArea.appendText("\n" + word);
        }
    }
}
