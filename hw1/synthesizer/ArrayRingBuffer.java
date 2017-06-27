// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;


    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        this.rb = (T[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            rb[i] = null;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        } else if (fillCount == 0) {
            rb[last] = x;
            fillCount += 1;
        } else {
            if (last + 1 == this.capacity) {
                last = 0;
                rb[last] = x;
                fillCount += 1;
            } else {
                last += 1;
                rb[last] = x;
                fillCount += 1;
            }
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
            T item = rb[first];
            rb[first] = null;
            fillCount -= 1;
            if (first + 1 == this.capacity) {
                first = 0;
            } else {
                first = first + 1;
            }
            return item;
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (fillCount == 0) {
            throw new RuntimeException("No elements in ring");
        } else {
            T item = rb[first];
            return item;
        }
    }

    private class myIterator implements Iterator<T>{
        private int index = first;
        @Override
        public boolean hasNext(){
            int next = index + 1;
            if (index == capacity - 1) {
                next = 0;
            }
            return rb[next] != null;
        }

        @Override
        public T next(){
            int next = index + 1;
            if (index == capacity - 1) {
                next = 0;
            }
            return rb[next];
        }
        @Override
        public void remove(){
        }
    }


    public Iterator<T> iterator(){
        return new myIterator();
    }

}

    // TODO: When you get to part 5, implement the needed code to support iteration.


