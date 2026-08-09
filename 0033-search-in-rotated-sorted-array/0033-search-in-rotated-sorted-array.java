class Solution {
    public int search(int[] a, int target) {
        int n=a.length;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int guess=(low+high)/2;
            if(a[guess]==target){
                return guess;
            }
            if(a[guess]>a[high]){
                if(a[guess]<target){
                    low=guess+1;
                }
                else{
                    if(a[low]>target){
                        low=guess+1;

                    }
                    else{
                        high=guess-1;
                    }
                }
                continue;
            }
            else{
                if(a[guess]>target){
                    high=guess-1;
                }
                else{
                    if(a[high]<target){
                       high=guess-1;
                    }
                    else{
                        low=guess+1;
                    }
                }
            }

        }
        return -1;
    }
}