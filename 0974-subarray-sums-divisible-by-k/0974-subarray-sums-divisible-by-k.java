class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int result=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum =sum+nums[i];
            int rem=sum%k;
            if(rem<0)
            rem=rem+k;
            int freq=map.getOrDefault(rem,0);
            result=result+freq;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return result;
    }
}