class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;
        int n = cardPoints.length;
        for(int i = 0; i <= k - 1; i++){
            leftSum = leftSum + cardPoints[i];
            maxSum = leftSum;
        }
        
        int right = n - 1;
        for(int i = k - 1; i >= 0; i--){
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[right];
            right--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}