class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> res = new ArrayList<>();
        while(left < n1 && right < n2){
            if(nums1[left] == nums2[right]){
            res.add(nums1[left]);
            left++;
            right++;
            }
            else if(nums1[left] < nums2[right]){
            left++;
            }
            else{
            right++;
            }
        }
    int[] result = new int[res.size()];
    int i = 0;
    for(int num : res){
        result[i++] = num;
    }
    return result;
    }
}
