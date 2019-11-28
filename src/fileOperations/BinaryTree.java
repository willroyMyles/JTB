package fileOperations;

import model.Place;

public class BinaryTree {

    Node root;

    public BinaryTree(){};

    private Node addRecursive(Node current, Place value) {
        if (current == null) {
            return new Node(value);
        }

        if (value.getCostForEntry() < current.value.getCostForEntry()) {
            current.left = addRecursive(current.left, value);
        } else if (value.getCostForEntry() > current.value.getCostForEntry()) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(Place value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, Place value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value.getCostForEntry() < current.value.getCostForEntry()
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(Place value) {
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
