class Graph {
    HashMap<Integer, HashSet<Integer>> graph;

    public Graph() {
        graph = new HashMap<>(); 
    }

    public void addEdge(int src, int dst) {
        if (!graph.containsKey(src)) {
            graph.put(src, new HashSet<>());
        }

        if (!graph.containsKey(dst)) {
            graph.put(dst, new HashSet<>());
        }
    
        graph.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graph.containsKey(src) || !graph.get(src).contains(dst)) {
            return false;
        }

        graph.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        // HashSet<Integer> visited = new HashSet<>();
        // return dfs(src, dst, visited);
        return bfs(src, dst);
    }

    private boolean dfs(int src, int dst, HashSet<Integer> visited) {
        if (src == dst) {
            return true;
        }

        visited.add(src);
        
        for (int neighbor : graph.getOrDefault(src, new HashSet<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, dst, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(int src, int dst) {
        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(src);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dst) {
                return true;
            }

            visited.add(curr);
            for (int neighbor : graph.getOrDefault(curr, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }
}
