class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int result=0;
        boolean odd=false;
        for(int val:map.values()){
            if(val%2==0){
                result+=val;
                }
            else{
                odd=true;
            }
        }
            if(odd==false)
            return result;
    
        for(int val:map.values()){
            if(val%2==1){
                result=result+val-1;
                 }
        }
        return result+1;
    }
}
                
      
    
