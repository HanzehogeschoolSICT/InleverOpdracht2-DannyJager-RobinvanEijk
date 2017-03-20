package controller;

import view.MainView;

/**
 * Created by Danny on 15-3-2017.
 */
public class MainController {

    // The MainView
    private MainView mainView;

    /**
     * Constructor. Sets the views and models.
     */
    public MainController() {
        this.mainView = new MainView();
        launch();
    }

    /**
     * Launches the application
     */
    public void launch() {
        System.out.println("Launching the boggle application");
        this.mainView.launchApplication();
    }

}
