package controller;

import model.Model;
import view.View;

/**
 * Controller which handles the actionEvent of the solveButton
 * Created by Danny on 15-3-2017.
 */
public class Controller {
    private Model model;
    private View view;

    /**
     * construct the Controller
     * @param model
     */
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    /**
     * calls the word finding algorithm in the Model class
     */
    public void solve(){
        model.startWordFinding();
        updateFoundWordStage();
    }

    /**
     * calls the updateFoundWordArea in the Model class to update it with the newest data.
     */
    private void updateFoundWordStage(){
        view.updateFoundWordArea(model.getWords());
    }

}
