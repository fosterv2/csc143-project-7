import java.util.NoSuchElementException;

/**
 * The class Queue makes a list of QNodes with the rule of first in, first out. When an element is added, it goes at the end of the list,
 * and when an element is removed it comes from the front of the list.
 *
 * @author  Valerie Foster
 * @version 3/15/2018
 */
public class Queue<E> {
    
    // instance variable
    private QNode<E> front;

    /**
     * Constructor for objects of class LinkedList
     */
    public Queue() {
        front = null;
    }

    /**
     * This method clears the queue and makes it empty
     */
    public void clear() {
        front = null;
    }

    /**
     * This method returns the number of elements in the list
     *
     * @return    the count of the list, an Integer
     */
    public int size() {
        int count = 0;
        QNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    /**
     * This method returns true if the queue is empty or false if it is not
     *
     * @return    a boolean
     */
    public boolean isEmpty() {
        return front == null;
    }
    
    /**
     * This method adds a given value at the end of the list, has differnt cases if it is the first element in the list or not
     *
     * @param   value   a given value of type E to add to the list
     */
    public void add(E value) {
        QNode<E> newNode = new QNode<E>(value);
        if (front == null) {
            front = newNode;
        } else {
            QNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * This method removes and returns the element at the front of the queue, has a precondition that the queue cannot be empty
     *
     * @throws      NoSuchElementException if the queue is empty
     * @return      the data from the node at the front of the queue
     */
    public E remove() {
        if (front == null) {
            throw new NoSuchElementException("The queue is empty.");
        }
        E data = front.data;
        front = front.next;
        return data;
    }

    /**
     * This method returns the element at the front of the queue, or returns null if the queue is empty
     *
     * @return      the data from the node at the front of the queue
     */
    public E peek() {
        if (front == null) {
            return null;
        } else {
            return front.data;
        }
    }

    /** 
     * Creates and returns a string representation of this queue
     * 
     * @return  a String showing basic information about the Queue
     */
    @Override
    public String toString() {
        String listOutput = "List contents: ";
        if (front == null) {
            listOutput += "(0 nodes)";
        } else {
            listOutput += "(" + size() + " nodes):\n";
            QNode<E> current = front;
            listOutput += current;
            while (current.next != null) {
                current = current.next;
                listOutput += current;
            }
        }
        return listOutput;
    }

    private class QNode<E> {

        // instance variables
        public E data;
        public QNode<E> next;

        public QNode(E data) {
            this.data = data;
            next = null;
        }

        public String toString() {
            String str = "";
            str += data;
            return str;
        }

    }

}
