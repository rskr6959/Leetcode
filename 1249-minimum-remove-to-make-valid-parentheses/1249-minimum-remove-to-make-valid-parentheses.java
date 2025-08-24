class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(int i = 0; i <s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                sb.append(ch);
            }
            else if(ch == ')'){
                if(open > 0){
                    open--;
                    sb.append(ch);
                }
            }
            else{
                sb.append(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = sb.length() - 1 ; i >=0 ; i--){
            char ch = sb.charAt(i);
            if(ch == '(' && open > 0){
                open--;
            }
            else{
            result.append(ch);
            }
        }
    return result.reverse().toString();
    }
}
    //     Stack<Integer> st = new Stack<>();
    //     Set<Integer> remove = new HashSet<>();
    //     for(int i = 0; i < s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(ch == '('){
    //             st.push(i);
    //         }
    //         else if(ch == ')'){
    //             if(!st.isEmpty()){
    //                 st.pop();
    //             }
    //             else{
    //                 remove.add(i);
    //             }
    //         }
    //     }
    //     while(!st.isEmpty()){
    //         remove.add(st.pop());
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = 0 ; i < s.length(); i++){
    //         if(!remove.contains(i)){
    //             sb.append(s.charAt(i));
    //         }
    //     }
    // return sb.toString();        
    // }
// }