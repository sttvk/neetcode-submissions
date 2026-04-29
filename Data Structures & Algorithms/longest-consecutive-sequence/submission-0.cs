public class Solution {
    public int LongestConsecutive(int[] nums) {
        var set = new HashSet<int>(nums);
        int longest = 0;

        foreach (var num in set) {
            if (!set.Contains(num - 1)) {
                int len = 1;

                while (set.Contains(num + len)) {
                    len++;
                }

                longest = Math.Max(longest, len);
            }
        }

        return longest;
    }
}
