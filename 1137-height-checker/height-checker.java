class Solution {
    public int heightChecker(int[] heights) {
        int count = 0;
        int[] sarr = heights.clone();
        //sarr = heights;
        Arrays.sort(sarr);
        for(int i = 0 ; i< heights.length; i++){
            if(heights[i] != sarr[i]){
                count++;
            }
        }
        return count;
    }
}