package synthesizer;
import java.util.Iterator;

/**
 * Created by 17663 on 2017/6/27.
 */
public interface BoundedQueue<T> extends Iterable<T>{
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();
    default boolean isEmpty(){
        int a = fillCount();
        return a==0;
    }
    default boolean isFull(){
        int a = fillCount();
        int b = capacity();
        return a == b;
    }

    Iterator<T> iterator();

}
