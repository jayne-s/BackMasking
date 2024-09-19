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
            //System.out.println("position: " + curr.next.data);
            //System.out.println("tail: " + tail.data);
            //curr = curr.next;
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

    public boolean isEmpty(){
        return head == null;
    }

    public int count(){ //FIXME
        int count = 1;

        if(isEmpty()){
            return 0;
        }

        for(Iterator<Double> i = this.iterator(); i.hasNext();) {
            count++;
            Double item = i.next();
            //System.out.println(item);
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
//        while(curr.next != null){
//            curr = curr.next;
//        }
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
