// class Solution {
//     public int minimumRecolors(String blocks, int k) {
//         //int min = 0;
//         int count = 0;
//         int[] arr = new int[blocks.length()-k+1];

//         for(int i = 0; i <= blocks.length() - k; i++){
            
//             for(int j = i; j < i + k ; j++){
//                 if(blocks.charAt(j) == 'W'){
//                     count++;
//                 }
//             }
//             arr[i] = count;
//             count = 0;
//         }

//         return Arrays.stream(arr).min().getAsInt();
        
//     }
// }

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int opr=0, n=blocks.length(), ans;
        for(int i=0; i<k; i++){
            if(blocks.charAt(i)=='W') opr++;
        }
        ans=opr;
        for(int i=k; i<n; i++){
            if(blocks.charAt(i-k)!=blocks.charAt(i)){
                if(blocks.charAt(i-k)=='W') opr--;
                else opr++;
            }
            if(ans>opr) {
                ans=opr;
                if(ans==0) return ans;
            }
        }
        return ans;
    }
}