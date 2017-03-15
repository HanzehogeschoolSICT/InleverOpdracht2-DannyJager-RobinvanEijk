package controller;

import model.CharacterModel;
import view.MainView;

/**
 * Created by Danny on 15-3-2017.
 */
public class MainController {

    // The MainView
    private MainView view;

    // The CharacterModel
    private CharacterModel model;

    /**
     * Constructor. Sets the views and models.
     * @param view
     */
    public MainController(MainView view) {
        this.view = view;
        this.model = new CharacterModel();
    }

    /**
     * Launches the application
     */
    public void launch() {
        System.out.println("Launching the boggle application");
        this.view.launchApplication();
    }
}
