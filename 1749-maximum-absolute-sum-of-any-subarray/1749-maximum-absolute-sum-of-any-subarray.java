class Solution {
    public int maxAbsoluteSum(int[] arr) {
       int result=Math.abs(arr[0]);
       int maxsum= arr[0];
       int minsum=arr[0];
       for(int i=1;i<arr.length;i++){
        maxsum=Math.max(maxsum+arr[i],arr[i]);
        minsum= Math.min(minsum+arr[i],arr[i]);
        int v1=Math.abs(maxsum);
        int v2=Math.abs(minsum);
        
        result=Math.max(result,Math.max(v1,v2));
       } 
       return result;
    }
}