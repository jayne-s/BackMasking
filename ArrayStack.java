public class ArrayStack implements BKStack{

    private double[] items;
    private int size;
    private final int INITIAL_CAPACITY = 5;
    private int capacity = 5;
    private int ptr = -1;

    public ArrayStack(){
        size = 0;
        ensureCapacity(INITIAL_CAPACITY);
    }

    public boolean isEmpty(){
       return count() == 0;
    }

    public int count(){
        return size;
    }

    public void push(double d){
        if(count() >= capacity){
            ensureCapacity(capacity*2);
        }
        items[size++] = d;
        ptr++;
    }

    public double pop(){
        double lastItem = items[count()-1];
//        for(int i = 0; i < count()-1; i++){
//            items[i] = items[i+1];
//        }
        items[ptr] = 0.0;
        size--;
        ptr--;
        if(count() <= (capacity/2)){
            ensureCapacity((capacity/2));
        }
        return lastItem;
    }

    public double peek(){
        return items[0];
    }

    private void ensureCapacity(int newCapacity){
        if(newCapacity >= count()){
            double[] temp = items;
            items = new double[newCapacity];
            capacity = newCapacity;
            for(int i = 0; i < count(); i++){
                items[i] = temp[i];
            }
        }
    }

    public void printItems(){
        for(double item: items){
            System.out.println(item + " ");
        }
        System.out.println();
    }

}
