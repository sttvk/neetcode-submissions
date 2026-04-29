class Node {
    int key;
    int val;
    Node left;
    Node right;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        left = null;
        right = null;
    }
}

class TreeMap {
    Node root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        root = insert(key, val, root);
    }

    private Node insert(int key, int val, Node node) {
        if (node == null) {
            return new Node(key, val);
        }

        if (key < node.key) {
            node.left = insert(key, val, node.left);
        } else if (key > node.key) {
            node.right = insert(key, val, node.right);
        } else {
            node.val = val;
        }
        return node;
    }

    public int get(int key) {
        return get(key, root);
    }

    private int get(int key, Node node) {
        if (node == null) {
            return -1;  // or throw an exception
        }

        if (key == node.key) {
            return node.val;
        }

        if (key < node.key) {
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }

    public int getMin() {
        return getMin(root);
    }

    private int getMin(Node node) {
        if (node == null) {
            return -1;  // or throw an exception
        }

        if (node.left == null) {
            return node.val;
        }

        return getMin(node.left);
    }

    public int getMax() {
        return getMax(root);
    }

    private int getMax(Node node) {
        if (node == null) {
            return -1;  // or throw an exception
        }

        if (node.right == null) {
            return node.val;
        }

        return getMax(node.right);
    }

    public void remove(int key) {
        root = remove(key, root);
    }

    private Node remove(int key, Node node) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = remove(key, node.left);
        } else if (key > node.key) {
            node.right = remove(key, node.right);
        } else {
            // Node to be removed found
            if (node.left == null) {
                return node.right;  // Only right child
            } else if (node.right == null) {
                return node.left;  // Only left child
            } else {
                // Node with two children
                Node minNode = getMinNode(node.right);  // Find min node in the right subtree
                node.key = minNode.key;
                node.val = minNode.val;
                node.right = remove(minNode.key, node.right);  // Remove the min node in the right subtree
            }
        }

        return node;
    }

    private Node getMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<>();
        getInorderKeys(root, res);
        return res;
    }

    private void getInorderKeys(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }

        getInorderKeys(node.left, res);
        res.add(node.key);
        getInorderKeys(node.right, res);
    }
}