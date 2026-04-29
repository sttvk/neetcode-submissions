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
        this.head = this.tail = null;
    }

    public int get(int index) {
        Node curr = head;
        for (int i = 0; i < index && curr != null; i++) {
            curr = curr.next;
        }

        return curr != null ? curr.val : -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(int index) {
        if (index == 0 && head != null) {
            head = head.next;
            return true;
        }

        Node curr = head;
        for (int i = 1; i < index && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr;
            }

            curr.next = curr.next.next;
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();

        for (Node curr = head; curr != null; curr = curr.next) {
            res.add(curr.val);
        }

        return res;
    }
}
