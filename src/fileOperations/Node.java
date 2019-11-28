package fileOperations;

import model.Place;
import model.Request;


class Node {
    Request value;
    Node left;
    Node right;

   Node(Request p){
       super();
       this.value = p;
       right = null;
       left = null;
   }
}