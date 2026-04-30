class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            int len = 1;
            int nextNum = num + 1;

            while (set.remove(nextNum)) {
                len++;
                nextNum++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
