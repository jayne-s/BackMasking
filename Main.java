public class Main {
    
    public static void main(String[] args) {

    //    ArrayStack arr = new ArrayStack();
    //    arr.push(1.2);
    //    arr.push(2.3);
    //    arr.push(3.4);
    //    arr.push(4.5);
    //    arr.push(5.6);
    //    System.out.println("peek: " + arr.peek());
    //    System.out.println("count: " + arr.count());
    //    arr.printItems();
    //    System.out.println("last item: " + arr.pop());
    //    System.out.println("count: " + arr.count());
    //    arr.printItems();
    //    System.out.println("last item: " + arr.pop());
    //    System.out.println("count: " + arr.count());
    //    arr.printItems();

        
       ListStack list = new ListStack();
       list.push(1.2);
       list.push(2.3);
       list.push(3.4);
       list.push(4.5);
       list.push(5.6);
       while(!list.isEmpty()){
        System.out.println(list.pop());
       }

    //    System.out.println("count: " + list.count());
    //    list.printItems();
    //    System.out.println("peek: " + list.peek());
    //    System.out.println("last item: " + list.pop());
    //    System.out.println("count: " + list.count());
    //    list.printItems();
    //    System.out.println("last item: " + list.pop());
    //    System.out.println("count: " + list.count());
    //    list.printItems();
    //    list = new ListStack();
    //    System.out.println("count: " + list.peek());


    }

}
