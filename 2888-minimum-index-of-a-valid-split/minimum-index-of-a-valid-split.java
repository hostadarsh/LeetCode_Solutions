// class Solution {
//     public int minimumIndex(List<Integer> list) {
//         int n = list.size();
//         int max = Integer.MIN_VALUE;
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (count == 0)
//                 max = list.get(i);
//             if (max == list.get(i))
//                 count++;
//             else
//                 count--;
//         }
//         count = 0;
//         for (int num : list) {
//             if (num == max)
//                 count++;
//         }
//         if (count <= (n - count) + 1)
//             return -1;

//         count = 0;
//         for (int i = 0; i < n; i++) {
//             if (list.get(i) == max)
//                 count++;
//             else
//                 count--;
//             if (count == 1)
//                 return i;
//         }
//         return -1;
//     }
// }


class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        int dominant=-1;
        int cnt=0;

        for(int i=0;i<n;i++){
            if(cnt==0){
                dominant=nums.get(i);
                cnt++;
            }
            else if(nums.get(i)==dominant){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int maxC=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==dominant){
                maxC++;
            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==dominant){
                c++;
            }
            if(c*2>(i+1) && (maxC-c)*2>(n-i-1)){
                return i;
            }
        }
        return -1;
    }
}