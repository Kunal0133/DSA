class Solution {
    boolean func(int[]arr,int k,long guess,int n ){
        int s=1;
        long page=0;
        for(int i=0;i<n;i++){
            if(page+arr[i]<=guess){
            page+=arr[i];
            }
            else{
                s++;
                page=arr[i];
                if(s>k)
                return false;
            }
           
        }
         return true;
    }
    public int findPages(int[] arr, int k) {
        int n=arr.length;
        long result=-1;
        if(k>n)
        return -1;
        long low=0;
        long high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,(long)arr[i]);
            high=high+arr[i];
        }
        while(low<=high){
            long guess=low+(high-low)/2;
            if(func(arr,k,guess,n)){
                result=guess;
                high=guess-1;
            }
            else{
                low=guess+1;
            }
            
        }
        return(int) result;
       
    }
}