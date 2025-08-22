class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> result = new ArrayList<>();
        if(pLen > sLen) return result;
        int left = 0;
        int right = 0;
        int[] pCount = new int[26];
        int[] window = new int[26];
        for(char ch : p.toCharArray()){
            pCount[ch - 'a']++;
        }
        while(right < sLen){
            window[s.charAt(right) - 'a']++;
            if((right - left + 1) > pLen){
                window[s.charAt(left) - 'a']--;
                left++;
            }
            if((right - left + 1) == pLen && Arrays.equals(pCount, window)){
                result.add(left);
            }
            right++;
        }
        return result;
    }
}