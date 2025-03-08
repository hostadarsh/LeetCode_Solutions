class Solution {
    public int minimumRecolors(String blocks, int k) {
        //int min = 0;
        int count = 0;
        int[] arr = new int[blocks.length()-k+1];

        for(int i = 0; i <= blocks.length() - k; i++){
            
            for(int j = i; j < i + k ; j++){
                if(blocks.charAt(j) == 'W'){
                    count++;
                }
            }
            arr[i] = count;
            count = 0;
        }

        return Arrays.stream(arr).min().getAsInt();
        
    }
}