public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int,int> hm = new Dictionary<int,int>();
        int firstIndex=-1;
        int secondIndex=-1;
        int diff;
        for(int i=0;i<nums.Length; i++){
            diff = target - nums[i];
            if(hm.ContainsKey(diff)){
                firstIndex = Array.IndexOf(nums,diff);
                secondIndex = i;
                break;
            }else{
                hm.Add(nums[i],1);
            }
        }
        return new int[]{firstIndex,secondIndex};
    }
}
