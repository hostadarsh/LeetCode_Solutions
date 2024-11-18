class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        int start = 0, end = 0;

        if(k == 0){
           //result = Arrays.stream(result).map(x -> 0).toArray();
            return result;
        }
        
        if(k > 0){
            start = 1;
            end = k;
        }
        else{
            start = n - Math.abs(k);     // instead we ca directly use (-k)
            end = n - 1;
        }

        int sum = 0;
        for(int i = start; i<= end; i++){
                sum = sum + code[i];
        }

        for(int i = 0; i < n; i++){
            result[i] = sum;

            sum = sum - code[(start)%n];
            sum = sum + code[(end+1)%n];
        
            start++;
            end++;
            
        }
        return result;

    }
}