class Solution {
    public boolean isHappy(int n) {
        int hare = n;
        int tortoise = n;
        while(true){
            tortoise = sumOfSquares(tortoise);
            hare = sumOfSquares(sumOfSquares(hare));
            if(hare == 1) return true;
            if(hare == tortoise) return tortoise == 1;
        }
    }
    private int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum = sum + digit * digit;
            n = n / 10;
        }
    return sum;
    }
}