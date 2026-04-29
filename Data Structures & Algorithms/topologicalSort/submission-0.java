class Solution {
    Map<Integer, List<Integer>> graph;
    List<Integer> result;

    public List<Integer> topologicalSort(int n, int[][] edges) {
        this.graph = new HashMap<>();
        this.result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];

            graph.get(src).add(dst);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!dfs(i, visiting, visited)) {
                return new ArrayList<>();
            }
        }

        Collections.reverse(result);
        return result;
    }

    private boolean dfs(int node, Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(node)) {
            return false;
        }

        if (visited.contains(node)) {
            return true;
        }

        visiting.add(node);

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, visiting, visited)) {
                return false;
            }
        }

        visiting.remove(node);
        visited.add(node);
        result.add(node);

        return true;
    }
}






















