class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            int count = 0;
            int index;
            

            for(char ch : word.toCharArray()){
                count += weights[ch - 'a'];
            }

            if(count >= 26){
                index = count % 26;
            }
            else{
                index = count;
            }

            // index = count % 26;

            sb.append((char) ('z' - index));
        }

        return sb.toString();
    }
}