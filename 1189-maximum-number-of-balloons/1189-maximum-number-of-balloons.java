class Solution {
    public int maxNumberOfBalloons(String text) {
        String s ="balloon";
        HashMap<Character,Integer> ball=new HashMap<>();
        HashMap<Character,Integer> t=new HashMap<>();
        int result=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            ball.put(c,ball.getOrDefault(c,0)+1);
        }
        for(int j=0;j<text.length();j++){
            char ch=text.charAt(j);
            t.put(ch,t.getOrDefault(ch,0)+1);
        }
        for(char x:ball.keySet()){
            int count=t.containsKey(x)?t.get(x)/ball.get(x):0;
            result=Math.min(result,count);

        }
        return result;
    }
}