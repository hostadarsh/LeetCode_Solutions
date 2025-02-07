// // class Solution {
// //     public int[] queryResults(int limit, int[][] queries) {

// //         Map<Integer,Integer> ball = new HashMap<>();
// //         Map<Integer,Integer> color = new HashMap<>();
// //         int len = queries.length;
// //         //int diff = 0;

// //         int[] answer = new int[len];

// //         for(int i = 0; i < len; i++){

// //             if(ball.containsKey(queries[i][0])){

// //                 if(ball.get(queries[i][0] == queries[i][1])){
// //                     answer[i] = color.size();
// //                     continue;
// //                 }
// //                 else if(color.get(ball.get(queries[i][0] == 1))){
// //                     color.remove(ball.get(queries[i][0]));
// //                 }
// //                 else{
// //                     color.put(ball.get(queries[i][0], color.get(queries[i][0] - 1)));
// //                 }

// //             }

            
// //         }

// //     }
// // }

// class Solution {
//     public int[] queryResults(int limit, int[][] queries) {

//         Map<Integer,Integer> ball = new HashMap<>();
//         Map<Integer,Integer> color = new HashMap<>();
//         int len = queries.length;
        
//         int[] answer = new int[len];

//         for(int i = 0; i < len ; i++){
//             if(!ball.containsKey(queries[i][0])){
//                 ball.put(queries[i][0], queries[i][1]);
//             }
//             else{
//                 if(color.get(ball.get(queries[i][0]))==1){
//                     color.remove(ball.get(queries[i][0]));
//                 }
//                 else{
//                     color.put(ball.get(queries[i][0]), color.get(ball.get(queries[i][0]))-1);
//                 }
//                 ball.put(queries[i][0],queries[i][1]);
//             }

//             color.put(queries[i][1],color.getOrDefault(queries[i][1],0)+1);

//             answer[i]=color.size();
//         }
        
//         return answer;

//             }
//         }



 
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> node = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int it[]=queries[i];
            if(node.containsKey(it[0])){
                if(node.get(it[0])==it[1]) {
                    ans[i]=color.size();continue;
                }
                else if (color.get(node.get(it[0]))<=1) color.remove(node.get(it[0]));
                else
                color.put(node.get(it[0]),color.get(node.get(it[0]))-1);
                node.put(it[0],it[1]);
                color.put(it[1],color.getOrDefault(it[1],0)+1);
            }
            else{
                node.put(it[0],it[1]);
                color.put(it[1],color.getOrDefault(it[1],0)+1);
            }
            ans[i]=color.size();
        }
        return ans;
    }
}