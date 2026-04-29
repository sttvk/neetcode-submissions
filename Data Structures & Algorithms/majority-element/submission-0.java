class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0;
        int cnt = 0;
        
        for (int num : nums) {
            if (cnt == 0) {
                maj = num;
            }

            if (num == maj) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return maj;
    }
}