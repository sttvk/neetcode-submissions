class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        List<Integer[]> memo = new ArrayList<>();
        for (int row = 0; row < profit.size(); row++) {
            memo.add(row, new Integer[capacity + 1]);
            Arrays.fill(memo.get(row), -1);
        }

        return dfs(0, profit, weight, capacity, memo);
    }

    private int dfs(int idx, List<Integer> profit, 
                        List<Integer> weight, int capacity, List<Integer[]> memo) {
        if (idx == profit.size()) {
            return 0;
        }

        if (memo.get(idx)[capacity] != -1) {
            return memo.get(idx)[capacity];
        }

        // Skip the item
        memo.get(idx)[capacity] = dfs(idx + 1, profit, weight, capacity, memo);

        // Include the item
        int newCapacity = capacity - weight.get(idx);
        if (newCapacity >= 0) {
            int p = profit.get(idx) + dfs(idx + 1, profit, weight, newCapacity, memo);
            memo.get(idx)[capacity] = Math.max(memo.get(idx)[capacity], p);
        }

        return memo.get(idx)[capacity];
    }
}
