package model;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by Danny on 17-3-2017.
 */
public class TreeNode<E extends Comparable> {

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

    public E getElement() {
        return this.element;
    }

    public ArrayList<TreeNode<E>> getChildren() {
        ArrayList<TreeNode<E>> list = new ArrayList<>();

        list.add(this.left);
        list.add(this.right);

        return list;
    }

    public TreeNode<E> getLeftChild() {
        return this.left;
    }

    public TreeNode<E> getRightChild() {
        return this.right;
    }

    public String getAllElements() {
        String result = this.element.toString() + "\n";
        if(this.left != null) {
            result += this.left.toString();
        }
        if(this.right != null) {
           result += this.right.toString();
        }
        return result;
    }

    public boolean search(E element) {
        TreeNode<E> current = this; // Start from the current TreeNode

        while (current != null) {
            if (current.getElement().compareTo(element) == 1) {
                current = current.left; // Go left
            } else if (element.compareTo(current.getElement()) == -1) {
                current = current.right; // Go right
            } else if (element.compareTo(current.getElement()) == 0) { // Element matches current.element
                return true; // Element is found
            }
        }
        return false; // Element is not in the tree
    }

    @Override
    public String toString() {
        return this.getElement().toString();
    }

}
