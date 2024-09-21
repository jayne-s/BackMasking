# BackMasking

# Student Information

| **Name:** Jayne Srinivas | 
**NetID:** JPS210003 |
**Section:** CS 3345.002 |

# Implementation Details

## ArrayStack

The ArrayStack class is an array list implementation of a stack (LIFO). 
An array list is a dynamically resizable array.

**ArrayStack:** This method resets the size of the array to be zero and creates a new array with a capacity specified by the INITIAL_CAPACITY variable, using a for loop to copy the elements into the new array using the ensureCapacity function. Since the 
ensureCapacity function is called everytime the constructor is also called, the upper-bound time complexity is O(n). 

**isEmpty:** This method checks whether the array is empty by checking whether the array count is equal to zero by utilizing the count function. Since the count function simply returns the size variable and the isEmpty function just performs a simple comparison of size to zero, the upper-bound time complexity is O(1).

**count:** This method returns the amount of elements in the array by returning the size variable, which is incremented or decremented
when the push or pop methods are called, correspondingly. Thus, the upper-bound time complexity is O(1).

**push:** This method adds a new double element to the end of the array if the capacity is large enough. Using the size variable as an
index, it adds the new element at the end of the array and increments the size variable. In the worst case, the capacity of the array needs to be doubled to hold the new element, making the upper-bound time complexity O(n). However, if there is enough space in the array to hold the new element, then the upper-bound time complexity is O(1). 

**pop:** This method removes the last double element from the end of the array, if the array is not empty, by using the (count function - 1) as the index to retrieve the value to be returned. The size variable is then decremented. An additional feature is added to reduce the capacity of the array by a factor of two if the number of elements in the array is less than or equal to half of the current capacity by calling the ensureCapacity function. In the worst case, the ensureCapacity function will be called, mkaing the upper-bound time complexity O(n). However, if the capacity is not decreased, then the upper-bound time complexity is O(1).

**peek:** This method returns the double value that is present at the beginning of the array, if the array is not empty. The upper-bound time complexity is O(1).

**ensureCapacity:** This method is used to increase/decrease the capacity of the array. It performs the needed action by copying the elements from the old array into the new array with an increased/decreased capacity. The upper-bound time complexity is O(n).

Overall, the worst case time complexity of the ArrayStack implementation is O(n). 

## ListStack

The ListStack class is an linked list implementation of a stack (LIFO). 
A linked list is a sequence of nodes connected to one another using pointers.

**ListStackNode:** The constructor in this class creates a new node that contains a double data value, next pointer, and prev pointer. The upper-bound time complexity if O(1).

**iterator:** This method returns an instance of the ListStackIterator, which has its own private class where the next and hasNext methods are implemented. The hasNext method checks if the current node has another node after it by comparing it to null. The next method returns the current node's data and advances to the next node if the current node has a next node. Additionally, the next method checks if any modifications occur to the linked list outside of the iterator by comparing the modifyCount and modifyCountCheck values to each other. Overall, the upper-bound time complexity of the iterator method and the methods in the ListStackIterator class are all O(1).

**ListStack:** The constructor for the ListStack class simply instantiates the head and tail nodes of the linked list to null. This upper-bound time complexity is O(1). 

**isEmpty:** This method checks whether the linked list is empty by checking whether the head node is empty by comparing it to null. The upper-bound time complexity is O(1). 

**count:** This method returns the count of nodes in the linked list. If the linked list is empty, then the count is returned as zero. The method utilizes the iterator to traverse the linked list by utilizing the hasNext and next methods to check whether the current node has a next node and then update the current node to be the next node if hasNext is satisfied. The upper-bound time complexity of this method is O(n). 

**push:** This method adds a new node to the end of the linked list. If the list is empty, the new node is added as the head node. Otherwise, the tail node points to the new node, the new node points to the tail node, and the new node is set to be the new tail. The upper-bound time complexity is O(1). 

**pop:** This method removes the last node in the linked list. If the list is empty, an EmptyStackException is thrown. If there is only one node in the linked list, then tail's data is returned and head and tail nodes are set to null. Otherwise, the tail's data is returned, the second last node is set to be the new tail node, and the tail's next node is set as null. The upper-bound time complexity is O(1).

**peek:** This method returns the double value that is stored in the node at the start of the linked list, if the linked list is not empty. The upper-bound time complexity is O(1).

Overall, the worst case time complexity of the ListStack implementation is O(n).
