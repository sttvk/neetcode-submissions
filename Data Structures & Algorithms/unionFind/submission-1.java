class UnionFind {
    int[] parent;
    int[] size;
    int numComponents;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        numComponents = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        // Finds the root of x
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        // Connects x and y
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            numComponents--;
            return true;
        }
        return false;
    }

    public int getNumComponents() {
        return numComponents;
    }
}
