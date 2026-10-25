# Kth Smallest

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array  **arr[]**  and an integer  **k**, find and return the kth smallest element in the given array.

 **Examples :** 

```
Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4
Output: 5
Explanation: 4th smallest element in the given array is 5.
```

```
Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output: 7
Explanation: 3rd smallest element in the given array is 7.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-25T12:12:58.159Z  

```java
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

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1)