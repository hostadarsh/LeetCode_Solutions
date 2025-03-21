// class Solution {
//     public List<List<Integer>> threeSum(int[] arr) {
//         Set<List<Integer>> st = new HashSet<>();

//         for(int i = 0; i < arr.length ; i++){
//             for(int j = i + 1 ; j < arr.length ; j++){
//                 for(int k = j + 1; k < arr.length ; k++){
//                     if(arr[i] + arr[j] + arr[k] == 0){
//                         List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
//                         temp.sort(null);
//                         st.add(temp);
//                     }
//                 }
//             }
//         }
//         //List<List<Integer>> ans = new ArrayList<>(st);
//         return new ArrayList<>(st);

//     }
// }




// class Solution {
//     public List<List<Integer>> threeSum(int[] arr) {

//         int count = 0;
//         for(int n : arr){
//         if(n == 0){
//             count++;
//         }
//         if(count == arr.length){
//             List<List<Integer>> ans1 = new ArrayList<>();
//             ans1.add(Arrays.asList(0,0,0));
//             return ans1;
//         }
//         }

//         Set<List<Integer>> st = new HashSet<>();

//         for(int i = 0; i < arr.length; i++ ){

//             Set<Integer> hashset = new HashSet<>();

//             for(int j = i+1; j < arr.length; j++){
//                 int third = -(arr[i] + arr[j]);

//                 if(hashset.contains(third)){
//                     List<Integer> temp = new ArrayList<>();
//                     temp = Arrays.asList(arr[i],arr[j],third);
//                     temp.sort(null);
//                     st.add(temp);
//                 }   
//                 hashset.add(arr[j]);             
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>(st);
//         return ans;

//     }
// }



class Solution {
    public List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);

        for(int i = 0 ; i< arr.length; i++){
            if(i != 0 && arr[i] == arr[i-1]){
                continue;
            }

            int j = i+1;
            int k = arr.length -1;

            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];

                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1]){
                        j++;
                    }
                    while(j<k && arr[k] == arr[k+1]){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}