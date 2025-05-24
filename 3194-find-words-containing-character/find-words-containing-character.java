// class Solution {
//     public List<Integer> findWordsContaining(String[] words, char x) {
//         List<List<Character>> charLists = new ArrayList<>();

//         List<Integer> ans = new ArrayList<>();
//         int n = 0;

//         for(String s : words){
//             List<Character> charList = new ArrayList<>();
//             for(char c : s.toCharArray()){
//                 charList.add(c);
//             }
//             charLists.add(charList);
//         }

//         for(List<Character> list : charLists){
//             if(list.contains(x)){
//                 ans.add(n);
//                 n++;
//             }
//             else{
//                 n++;
//             }
//         }

//         return ans;

//     }
// }

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> resultIndices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                resultIndices.add(i);
            }
        }
        return resultIndices;
        
    }
}