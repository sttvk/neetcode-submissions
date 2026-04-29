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
        HashSet<Integer> visited = new HashSet<>();
        return dfs(src, dst, visited);
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
}
