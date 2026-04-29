class FileSystem {
    class Node {
        boolean isFile = false;
        StringBuilder content = new StringBuilder();
        Map<String, Node> children = new TreeMap<>();
    }

    Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        Node cur = root;
        List<String> res = new ArrayList<>();

        if (!path.equals("/")) {
            String[] parts = path.split("/");
            for (int i = 1; i < parts.length; i++) {
                cur = cur.children.get(parts[i]);
            }

            if (cur.isFile) {
                res.add(parts[parts.length - 1]);
                return res;
            }
        }

        res.addAll(cur.children.keySet());
        return res;
    }
    
    public void mkdir(String path) {
        Node cur = root;
        String[] parts = path.split("/");

        for (int i = 1; i < parts.length; i++) {
            if (!cur.children.containsKey(parts[i])) {
                cur.children.put(parts[i], new Node());
            }

            cur = cur.children.get(parts[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur = root;
        String[] parts = filePath.split("/");
        String fileName = parts[parts.length - 1];

        for (int i = 1; i < parts.length - 1; i++) {
            cur = cur.children.get(parts[i]);
        }

        if (!cur.children.containsKey(fileName)) {
            Node node = new Node();
            node.isFile = true;
            cur.children.put(fileName, node);
        }

        Node node = cur.children.get(fileName);
        node.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        Node cur = root;
        String[] parts = filePath.split("/");
        String fileName = parts[parts.length - 1];

        for (int i = 1; i < parts.length - 1; i++) {
            cur = cur.children.get(parts[i]);
        }

        Node node = cur.children.get(fileName);
        return node.content.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
