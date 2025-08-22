class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        int left = 0;
        boolean flag = true;
        while(left < s.length()){
            char chS = s.charAt(left);
            char chT = t.charAt(left);
            if(mapS.containsKey(chS)){
                if(mapS.get(chS) != chT){
                    flag = false;
                }
            }
            else mapS.put(chS, chT);
            if(mapT.containsKey(chT)){
                if(mapT.get(chT) != chS){
                    flag = false;
                }
            }
            else mapT.put(chT, chS);
            left++;
        }
    return (flag == true) ? true : false; 
    }
}