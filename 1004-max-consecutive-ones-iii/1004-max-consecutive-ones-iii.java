class Solution {
    public int longestOnes(int[] nums, int k) {
         int low=0;
        int n=nums.length;
       
        int result=0;
        int arr[]=new int[2];
         
        for(int high=0; high<n; high++){
            arr[nums[high]]++;
           
            int windowsize = high - low +1;
            if(windowsize - arr[1]>k){
                arr[nums[low]]--;
                low++;
            }
            

            
            result=Math.max(result,high-low+1);
        }
        return result;
    }
}