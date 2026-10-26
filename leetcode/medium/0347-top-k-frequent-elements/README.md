# Top K Frequent Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `k`  *most frequent elements*. You may return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  nums = [1,1,1,2,2,3], k = 2

 **Output:**  [1,2]

 **Example 2:** 

 **Input:**  nums = [1], k = 1

 **Output:**  [1]

 **Example 3:** 

 **Input:**  nums = [1,2,1,2,1,2,3,1,3,2], k = 2

 **Output:**  [1,2]

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
- k is in the range [1, the number of unique elements in the array].
- It is guaranteed that the answer is unique.

 

 **Follow up:**  Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size.

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 42.21%)  
**Memory:** 47.3 MB (beats 81.30%)  
**Submitted:** 2026-10-26T11:47:56.407Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)