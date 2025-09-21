class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < n; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
    return maxSum; 
    }
}