// class Solution {
//     public int numOfStrings(String[] patterns, String word) {
        
//         int count = 0;
//         for(String s : patterns){
//             if(word.contains(s)){
//                 count++;
//             }
//         }

//         return count;
//     }
// }

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        
        int count = 0;
        for(int i = 0; i < patterns.length; i++){
            if(word.contains(patterns[i])){
                count++;
            }
        }

        return count;
    }
}