package controller;


import model.Model;

import java.util.ArrayList;

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
        ArrayList<String> woorden = model.loopFindWords();
        System.out.println("Gevonden woorden:  ");
        for (String woord: woorden){
            System.out.println(woord);
        }
    }

}
