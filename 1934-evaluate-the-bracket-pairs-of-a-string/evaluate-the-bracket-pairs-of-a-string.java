class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        String ans = "";

        Map<String, String> mp = new HashMap<>();

        for(int i = 0; i < knowledge.size(); i++){
            mp.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) != '('){
                ans += s.charAt(i);
            }
            else{
                i++;
                String key = "";
                while(s.charAt(i) != ')'){
                    key += s.charAt(i);
                    i++;
                }

                if(mp.containsKey(key)){
                    ans += mp.get(key);
                }
                else{
                    ans += "?";
                }

                
            }
        }
        return ans;

    }
}