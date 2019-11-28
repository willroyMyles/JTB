package fileOperations;

import model.Place;


class Node {
    Place value;
    Node left;
    Node right;

   Node(Place p){
       super();
       this.value = p;
       right = null;
       left = null;
   }
}