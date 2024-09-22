import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;

public class ListStack implements BKStack, Iterable<Double> {

    /**
    * Implementation of the Node class which creates an object of type ListStackNode
    * that contains a double and two pointers, next and prev. The constructor is invoked
    * each time a new node is added to the list through the use of the push() method. 
    * When multiple ListStackNodes are connected to one another using
    * the corresponding next and prev pointers, they form a doubly linked list.
    * Time Complexity: O(1)
    */
    private class ListStackNode {
        ListStackNode next;
        ListStackNode prev;
        Double data;
        ListStackNode(Double d){
            data = d;
            next = null;
            prev = null;
        }
    }


    private static ListStackNode head;
    private static ListStackNode tail;
    private int modifyCount = 0;

    private class ListStackIterator implements java.util.Iterator<Double> {

        private ListStackNode curr = head;
        private int modifyCountCheck = modifyCount;

        /**
        * This method checks whether there is another node in the linked 
        * list by checking whether the current node's next pointer is null 
        * and returning a boolean value. 
        * Time Complexity: O(1)
        */

        public boolean hasNext(){
            return curr.next != null;
        }

        /**
        * This method returns the current node's double value and goes to 
        * the next node in the linked list. Before performing this action, 
        * it checks whether there is a modification to the linked list outside
        * of the iterator when its methods are being called. It also ensures
        * that there is a next node by calling the hasNext function.
        * Time Complexity: O(1)
        */

        public Double next() {
            if(!hasNext()){
                throw new EmptyStackException();
            }

            if(modifyCount != modifyCountCheck){
                throw new ConcurrentModificationException();
            }

            Double item = curr.data;
            curr = curr.next;
            return item;
        }

        /**
        * This method removes the current node and links the previous node 
        * to the next node and vice versa. Before performing this action, 
        * it checks whether there is a modification to the linked list outside
        * of the iterator when its methods are being called. This method is not 
        * used in the program and was completed for practice purposes. 
        * Time Complexity: O(1)
        */

        public void remove(){
            if(modifyCount != modifyCountCheck){
                throw new ConcurrentModificationException();
            } else if (!hasNext()){
                throw new EmptyStackException();
            }

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            modifyCountCheck++;
        }

    }

    /**
    * This constructor method makes the linked list empty when invoked. To do this,
    * the head node will point to the tail and the tail will point to the head,
    * which makes a list of size zero.  
    * Time Complexity: O(1)
    */

    public ListStack(){
        head = null;
        tail = null;
    }

    /**
    * This method returns an instance of the ListStackIterator when invoked. 
    * Time Complexity: O(1)
    */
    
    public java.util.Iterator<Double> iterator() {
        return new ListStackIterator();
    }

    /**
    * This method checks whether the linked list is empty by checking whether the head node is null. 
    * If the head node is null, then the function returns true and the linked list is empty.
    * Time Complexity: O(1)
    */
    
    public boolean isEmpty(){
        return head == null;
    }

    /**
    * This method counts the number of nodes in the linked list. As the initial conditional statement,
    * it utilizes the isEmpty function to check whether the linked list is empty, thus having a count 
    * of zero. The count variable is instantiated as 1 as the hasNext method from the Iterator
    * implementation prevents the enhanced for loop from counting the last node. The use of the iterator
    * in the enhanced for loop reduces the time taken for this operation by providing a pointer to 
    * the last element counted so that the all the nodes need not be traversed every time the function
    * is called. 
    * Time Complexity: O(n)
    */
    
    public int count(){ 
        int count = 1;

        if(isEmpty()){
            return 0;
        }

        for(java.util.Iterator<Double> i = this.iterator(); i.hasNext();) {
            count++;
            i.next();
        }
        return count;
    }

    /**
    * This method adds a new node with a specified double value to the end of 
    * the linked list. First, the method checks whether the linked list is empty. If
    * it is, then the node is inserted as the head. For the insertion of subsequent 
    * nodes, we use the tail node to specify that the tail node points to the new node, 
    * the new node points to the tail node, and the new node will become the new tail node.
    * Time Complexity: O(1)
    */
    
    public void push(double d){
        ListStackNode node = new ListStackNode(d);
        if(tail == null){
            head = node;
            tail = node;
            modifyCount++;
            return;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            modifyCount++;
        }
        
    }

    /**
    * This method removes the last node in the linked list. Before performing
    * this action, the method checks whether the linked list is empty so that 
    * a nonexistent node is not removed. For the deletion of the end node, we
    * direct the second last node in the linked list to point to null and set this
    * node to be the new tail, while returning the double value stored in the 
    * old tail node. 
    * Time Complexity: O(1)
    */
    
    public double pop(){

        if(tail == null){
            throw new EmptyStackException();
        } 
        
       else if (tail == head){
            double data = tail.data;
            tail = null;
            head = null;
            modifyCount++;
            return data;
        } 

        else {
            double data = tail.data;
            tail = tail.prev;
            tail.next = null;
            modifyCount++;
            return data;
        }
        
    }

    /**
    * This method returns the double value stored in the tail node, if the linked list is not empty.  
    * Time Complexity: O(1)
    */
    
    public double peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return head.data;
    }

}
