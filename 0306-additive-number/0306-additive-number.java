class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i <= num.length() - 2; i++){
            for(int j = i+1; j <= num.length() - 1; j++){
                String first = num.substring(0, i);
                String second = num.substring(i, j);
                if(first.length() > 1 && first.charAt(0) == '0' || second.length() > 1 && second.charAt(0) == '0'){
                    continue;
                }
                if(isValid(first, second, num.substring(j))){
                    return true;
                }
            }
        }
    return false; 
    }
    private boolean isValid(String first, String second, String rest){
        while(!rest.isEmpty()){
            String sum = addStrings(first, second);
            if(!rest.startsWith(sum)) return false;

            first = second;
            second = sum;
            rest = rest.substring(sum.length());
        }
    return true;
    }
    private String addStrings(String a, String b){
        int i = a.length() - 1; 
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0 || carry > 0){
            int pre1 = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int pre2 = (j >= 0) ? b.charAt(j--) - '0' : 0;
            int sum = pre1 + pre2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
    return sb.reverse().toString();
    }
}