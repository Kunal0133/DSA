class Solution {
    public int[][] insert(int[][] a, int[] newInterval) {
    List<int[]>merged=new ArrayList<>();
    boolean insert=false;
    
    for(int i=0;i<a.length;i++ ){
        int start=a[i][0];
        
        if(start>=newInterval[0] && !insert){
            merged.add(newInterval);
            insert=true;
        }
        merged.add(a[i]);
    }
    if(!insert) merged.add(newInterval);

    List<int[]>result=new ArrayList<>();
    int start1=merged.get(0)[0];
    int end1=merged.get(0)[1];
    for(int j=1;j<merged.size();j++){
        int start2=merged.get(j)[0];
        int end2=merged.get(j)[1];
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

        

    
