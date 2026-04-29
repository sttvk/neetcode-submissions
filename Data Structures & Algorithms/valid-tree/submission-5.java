class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return true;
        }

        if (n == 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int row = 0; row < n; row++) {
            graph.put(row, new HashSet<>());
        }

        for (int row = 0; row < edges.length; row++) {
            int src = edges[row][0];
            int des = edges[row][1];

            graph.get(src).add(des);
            graph.get(des).add(src);
        }
        
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        int count = 0;
        for (int src : graph.keySet()) {
            if (visited.contains(src)) {
                continue;
            }

            count++;
            stack.push(src);

            while (!stack.isEmpty()) {
                int v = stack.pop();
                if (visited.contains(v)) {
                    return false;
                }

                visited.add(v);
                for (int nbr : graph.get(v)) {
                    if (!visited.contains(nbr)) {
                        stack.push(nbr);
                    }
                }
            }
        }

       return count == 1;
    }
}














