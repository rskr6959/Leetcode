class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] map = new int[26];

        while(right < s.length()){
            map[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, map[s.charAt(right) - 'A']);
            while((right - left + 1) - maxFreq > k){
                map[s.charAt(left) - 'A']--;
                maxFreq = 0;
                for(int i = 0; i < 26; i++){
                    maxFreq = Math.max(maxFreq, map[i]);
                }
                left++;
            }
            if((right - left + 1) - maxFreq <= k)
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

       return maxLen; 
    }
}