package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.CharacterModel;

/**
 * Class for the view of the boggle field which contains the characters.
 * Created by robin on 13-3-17.
 */
public class View extends GridPane {

    private static final int gap = 7;               // The size of the gaps between the labels
    private static final double labelSize = 100;    // The height and width of the labels
    private static final int labelamount = 4;       // The amount columns and labels per column

    private CharacterModel characterModel;

    /**
     * Constructs the view for the boggle field with the characters in it.
     */
    public View() {

        // Create the CharacterModel
        characterModel = new CharacterModel();

        // Set the layout of this view
        this.setLayout();

        // Create the labelAmount x labelAmount grid with labels in it
        for (int i = 0; i < labelamount; i++) {
            for (int j = 0; j < labelamount; j++){
                Label label = createLabel();
                this.add(label,j,i);
            }
        }
    }


    /**
     * Sets the correct layout for this view.
     */
    private void setLayout(){
        // Set the alignment
        this.setAlignment(Pos.CENTER);

        // Set the spacing and padding
        this.setVgap(gap);
        this.setHgap(gap);
        this.setPadding(new Insets(gap, gap, gap, gap));

        // Set the size of this view
        this.setHeight(labelSize*labelamount);
        this.setWidth(labelSize*labelamount);

        // Set the background color to the original boggle orange/yellow.
        this.setStyle("-fx-background-color: #FE9A2E;");
    }


    /**
     * Creates and returns a Label with a random character from the alfabet in it, and sets the correct style.
     * @return Label
     */
    private Label createLabel(){
        //Create new label with a random character in it
        Label label = new Label(Character.toString(characterModel.generateRandomCharacter()));

        // Set the layout of the label
        label.setFont(new Font(35));
        label.setPrefSize(labelSize,labelSize);
        label.setAlignment(Pos.CENTER);
        label.setStyle( "-fx-border-color: black;" +
                        "-fx-border-width: 2;"+
                        "-fx-background-color: white;");

        return label;
    }

}

