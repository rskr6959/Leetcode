class Solution {
    public String minWindow(String s, String t) {
      int left = 0;
      int right = 0;
      int[] map = new int[256];
      Arrays.fill(map, 0);
      int start = -1;
      int count = 0;
      int minLen = Integer.MAX_VALUE;
      for(char ch : t.toCharArray()){
        map[ch]++;
      }
      while(right < s.length()){
        if(map[s.charAt(right)] > 0){
            count++;
        }
        map[s.charAt(right)]--;
        while(count == t.length()){
            if((right - left + 1) < minLen){
                minLen = right - left + 1;
                start = left;
            }
            map[s.charAt(left)]++;
            if(map[s.charAt(left)] > 0){
                count--;
            }
            left++;
        }
        right++;
      }
    return (start == -1) ? "" : s.substring(start, start + minLen);
    }
}