class Solution {
    public String minWindow(String s, String t) {
         if(s.length()<t.length()){
        return "";
      }
      HashMap<Character, Integer>needed=new HashMap<>();
      for(int i=0;i<t.length();i++){
        char c=t.charAt(i);

      
      needed.put(c,needed.getOrDefault(c,0)+1);
      }
      int low=0;
      int minlen= Integer.MAX_VALUE;
      int formed=0;
      int required=needed.size();
      HashMap<Character,Integer> have=new HashMap<>();
      String result="";
      for(int high=0;high<s.length();high++){
        char h= s.charAt(high);
        have.put(h,have.getOrDefault(h,0)+1);

        if(needed.containsKey(h)&&needed.get(h).equals (have.get(h))){
            formed++;
        }
        while(formed==required){
            if(high-low+1<minlen){
                minlen=high-low+1;
                result=s.substring(low,high+1);
            }
            char left=s.charAt(low);
            have.put(left,have.get(left)-1);
            if(needed.containsKey(left)&&have.get(left)<needed.get(left))
                formed--;
                low++;
            
        }
      }
      return result;
    }
}