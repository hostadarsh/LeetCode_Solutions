class Solution {
    public int totalWaviness(int num1, int num2) {
        
        int count = 0;

        for(int j = num1; j <= num2; j++){
            String str = String.valueOf(j);

            for(int i = 1; i < str.length() - 1; i++){
                int digit = str.charAt(i) - '0';
                int prevDigit = str.charAt(i-1) - '0';
                int nextDigit = str.charAt(i+1) - '0';

                if(digit < prevDigit && digit < nextDigit || digit > prevDigit && digit > nextDigit){
                    count++;
                }
            }
        }

        return count;
    }
}