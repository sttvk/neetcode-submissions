class Solution {
    public Map<Integer, Integer> shortestPath(int numVertices, List<List<Integer>> edges, int src) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < numVertices; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int s = edge.get(0);
            int d = edge.get(1);
            int w = edge.get(2);

            graph.get(s).add(new int[] { d, w });
        }

        HashMap<Integer, Integer> shortestPathMap = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        minHeap.offer(new int[] { src, 0 });

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int dst = cur[0];
            int wgt = cur[1];

            if (shortestPathMap.containsKey(dst)) {
                continue;
            }

            shortestPathMap.put(dst, wgt);

            for (int[] edge : graph.get(dst)) {
                int ndst = edge[0];
                int nwgt = edge[1];

                if (!shortestPathMap.containsKey(ndst)) {
                    minHeap.offer(new int[] { ndst, wgt + nwgt });
                }
            }
        }

        for (int i = 0; i < numVertices; i++) {
            shortestPathMap.putIfAbsent(i, -1);
        }

        return shortestPathMap;
    }  
}
