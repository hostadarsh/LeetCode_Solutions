class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        
            for(int num : piles){
                max = Math.max(max,num);
            }
          
        

        int low = 1;
        int high = max;

        while(low <= high){
            int mid = (low + high) / 2;

            int totalH = calculateTotalHours(piles,mid);

            if(totalH <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;        
    }
    
    public static int calculateTotalHours(int[] arr, int hourly){
        int totalH = 0;
        int n = arr.length;

        for(int i = 0 ; i < n; i++){
            totalH += Math.ceil((double)(arr[i])/(double)(hourly));
        }
        return totalH;
    }


}