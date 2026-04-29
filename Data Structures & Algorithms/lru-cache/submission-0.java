class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = next = null;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
    Node lru;
    Node mru; 

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        lru = new Node(0, 0);
        mru = new Node(0, 0);
        lru.next = mru;
        mru.prev = lru;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node target = lru.next;
            remove(target);
            cache.remove(target.key);
        }
    }

    private void insert(Node node) {
        Node last = mru.prev;
        last.next = node;
        node.prev = last;
        mru.prev = node;
        node.next = mru;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
