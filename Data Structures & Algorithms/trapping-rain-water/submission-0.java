class Solution {
    public int trap(int[] height) {
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int k = 0; k < i; k++) {
                leftMax = Math.max(leftMax, height[k]);
            }
            
            for (int k = i + 1; k < height.length; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }

            res += Math.min(leftMax, rightMax) - height[i];
        }

        return res;
    }
}
