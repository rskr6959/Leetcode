class Solution {
    public int removeDuplicates(int[] nums) { 
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            while(j < nums.length && nums[i] == nums[j]){
                j++;
            }
            if(j < nums.length) nums[++i] = nums[j];
        }
    return i + 1;
    //     int n = nums.length;
    //     int i = 0;
    //     for(int j = 1; j<n; j++){
    //         if(nums[i] != nums[j]){
    //             nums[i+1] = nums[j];
    //             i++;
    //         }
    //     }
    // return i+1; 
    // }
}
}