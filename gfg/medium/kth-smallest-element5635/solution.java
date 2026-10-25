class Solution {
    public int kthSmallest(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            maxHeap.offer(arr[i]);
        }
        for(int i=k;i<n;i++){
            if(maxHeap.peek()<=arr[i]){
              continue;
            }
            else{
                maxHeap.poll();
                maxHeap.offer(arr[i]);
                
            }
        }
        return maxHeap.peek();
        
    }
}
