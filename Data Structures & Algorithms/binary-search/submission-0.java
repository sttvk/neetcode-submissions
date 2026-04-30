class Solution {
    private int bSearch(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            return bSearch(nums, target, m + 1, r);
        } else {
            return bSearch(nums, target, l, m - 1);
        }
    }

    public int search(int[] nums, int target) {
        return bSearch(nums, target, 0, nums.length - 1);
    }
}
