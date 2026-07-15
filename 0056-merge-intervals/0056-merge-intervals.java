class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a,(b,c) -> b[0]-c[0]);
        int n= a.length;
        int start1=a[0][0];
        int end1=a[0][1];
        List<int[]>result=new ArrayList<>();
        for(int i=1;i<n;i++){
            int start2=a[i][0];
            int end2=a[i][1];
            if(end1>=start2){
                start1=start1;
                end1=Math.max(end1,end2);
                continue;
            }
            else{
                result.add(new int[]{start1,end1});
                start1=start2;
                end1=end2;
            }
        }
        result.add(new int[]{start1,end1});
        return result.toArray(new int[result.size()][]);

    }
}