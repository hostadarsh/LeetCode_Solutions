class Solution {

    public long calculateHour(int[] piles, int speed){
        long totalH = 0;
        for(int banana : piles){
            totalH = totalH + (int)Math.ceil((double)banana/speed);
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = Arrays.stream(piles).max().getAsInt();

        int low = 1;
        int high = maxValue;
        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;

            long totalH = calculateHour(piles, mid);

            if(totalH<= h){
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