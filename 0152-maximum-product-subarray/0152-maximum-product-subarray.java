class Solution {
    public int maxProduct(int[] nums) {
        int result=nums[0];
        int maxend=nums[0];
        int minend=nums[0];
        int bestend=nums[0];
        for(int i=1;i<nums.length;i++){
            int option1=nums[i];
            int option2=nums[i]*maxend;
            int option3=nums[i]*minend;
            maxend=Math.max(option1,Math.max(option2,option3));
            minend=Math.min(option1,Math.min(option2,option3));
            result=Math.max(result,Math.max(maxend,minend));
        }
        return result;
    }
}