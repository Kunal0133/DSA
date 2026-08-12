class Solution {
    public int lengthOfLongestSubstring(String s) {
         int n= s.length();
        int low=0;
        int result= 0;
        HashMap<Character,Integer> map =new HashMap<>();
          for(int high=0; high<n; high++){
            char h= s.charAt(high);
            map.put(h,map.getOrDefault(h,0)+1);
            int k= high-low+1;
            while(map.size()<k){
                char left =s.charAt(low);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                map.remove(left);
                }
                low++;
                k= high-low+1;
                
            }
            
                result=Math.max(result,high-low+1);
            
        }
        return result;
    }
}