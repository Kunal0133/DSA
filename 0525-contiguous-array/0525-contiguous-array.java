class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int zero=0;
        int one=0;
        int result=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            else{
                one++;
            }
            int diff=zero-one;
            if(diff==0){
                result=Math.max(result,i+1);
                continue;
            }
            if(map.containsKey(diff)){
                int index=i-map.get(diff);
                result=Math.max(result,index);
            }
            else{
                map.put(diff,i);
            }
        }
        return result;
    }
}