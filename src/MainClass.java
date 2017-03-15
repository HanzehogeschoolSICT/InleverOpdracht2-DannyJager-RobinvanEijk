import controller.MainController;
import javafx.application.Application;
import view.MainView;


/**
 * Created by robin on 13-3-17.
 */
public class MainClass {

    public static void main(String[] args) {

        // Create a MainView
        MainView view = new MainView();

        // Create a MainController and add the MainView in it
        MainController controller = new MainController(view);

        // Launch the application
        controller.launch();

    }
}
