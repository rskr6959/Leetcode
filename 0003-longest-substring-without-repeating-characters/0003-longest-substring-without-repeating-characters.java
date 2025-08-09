class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, - 1);
        int n = s.length();
        while(right < n){
            char ch = s.charAt(right);
            if(hash[ch] >= left){
                left = hash[ch] + 1;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            hash[ch] = right;
            right++;
        }
        return maxLen;
    }
}
