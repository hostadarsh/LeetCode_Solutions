// class Solution {
//     public int[] queryResults(int limit, int[][] queries) {

//         Map<Integer,Integer> ball = new HashMap<>();
//         Map<Integer,Integer> color = new HashMap<>();
//         int len = queries.length;
//         //int diff = 0;

//         int[] answer = new int[len];

//         for(int i = 0; i < len; i++){

//             if(ball.containsKey(queries[i][0])){

//                 if(ball.get(queries[i][0] == queries[i][1])){
//                     answer[i] = color.size();
//                     continue;
//                 }
//                 else if(color.get(ball.get(queries[i][0] == 1))){
//                     color.remove(ball.get(queries[i][0]));
//                 }
//                 else{
//                     color.put(ball.get(queries[i][0], color.get(queries[i][0] - 1)));
//                 }

//             }

            
//         }

//     }
// }

class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        Map<Integer,Integer> ball = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
        int len = queries.length;
        
        int[] answer = new int[len];

        for(int i = 0; i < len ; i++){
            if(!ball.containsKey(queries[i][0])){
                ball.put(queries[i][0], queries[i][1]);
            }
            else{
                if(color.get(ball.get(queries[i][0]))==1){
                    color.remove(ball.get(queries[i][0]));
                }
                else{
                    color.put(ball.get(queries[i][0]), color.get(ball.get(queries[i][0]))-1);
                }
                ball.put(queries[i][0],queries[i][1]);
            }

            color.put(queries[i][1],color.getOrDefault(queries[i][1],0)+1);

            answer[i]=color.size();
        }
        
        return answer;

            }
        }



 
