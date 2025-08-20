class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = -1;
        for(int j = 0; j < n; j++){
            if(nums[j] == 0){
                i = j;
                break;
            } 
        }
        if(i == -1) return;
        for(int j = i + 1; j < n ; j++){
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}