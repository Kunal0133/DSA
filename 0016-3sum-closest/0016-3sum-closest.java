class Solution {
    public int threeSumClosest(int[] a, int target) {
         int n= a.length;
        Arrays.sort(a);
         int max_diff= Integer.MAX_VALUE;
         int result= a[0]+a[1]+a[2];
        for(int i=0;i<n-2;i++){
            int left= i+1;
            int right = n-1;
           
            while(left<right){
                int sum= a[i]+a[left]+a[right];
                
                int difference= Math.abs(sum - target);
                if(max_diff>difference){
                    max_diff= difference;
                    result = sum;
                }
                if(sum== target){
                    left++;
                    right--;
                    return sum;
                }
                else if(sum<target){
                    left++;

                }
                else{
                    right--;
                }
            }
           
        }
        return result;
    }
}