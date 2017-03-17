package model;

/**
 * Created by Danny on 17-3-2017.
 */
public class TreeNode<E> {

    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E element) {
        this.element = element;
    }

    public TreeNode<E> setLeft(TreeNode<E> left) {
        this.left = left;
        return this.left;
    }

    public TreeNode<E>  setRight(TreeNode<E> right) {
        this.right = right;
        return this.right;
    }


    @Override
    public String toString() {
        String result = this.element.toString() + "\n";
        if(this.left != null) {
            result += this.left.toString();
        }
        if(this.right != null) {
           result += this.right.toString();
        }
        return result;
    }
}
