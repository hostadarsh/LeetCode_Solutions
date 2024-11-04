class Solution {
    public boolean rotateString(String s, String goal) {
        //int a = s.length(),c = goal.length();
        String b = s.concat(s);
        if(b.contains(goal) && s.length() == goal.length()){
            return true;
        }
        return false;
    }
}
