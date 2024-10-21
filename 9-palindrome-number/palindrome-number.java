class Solution {
    public boolean isPalindrome(int x) {

        if(x<0){
            return false;
        }
        long reverse = 0;
        long temp = x;

        while(temp!=0){
            int digit = (int) (temp%10);
            reverse = reverse * 10 + digit;
            temp = temp/10;
        }

        return (reverse == x);
        
    }
}