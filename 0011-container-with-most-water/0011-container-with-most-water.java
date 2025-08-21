class Solution {
    public int maxArea(int[] height) {
        int n = height.length - 1;
        int left = 0;
        int right = n;
        int max = 0;
        while(left < right){
            int width = right - left;
            int area = width * (Math.min(height[right], height[left]));
            max = Math.max(area, max);
            if(height[left] < height[right])
            left++;
            else
            right--;
        }
    return max;
    }
}
