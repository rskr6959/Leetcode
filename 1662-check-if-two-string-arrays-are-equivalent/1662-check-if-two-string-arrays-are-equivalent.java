class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int left = 0;
        int right = 0;
        int p = 0;
        int q = 0;
        while(left < word1.length && right < word2.length){
            if(word1[left].charAt(p) != word2[right].charAt(q)){
                return false;
            }
            p++;
            q++;
            if(p == word1[left].length()){
                left++;
                p = 0;
            }
            if( q == word2[right].length()){
                right++;
                q = 0;
            }
        }
    return (left == word1.length && right == word2.length);
    }
}