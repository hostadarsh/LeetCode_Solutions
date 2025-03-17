// class Solution {
//     public boolean divideArray(int[] nums) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         for(int i:nums){
//             if(map.containsKey(i)){
//                 map.put(i,map.get(i)+1);
//             }
//             else map.put(i,1);
//         }       

//         for(Map.Entry<Integer,Integer>entry:map.entrySet()){
//             if(entry.getValue()%2!=0) return false;
//         }

//         return true;
//     }
// }

class Solution {
    public boolean divideArray(int[] nums) {

        int[] arr = new int[501];

        for(int a : nums){
            arr[a]++;
        }
        
        for(int i = 1; i<arr.length; i++){
            if(arr[i]%2 != 0){
                return false;
            }
        }
        return true;

    }
}