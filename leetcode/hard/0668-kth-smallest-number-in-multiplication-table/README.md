# Kth Smallest Number in Multiplication Table

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Nearly everyone has used the Multiplication Table. The multiplication table of size `m x n` is an integer matrix `mat` where `mat[i][j] == i * j` (**1-indexed**).

Given three integers `m`, `n`, and `k`, return  *the* `kth` *smallest element in the* `m x n` *multiplication table*.

 

 **Example 1:** 

```
Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.

```

 **Example 2:** 

```
Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.

```

 

 **Constraints:** 

- 1 <= m, n <= 3 * 104
- 1 <= k <= m * n

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 60.89%)  
**Memory:** 41.8 MB (beats 89.83%)  
**Submitted:** 2026-10-24T10:21:50.424Z  

```java
class Solution {
    int func(int m, int n, int guess) {
        int count = 0;
        int row = m - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if ((row + 1) * (col + 1) <= guess) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int result = -1;
        while (low <= high) {
            int guess = low + (high - low) / 2;
            int ans = func(m, n, guess);
            if (ans < k) {
                low = guess + 1;
            } else {
                result = guess;
                high = guess - 1;
            }
        }
        return result;
    }
}
        
    

```

---

[View on LeetCode](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/)