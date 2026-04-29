public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        var map = new Dictionary<int, int>();
        foreach (var num in nums) {
            map[num] = map.GetValueOrDefault(num, 0) + 1;
        }

        var minHeap = new PriorityQueue<int, int>();
        foreach (var key in map.Keys) {
            minHeap.Enqueue(key, map[key]);

            if (minHeap.Count > k) {
                minHeap.Dequeue();
            }
        }

        var res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.Dequeue();
        }

        return res;
    }
}
