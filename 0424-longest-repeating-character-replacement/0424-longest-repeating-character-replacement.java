class Solution {
    public int characterReplacement(String s, int k) {
        int low=0;
        int n=s.length();
        int result=0;
        int arr[]= new int[26];
        int maxCount=0;
        for(int high=0; high<n; high++){
           arr[s.charAt(high) - 'A']++;
           maxCount=Math.max(maxCount, arr[s.charAt(high)-'A']);
           int windowsize= high-low+1;
           if(windowsize-maxCount>k){
            arr[s.charAt(low)-'A']--;
            low++;
           }
           result= Math.max(result,high-low+1);

        }
        return result;
    }
}