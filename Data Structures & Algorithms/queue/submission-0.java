class Node {
    int val;
    Node next;
    Node prev;

    public Node (int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    Node head;
    Node tail;
    int size;

    public Deque() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void append(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size++;
    }

    public void appendleft(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        size++;
    }

    public int pop() {
        if (head == null) {
            return -1;
        } 
         
        Node temp = tail;
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = tail = null;
        }
        
        size--;
        return temp.val;
    }

    public int popleft() {
        if (head == null) {
            return -1;
        } 

        Node temp = head;
        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = tail = null;
        }

        size--;
        return temp.val;
    }
}
