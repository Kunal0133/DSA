# Kth Largest Element in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `kth`  *largest element in the array*.

Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.

Can you solve it without sorting?

 

 **Example 1:** 

```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

```

 **Example 2:** 

```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

```

 

 **Constraints:** 

- 1 <= k <= nums.length <= 105
- -104 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 48 ms (beats 66.49%)  
**Memory:** 73.6 MB (beats 86.47%)  
**Submitted:** 2026-10-25T12:20:05.182Z  

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue <Integer> minHeap= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }
        for(int i=k;i<n;i++){
            if(minHeap.peek()>=nums[i]){
                continue;
            }
            else{
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/kth-largest-element-in-an-array/)