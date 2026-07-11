class Solution {
    public int maxSubArray(int[] nums) {
        int bestend=nums[0];
        int result= nums[0];
        for(int i=1;i<nums.length;i++){
            bestend=Math.max(bestend+nums[i],nums[i]);
            result=Math.max(result,bestend);
        }
        return result;
    }
}