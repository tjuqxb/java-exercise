/**
 * Created by 17663 on 2017/6/12.
 */
public class ArrayDeque <Item>{
    public int space;
    public int first;
    public int last;
    public int size;
    public Item[] arr;

    public ArrayDeque(){
        this.arr = (Item[]) new Object[8];
        this.space = 8;
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public void clear(){
        this.arr = (Item[]) new Object[8];
        this.space = 8;
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public void moveBig(){
        if (first > last) {
            Item[] arr0 = (Item[])new Object[2 * space];
            System.arraycopy(arr, 0, arr0, 0, last + 1);
            System.arraycopy(arr, first, arr0, space + first - 1, space - first + 1);
            this.space = 2 * space;
            this.arr = arr0;
            this.first = space + first - 1;
        } else {
            Item[] arr0 = (Item[])new Object[2 * space];
            System.arraycopy(arr, first, arr0, first, last - first + 1 );
            this.arr = arr0;
        }
    }

    public void moveSmall(){
        if (first > last) {
            Item[] arr0 = (Item[])new Object[space/2];
            System.arraycopy(arr, 0, arr0, 0, last + 1);
            System.arraycopy(arr, first, arr0,  first - space/2 - 1, space - first + 1);
            this.space = space/2;
            this.arr = arr0;
            this.first = first - space/2 - 1;
        } else {
            Item[] arr0 = (Item[]) new Object[space/2];
            System.arraycopy(arr, first, arr0, first, last - first + 1 );
            this.arr = arr0;
        }
    }


    public void addFirst(Item m) {
        if (isEmpty()) {
            arr[0] = m;
        } else if (first == 0) {
                first = space - 1;
                arr[first] = m;
        } else {
            first = first - 1;
            arr[first] = m;
        }
        size += 1;
        if ((double)size / space > 0.85) {
            this.moveBig();
        }
    }

    public void addLast(Item m){
        if (isEmpty()) {
            arr[0] = m;
        } else if (last == space - 1) {
            last = 0;
            arr[0] = m;
        } else {
            last = last + 1;
            arr[last] = m;
        }
        size += 1;
        if ((double)size / space > 0.85) {
            moveBig();
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    public void printDeque(){
        if (first <= last) {
            if (isEmpty()) {
                System.out.println("Empty queue!");
            } else {
                for (int i = first; i <= last; i++) {
                    System.out.print(arr[i]);
                    System.out.print("\t");
                }
            }
        } else {
            for (int i = first; i < space; i++) {
                System.out.print(arr[i]);
                System.out.print("\t");
            }
            for (int i = 0; i <= last; i++) {
                System.out.print(arr[i]);
                System.out.print("\t");
            }
        }
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            Item m = arr[first];
            this.clear();
            return m;
        } else {
            Item m = arr[first];
            if (first == space - 1) {
                first = 0;
            } else {
                first = first + 1;
            }
            if (size != 0) {
                size -= 1;
            }
            if ((double)size / (double)space <= 0.45 && size > 8) {
                this.moveSmall();
            }
            return m;
        }
    }
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            Item m = arr[first];
            this.clear();
            return m;
        } else {
            Item m = arr[last];
            if (last == 0) {
                last = space - 1;
            } else {
                last = last - 1;
            }
            if (size != 0) {
                size -= 1;
            }
            if ((double)size / (double)space <= 0.45 && size > 8) {
                this.moveSmall();
            }
            return m;
        }
    }
    public Item get(int index){
        if (index < 0 || index >= size ) {
            return null;
         } else {
            if (first <= last ) {
                return arr[first + index];
            }
            else {
                if (first + index <= space - 1) {
                    return arr[first + index];
                } else {
                    return arr[first + index - space];
                }
            }
        }
    }
}
