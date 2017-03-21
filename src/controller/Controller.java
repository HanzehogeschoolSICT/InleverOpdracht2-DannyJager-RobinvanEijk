package controller;


import model.Model;

/**
 * Controller which handles the actionEvent of the solveButton
 * Created by Danny on 15-3-2017.
 */
public class Controller {
    private Model model;

    /**
     * construct the Controller
     * @param model
     */
    public Controller(Model model){
        this.model = model;
    }

    /**
     * calls the findWords algorithm in the Model class
     */
    public void Solve(){
        model.findWords();
    }

}
