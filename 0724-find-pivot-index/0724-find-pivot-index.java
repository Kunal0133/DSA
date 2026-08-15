class Solution {
    public int pivotIndex(int[] nums) {
        int left=0;
        int totalsum=0;
        for(int j=0;j<nums.length;j++){
            totalsum=totalsum+nums[j];
        }
        for(int i=0;i<nums.length;i++){
            int right=totalsum-left-nums[i];
            if(left==right)
                return i;
                left=left+nums[i];
           
        }
        return-1;
    }
}