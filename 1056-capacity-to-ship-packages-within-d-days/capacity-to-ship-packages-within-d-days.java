class Solution {

    public boolean isCapacity(int[] weights, int days, int capacity){
        int countCap = 0, countDays = 1;

        for(int i : weights){
            if(countCap + i <= capacity){
                countCap += i;
            }
            else{
                countDays++;
                countCap=i;
            }
        }

        return countDays<=days;
    }



    public int shipWithinDays(int[] weights, int days) {
        
        int high = 0;
        int low = Integer.MIN_VALUE;

        for(int n : weights){
            low = Math.max(low,n);
            high += n;
        }

        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isCapacity(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return ans;

    }
}