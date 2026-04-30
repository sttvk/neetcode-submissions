class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min) {
        this.val = val;
        this.min = min;
        this.next = null;
    }
}

class MinStack {
    Node top;

    public MinStack() {
        this.top = null;
    }
    
    public void push(int val) {
        if (top == null) {
            top = new Node(val, val);
        } else {
            Node node = new Node(val, Math.min(val, top.min));
            node.next = top;
            top = node;
        }
    }
    
    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }
    
    public int top() {
        return top != null ? top.val : -1;
    }
    
    public int getMin() {
        return top != null ? top.min : -1;
    }
}