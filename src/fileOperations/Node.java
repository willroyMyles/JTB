package fileOperations;

import model.Place;
import model.Request;

import java.io.Serializable;


class Node implements Serializable {
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