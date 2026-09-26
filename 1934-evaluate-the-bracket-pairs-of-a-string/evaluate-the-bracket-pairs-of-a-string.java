// class Solution {
//     public String evaluate(String s, List<List<String>> knowledge) {
//         String ans = "";

//         Map<String, String> mp = new HashMap<>();

//         for(int i = 0; i < knowledge.size(); i++){
//             mp.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
//         }

//         for(int i = 0; i < s.length(); i++){

//             if(s.charAt(i) != '('){
//                 ans += s.charAt(i);
//             }
//             else{
//                 i++;
//                 String key = "";
//                 while(s.charAt(i) != ')'){
//                     key += s.charAt(i);
//                     i++;
//                 }

//                 if(mp.containsKey(key)){
//                     ans += mp.get(key);
//                 }
//                 else{
//                     ans += "?";
//                 }

                
//             }
//         }
//         return ans;

//     }
// }


class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder keyBuilder = new StringBuilder();
        boolean insideBrackets = false;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                insideBrackets = true;
                keyBuilder = new StringBuilder();
            } else if (c == ')') {
                insideBrackets = false;
                String key = keyBuilder.toString();
                result.append(map.getOrDefault(key, "?"));
            } else if (insideBrackets) {
                keyBuilder.append(c);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}