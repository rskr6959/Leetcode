class Solution {
    public boolean isValid(String s) {
        Stack<Character> pars = new Stack<>();
        HashMap<Character, Character> lookup = new HashMap<>();
        lookup.put('}', '{');
        lookup.put(')', '(');
        lookup.put(']', '[');
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(lookup.containsKey(ch)){
                if(!pars.isEmpty() && lookup.get(ch) == pars.peek()){
                    pars.pop();
                }
                else{
                return false;
                }
            }
            else{
                pars.push(ch);
            }
        }
return pars.isEmpty();
    } 
}