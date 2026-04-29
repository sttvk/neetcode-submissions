class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = this.tail = new Node(-1);
    }

    public int get(int index) {
        Node cur = head.next;

        int i = 0;
        while (cur != null && i < index) {
            i++;
            cur = cur.next;
        }

        return cur != null ? cur.val : -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;

        if (node.next == null) {
            tail = node;
        }
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public boolean remove(int index) {
        int i = 0;
        Node cur = head;
        while (i < index && cur != null) {
            i++;
            cur = cur.next;
        }

        if (cur != null && cur.next != null) {
            if (cur.next == tail) {
                tail = cur;
            }

            cur.next = cur.next.next;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();

        Node cur = head.next;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }

        return res;
    }
}
