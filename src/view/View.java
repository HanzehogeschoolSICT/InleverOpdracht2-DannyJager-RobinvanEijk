package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Created by robin on 13-3-17.
 */
class View extends GridPane {
    private static final int gap = 10;

    /**
     * Constructs the view for the boggle field.
     */
    View() {
        this.setVgap(gap);
        this.setHgap(gap);
        this.setPadding(new Insets(gap, gap, gap, gap));


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                Label label = new Label("label");
                label.setAlignment(Pos.CENTER);
                label.setPrefSize(100,100);
                this.add(label,j,i);
            }
        }
    }
}

