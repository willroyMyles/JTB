package fileOperations;

import model.Place;
import model.Request;

import java.io.Serializable;

public class BinaryTree implements Serializable {

    Node root;

    public BinaryTree(){};

    private Node addRecursive(Node current, Request value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.getDate().compareTo( current.value.getDate()) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.getDate().compareTo( current.value.getDate()) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(Request value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, Request value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value.getDate().compareTo( current.value.getDate()) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(Request value) {
        return containsNodeRecursive(root, value);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

}
