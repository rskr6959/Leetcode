class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length){
            sum = sum + nums[right];
            while(sum >= target){
                minLen = Math.min((right - left + 1), minLen);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}