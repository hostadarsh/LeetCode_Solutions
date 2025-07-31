// import java.util.HashSet;
// import java.util.Set;

// class Solution {
//     public int subarrayBitwiseORs(int[] arr) {
//         Set<Integer> resultOrs = new HashSet<>();
//         Set<Integer> currentOrs = new HashSet<>();

//         for (int x : arr) {
//             Set<Integer> nextOrs = new HashSet<>();
//             nextOrs.add(x);

//             for (int y : currentOrs) {
//                 nextOrs.add(x | y);
//             }
//             resultOrs.addAll(nextOrs);
//             currentOrs = nextOrs;
//         }

//         return resultOrs.size();
//     }
// }


class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            result.add(arr[i]);
            for(int j=i-1;j>=0;j--){
                if(arr[j]==(arr[j] | arr[i])) break;
                arr[j]|=arr[i];
                result.add(arr[j]);
            }
        }
        return result.size();
    }
}