class Solution {
    public int maximumSum(int[] arr) {
        int result=arr[0];
        int nodeletion=arr[0];
        int onedeletion=0;
        for(int i=1;i<arr.length;i++){
            int v1=arr[i];
            int v2=nodeletion+arr[i];
            int v3=nodeletion;;
            int v4=onedeletion+arr[i];
            
            nodeletion= Math.max(v1,v2);
            onedeletion=Math.max(v3,v4);
            result=Math.max(result,Math.max(nodeletion,onedeletion));
        }
        return result;
    }
}