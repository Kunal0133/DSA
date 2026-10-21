class Solution {
    long func(int[]piles,int n, int speed){
        long hours=0;
        for(int i=0;i<n;i++){
            hours=hours+piles[i]/speed;
            if(piles[i]%speed!=0)
            hours++;
        }
        return hours;

    }
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        int low=1;
        int high=Arrays.stream(piles).max().getAsInt();
        int result=-1;
        while(low<=high){
            int speed=(low+high)/2;
            long k=func(piles,n,speed);
            if(k>h){
                low=speed+1;
            }
            else{
                result=speed;
                high=speed-1;
            }

        }
        return result;
    }
}