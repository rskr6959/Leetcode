class Solution {
    public long wonderfulSubstrings(String word) {
        long ans = 0;
        int mask = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        for(char ch : word.toCharArray()){
            int bit = ch - 'a';
            int shift = 1 << bit;
            mask = mask ^ shift;
            ans = ans + freq.getOrDefault(mask, 0);
            for(int b = 0; b < 10; b++){
                int toggled = mask ^ (1 << b);
                ans = ans + freq.getOrDefault(toggled, 0);
            }
        freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }
    return ans;
    }
}