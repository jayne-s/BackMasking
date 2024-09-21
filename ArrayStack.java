
public class ArrayStack implements BKStack{

    private double[] items;
    private int size;
    private final int INITIAL_CAPACITY = 100;
    private int capacity = 100;

    /**
    * This constructor method creates a new array with a size of zero and 
    * a default capacity of five elements by utilizing the ensureCapacity 
    * method, which increases the capacity of the array. 
    * Time Complexity: O(n)
    */

    public ArrayStack(){
        size = 0;
        ensureCapacity(INITIAL_CAPACITY);
    }

    /**
    * This method checks whether the array is empty by using the
    * count function to retrieve the size of the array. If the size 
    * is equal to zero, then the array is empty and the function will 
    * return true. 
    * Time Complexity: O(1)
    */
    
    public boolean isEmpty(){
       return count() == 0;
    }

    /**
    * This method returns the size of the array, i.e. the number of elements
    * in the array. The size is calculated by incrementing the size variable when 
    * an element is added and by decrementing the size variable when an element is removed.
    * Time Complexity: O(1)
    */

    public int count(){
        return size;
    }

    /**
    * This method adds an element to the end of the array. Before doing this,
    * first we ensure there is enough space in the array to add another element
    * by comparing the size with the capacity. If the size is equal to or exceeds
    * the capacity, then the ensureCapacity method will be called to double the 
    * capacity of the array. However, if there is enough space, then the method
    * will just add the element to the end of the array and increment the size variable.
    * Time Complexity: O(n)
    */

    public void push(double d){
        if(count() >= capacity){
            ensureCapacity(capacity*2);
        }
        items[size++] = d;
    }

    /**
    * This method removes and returns the last element from the array by using the count 
    * function and subtracting one from it to retrieve the corresponding index. When the 
    * last element is removed, the size variable is decremented. Additionally, the array's 
    * capacity can be resized if the number of elements in the array is less than or equal
    * to half of the current capacity. 
    * Time Complexity: O(1) since for the purposes of this project, the stack size will only increase
    */

    public double pop(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }
        double lastItem = items[count()-1];
        items[count()-1] = 0.0;
        size--;
        if(count() <= (capacity/2)){
            ensureCapacity((capacity/2));
        }
        return lastItem;
    }

    /**
    * This method returns the double value stored at the beginning of the array,
    * if the array is not empty. 
    * Time Complexity: O(1)
    */

    public double peek(){
        if(isEmpty()){
            throw new java.util.EmptyStackException();
        }
        return items[0];
    }

    /**
    * This method adjusts the capacity of the array by increasing or decreasing 
    * the capacity by a factor of two depending on the number of elements being 
    * stored. The method uses a for loop to copy the elements from the original 
    * array to a new array with a different capacity value. 
    * Time Complexity: O(n)
    */

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

}
