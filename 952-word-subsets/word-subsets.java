// // class Solution {
// //     public List<String> wordSubsets(String[] words1, String[] words2) {
// //         int[] maxCharFreq = new int[26];
// //         int[] tempCharFreq = new int[26];

// //         for (String word : words2) {
// //             Arrays.fill(tempCharFreq, 0);
// //             for (char ch : word.toCharArray()) {
// //                 tempCharFreq[ch - 'a']++;
// //             }
// //             for (int i = 0; i < 26; ++i) {
// //                 maxCharFreq[i] = Math.max(maxCharFreq[i], tempCharFreq[i]);
// //             }
// //         }

// //         List<String> universalWords = new ArrayList<>();

// //         for (String word : words1) {
// //             Arrays.fill(tempCharFreq, 0);
// //             for (char ch : word.toCharArray()) {
// //                 tempCharFreq[ch - 'a']++;
// //             }

// //             boolean isUniversal = true;
// //             for (int i = 0; i < 26; ++i) {
// //                 if (maxCharFreq[i] > tempCharFreq[i]) {
// //                     isUniversal = false;
// //                     break;
// //                 }
// //             }
// //             if (isUniversal) {
// //                 universalWords.add(word);
// //             }
// //         }

// //         return universalWords;
// //     }
// // }

//  class Solution {
//      public List<String> wordSubsets(String[] words1, String[] words2) {
        
//         int[] maxCharFreq = new int[26];
//         int[] tempCharFreq = new int[26];

//         for(String word : words2){
//             Arrays.fill(tempCharFreq,0);
//             for(char ch : word.toCharArray()){
//                 tempCharFreq[ch - 'a']++;
//             }
//             for(int i = 0 ; i< 26;i++){
//                 maxCharFreq[i] = Math.max(maxCharFreq[i], tempCharFreq[i]);
//             }
//         }

//         List<String> Universal = new ArrayList<>();

//         for(String word: words1){
//             Arrays.fill(tempCharFreq,0);
//             for(char ch : word.toCharArray()){
//                 tempCharFreq[ch - 'a']++;
//             }

//             boolean isUniversal = true;

//             for(int i = 0 ; i< 26; i++){
//                 if(maxCharFreq[i] > tempCharFreq[i]){
//                     isUniversal = false;
//                     break;
//                 }
//             }

//             if(isUniversal){
//                 Universal.add(word);
//             }
            
//         }
//         return Universal;

//     }
//    }




class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
       List<String> result=new ArrayList<>();
        int[] target=new int[26];
        
        for(String word:B){
            int[] temp=new int[26];
            for(char ch:word.toCharArray()){
                temp[ch-'a']++;
                target[ch-'a']=Math.max(target[ch-'a'],temp[ch-'a']);
            }
        }
        
        for(String word:A){
            int[] source=new int[26];
            for(char ch:word.toCharArray()){
                source[ch-'a']++;
            }
            
            if(subset(source,target)){
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean subset(int[] parent,int[] child){
        for(int i=0;i<26;i++){
            if(parent[i]<child[i]) return false;
        }
        return true;
    }
}











