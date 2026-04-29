class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dst = edge.get(1);
            int wgt = edge.get(2);

            graph.get(src).add(new int[] { dst, wgt });
            graph.get(dst).add(new int[] { src, wgt });
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int[] neighbor : graph.get(0)) {
            int dst = neighbor[0];
            int wgt = neighbor[1];

            minHeap.add(new int[] { wgt, 0, dst });
        }

        int totalWgt = 0;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);

        while (seen.size() < n && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int wgt = cur[0];
            int src = cur[1];
            int dst = cur[2];

            if (seen.contains(dst)) {
                continue;
            }

            totalWgt += wgt;
            seen.add(dst);

            for (int[] pair : graph.get(dst)) {
                int ndst = pair[0];
                int nwgt = pair[1];

                if (!seen.contains(ndst)) {
                    minHeap.offer(new int[] { nwgt, dst, ndst });
                }
            }
        }

        return seen.size() == n ? totalWgt : -1;
    }   
}    
