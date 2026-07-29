class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n= nums.length;
        int low=0;
        int high=0;
        int sum=0;
        int result= Integer.MAX_VALUE;
        for(high=0;high<n;high++){
            sum=sum+nums[high];
        
        
        while(sum>=target){
            int length= high-low+1;
             result=Math.min(result,length);
            sum= sum -nums[low];
            low++;
        }
        }
        return (result==Integer.MAX_VALUE?0:result);
    }
}