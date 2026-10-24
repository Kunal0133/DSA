# Kth Smallest Element in a Sorted Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an `n x n` `matrix` where each of the rows and columns is sorted in ascending order, return  *the*  `kth`  *smallest element in the matrix*.

Note that it is the `kth` smallest element  **in the sorted order**, not the `kth`  **distinct**  element.

You must find a solution with a memory complexity better than `O(n2)`.

 

 **Example 1:** 

```
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

```

 **Example 2:** 

```
Input: matrix = [[-5]], k = 1
Output: -5

```

 

 **Constraints:** 

- n == matrix.length == matrix[i].length
- 1 <= n <= 300
- -109 <= matrix[i][j] <= 109
- All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
- 1 <= k <= n2

 

 **Follow up:** 

- Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
- Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 51.5 MB (beats 51.06%)  
**Submitted:** 2026-10-24T09:56:13.064Z  

```java
class Solution {
    int func(int[][]matrix,int n,int m,int guess){
    int count=0;
    int row=n-1;
    int col=0;
    while(row>=0 && col<m){
        if(matrix[row][col]<=guess){
            count=count + row+1;
            col++;
        }
        else{
            row--;
        }
    }
    return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=matrix[0][0];
        int high=matrix[n-1][m-1];
        int result=-1;
        while(low<=high){
            int guess=(low+high)/2;
            int ans=func(matrix,n,m,guess);
            if(ans<k){
                low=guess+1;
            }
            else{
                result=guess;
                high=guess-1;
            }
        }
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)