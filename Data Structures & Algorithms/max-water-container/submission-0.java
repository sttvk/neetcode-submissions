class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;

        while (l < r) {
            int shorter = Math.min(heights[l], heights[r]);
            int area = shorter * (r - l);

            maxArea = Math.max(maxArea, area);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
