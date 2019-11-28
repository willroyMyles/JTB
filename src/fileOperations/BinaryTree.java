package fileOperations;

import model.Place;
import model.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BinaryTree implements Serializable {

    public Node root;

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

    public void updateButtons(Node node){
        if (node != null) {
            updateButtons(node.left);
            node.value.setUpButton();
            updateButtons(node.right);
        }
    }

    public ArrayList<Request> getAllRequests(Node node, ArrayList<Request> l){

        if (node != null) {
            getAllRequests(node.left, l);
            l.add(node.value);
            getAllRequests(node.right, l);
        }
        return l;
    }


    public ArrayList<Request> getRequestlistInOrder(Node node, ArrayList<Request> l){

        if (node != null) {
            getRequestlistInOrder(node.left, l);
            if(!node.value.isProcessed())l.add(node.value);
            getRequestlistInOrder(node.right, l);
        }
        return l;
    }

    public ArrayList<Request> getRequestlistProcessed(Node node, ArrayList<Request> l){
        if (node != null) {
            getRequestlistProcessed(node.left, l);
            getRequestlistProcessed(node.right, l);
            //post order so last processed first
            if(node.value.isProcessed())    l.add(node.value);
        }
        return l;
    }

    public void updateProcessedNode(Node node, String request){

        if (node != null) {
            updateProcessedNode(node.left, request);
            updateProcessedNode(node.right, request);
            //post order so last processed first
            if(!node.value.isProcessed() && node.value.getRequestId() == request) {
                node.value.setProcessed(true);
            }
        }
    }

}
