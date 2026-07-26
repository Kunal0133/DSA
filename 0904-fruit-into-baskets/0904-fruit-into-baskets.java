class Solution {
    public int totalFruit(int[] fruits) {
        int low=0;
     
        int n=fruits.length;
        int result=0;
        HashMap <Integer,Integer> map= new HashMap<>();
        for(int high=0; high<n; high++){
            int h = fruits[high];
            map.put(h,map.getOrDefault(h,0)+1);
            while(map.size()>2){
                int left=fruits[low];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                low++;
            }
            if(map.size()<=2){
                result=Math.max(result, high - low +1);
            }
        }
        return result;
    }
}