class Solution {
    public boolean rotateString(String s, String goal) {
        int a = s.length(),c = goal.length();
        String b = s.concat(s);
        if(b.indexOf(goal)!=-1 && a<=c){
            return true;
        }
        return false;
    }
}
