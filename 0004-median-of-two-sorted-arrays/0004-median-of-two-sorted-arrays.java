class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
        return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        while(low <= high){
            int cutA = (low + high) / 2;
            int cutB = (n1 + n2 + 1) / 2 - cutA;
            int leftA = (cutA == 0) ? Integer.MIN_VALUE : nums1[cutA - 1];
            int rightA = (cutA == n1) ? Integer.MAX_VALUE : nums1[cutA];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : nums2[cutB - 1];
            int rightB = (cutB == n2) ? Integer.MAX_VALUE : nums2[cutB];
            if(leftA <= rightB && leftB <= rightA){
                if ((n1 + n2) % 2 == 0){
                    int maxLeft = Math.max(leftA, leftB);
                    int minRight = Math.min(rightA, rightB);

                    return (maxLeft + minRight) / 2.0;
                }
                else{
                    return (double) Math.max(leftA, leftB);
                }
            }
            else if(leftA > rightB){
                    high = cutA - 1;
                }
            else{
                low = cutA + 1;
            }
       }
    return 0.0;
    }

}
