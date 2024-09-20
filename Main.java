public class Main {
    
    public static void main(String[] args) {


       ListStack list = new ListStack();
       list.push(1.2);
       list.push(2.3);
       list.push(3.4);
       list.push(4.5);
       list.push(5.6);
       System.out.println("count: " + list.count());
       list.printItems();
       System.out.println("peek: " + list.peek());
       System.out.println("last item: " + list.pop());
       System.out.println("count: " + list.count());
       list.printItems();
       System.out.println("last item: " + list.pop());
       System.out.println("count: " + list.count());
       list.printItems();



    }

}
