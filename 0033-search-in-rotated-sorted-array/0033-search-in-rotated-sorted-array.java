class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) 
        return (nums[0] == target) ? 0 : -1;
        int start = 0;
        int end = nums.length - 1;
        String region;
        if(target == nums[end])
        return end;
        else if(target > nums[end])
        region = "green";
        else
        region = "orange";
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(nums[mid] > nums[nums.length - 1] && region.equals("orange")){
                start = mid + 1;
            }
            else if(nums[mid] <= nums[nums.length - 1] && region.equals("green")){
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
    return -1;
    }
}
