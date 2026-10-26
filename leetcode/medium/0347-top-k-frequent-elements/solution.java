class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int x: nums){
        map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<int[]>heap=new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int key: map.keySet()){
            int freq= map.get(key);

            if(heap.size()<k){
                heap.offer(new int[]{freq,key});
            }
            else if(freq>heap.peek()[0]){
                heap.poll();
                heap.offer(new int[]{freq,key});
                
            }
        }
        int[]result =new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll()[1];
        }
    return result;
    }
}