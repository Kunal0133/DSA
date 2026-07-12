class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxsum=nums[0];
        int totalsum=0;
        
        int result=nums[0];
        int minsum=nums[0];
        for(int j=0;j<nums.length;j++){
            totalsum=totalsum+nums[j];
        }
        for(int i=1;i<nums.length;i++){
            
           
            maxsum=Math.max(maxsum+nums[i],nums[i]);
            minsum=Math.min(minsum+nums[i],nums[i]);
            
            int maxsumofcirculararray= totalsum-minsum;
            
            if(totalsum==minsum){
                result=Math.max(result,maxsum);
            }
            else{
                result=Math.max(result,Math.max(maxsumofcirculararray,maxsum));
            }

        }
        return result;
    }
}