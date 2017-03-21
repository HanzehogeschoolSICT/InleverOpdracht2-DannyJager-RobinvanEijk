package controller;


import model.Model;

/**
 * Created by Danny on 15-3-2017.
 */
public class Controller {
    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    public void Solve(){
        model.findWords();
    }

}
