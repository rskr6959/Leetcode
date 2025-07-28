class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length ; i = i+3){
            if(nums[i] != nums[i-1]){
                int ans = nums[i-1];
                return ans;
            }
        }
    return nums[nums.length-1]; 
    }
}