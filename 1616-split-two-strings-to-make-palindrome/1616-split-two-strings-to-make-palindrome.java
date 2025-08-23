class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(a.length() == 1) return true;
        return (check(a, b) || check(b, a));
    }
    private boolean check(String x, String y){
        int aPtr = 0;
        int bPtr = y.length() - 1;
        while(aPtr < bPtr && x.charAt(aPtr) == y.charAt(bPtr)){
            aPtr++;
            bPtr--;
        }
        return (isPalindrome(x, aPtr, bPtr) || isPalindrome(y, aPtr, bPtr));
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
        if(s.charAt(left) != s.charAt(right)){
            return false;
        }
        left++;
        right--;
        }
        return true;
    }

}