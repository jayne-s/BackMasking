/**
 * Implementation of the Node class which creates an object of type ListStackNode
 * that contains a double and two pointers, next and prev. The constructor is invoked
 * each time a new node is added to the list through the use of the push() method. 
 * When multiple ListStackNodes are connected to one another using
 * the corresponding next and prev pointers, they form a doubly linked list.
 * Time Complexity: O(1)
 */

public class ListStackNode {
    ListStackNode next;
    ListStackNode prev;
    double data;
    ListStackNode(double n){
        data = n;
        next = null;
        prev = null;
    }
}
