class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return (numSubarraysWithSumLTEGoal(nums, goal) - numSubarraysWithSumLTEGoal(nums, goal - 1));
    }
    private int numSubarraysWithSumLTEGoal(int[] nums, int goal){
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        if(goal < 0) return 0;
        while(right < nums.length){
            sum = sum + nums[right];
            while(sum > goal){
                sum = sum - nums[left];
                left++;
            }
            count = count + (right - left + 1);
            right++;
        }
        return count;
    }
}