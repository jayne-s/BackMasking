import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ListStack implements BKStack, Iterable<Double> {

    private ListStackNode head;
    private ListStackNode tail;
    private int modifyCount = 0;

    public Iterator<Double> iterator() {
        return new ListStackIterator();
    }

    private class ListStackIterator implements Iterator<Double> {

        private ListStackNode curr = head;
        private int modifyCountCheck = modifyCount;

        public boolean hasNext(){
            return curr.next != null;
        }

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

        public void remove(){
            if(modifyCount != modifyCountCheck){
                throw new ConcurrentModificationException();
            }

            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            modifyCountCheck++;
        }

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

        for(Iterator<Double> i = this.iterator(); i.hasNext();) {
            count++;
            Double item = i.next();
        }
        return count;
    }

    public void push(double d){
        ListStackNode node = new ListStackNode(d);
        ListStackNode last = head;
        if(isEmpty()){
            head = node;
            tail = node;
            modifyCount++;
            return;
        }
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
        tail = node;
        modifyCount++;
    }

    public double pop(){
        ListStackNode curr = head;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        while(curr.next.next != null){
            curr = curr.next;
        }
        ListStackNode end = curr.next;
        curr.next = null;
        modifyCount++;
        tail = end.prev;
        return end.data;
    }

    public double peek(){
        ListStackNode curr = head;
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return tail.data;
    }

    public void printItems(){
        ListStackNode curr = head;
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
