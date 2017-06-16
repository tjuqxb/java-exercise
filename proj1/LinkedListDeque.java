/**
 * Created by 17663 on 2017/6/12.
 */
public class LinkedListDeque<Item> {
    public IntNode node;
    public int size = 0;
    public IntNode nodeEnd;

    public class IntNode {
        public IntNode head;
        public Item val;
        public IntNode tail;
        public IntNode(IntNode head0, Item value0, IntNode tail0) {
            this.head = head0;
            this.val = value0;
            this.tail = tail0;

        }
        public IntNode() {
            this.head = null;
            this.val = null;
            this.tail = null;
        }

    }

    public LinkedListDeque() {
        this.node = new IntNode();
        this.nodeEnd = this.node;
    }
    public void addFirst(Item m) {
        IntNode mNode = new IntNode(null, m, null);
        if (this.node.tail == null) {
            this.node.tail = mNode;
            mNode.head = this.node;
            this.nodeEnd = mNode;
        } else {
            IntNode p = this.node.tail;
            this.node.tail = mNode;
            mNode.head = this.node;
            mNode.tail = p;
            p.head = mNode;
        }
        this.size += 1;
    }

    public void addLast(Item m) {
        IntNode mNode = new IntNode(null, m, null);
        this.nodeEnd.tail = mNode;
        mNode.head = this.nodeEnd;
        this.nodeEnd = mNode;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.node.tail == null;
    }

    public int size() {
        return this.size;
    }

    private void printNode(IntNode m) {
        if (m.tail == null) {
            System.out.println(m.val);
        } else {
            System.out.println(m.val);
            printNode(m.tail);
        }
    }
    public void printDeque() {
        if (this.node.tail == null) {
            System.out.println("Empty Queue!");
        } else {
            printNode(this.node.tail);
        }
    }
    public Item removeFirst() {
        if (this.node.tail == null) {
            return null;
        } else {
            Item m = this.node.tail.val;
            IntNode p = this.node;
            if (p.tail.tail == null) {
                p.tail = null;
                this.nodeEnd = p;
            } else {
                p.tail.tail.head = p;
                p.tail = p.tail.tail;
            }
            return m;
        }
    }
    public Item removeLast() {
        if (this.node.tail == null) {
            return null;
        } else {
            Item m = this.nodeEnd.val;
            this.nodeEnd.head.tail = null;
            this.nodeEnd = this.nodeEnd.head;
            size -= 1;
            return m;
        }
    }

    public Item get(int index) {
        if (this.node.tail == null) {
            return null;
        } else {
            IntNode p = this.node;
            while (index != 0) {
                p = p.tail;
                index = index - 1;
            }
            return p.val;
        }
    }

    private  Item getRe(int index, IntNode m){
        if (index < 0 || index > this.size - 1){
            return null;
        } else {
            if (index == 0) {
                return m.val;
            } else {
               return getRe(index-1, m.tail);
            }
        }
    }
    public Item getRecursive(int index){
        if (this.node.tail == null) {
            return null;
        } else {
            return getRe(index, this.node.tail);
        }

    }
}
