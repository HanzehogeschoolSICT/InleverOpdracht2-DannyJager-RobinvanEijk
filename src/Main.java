import controller.MainController;
import model.TreeNode;
import view.MainView;

/**
 * Created by Danny on 16-3-2017.
 */
public class Main {

    public static void main(String[] args) {

        // Create a controller
        MainController controller = new MainController();

        TreeNode<String> root = new TreeNode<String>("B");
        TreeNode<String> left1 = root.setLeft(new TreeNode<String>("A"));
        TreeNode<String> right1 = root.setRight(new TreeNode<String>("C"));
        TreeNode<String> left2 = left1.setLeft(new TreeNode<String>("Z"));
        TreeNode<String> right2 = right1.setRight(new TreeNode<String>("D"));

        System.out.println(root);
    }

}
