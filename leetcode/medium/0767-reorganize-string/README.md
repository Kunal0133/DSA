# Reorganize String

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s`, rearrange the characters of `s` so that any two adjacent characters are not the same.

Return  *any possible rearrangement of*  `s`  *or return*  `""`  *if not possible*.

 

 **Example 1:** 

```
Input: s = "aab"
Output: "aba"

```

 **Example 2:** 

```
Input: s = "aaab"
Output: ""

```

 

 **Constraints:** 

- 1 <= s.length <= 500
- s consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 76.42%)  
**Memory:** 42.2 MB (beats 97.80%)  
**Submitted:** 2026-10-27T11:38:36.211Z  

```java
class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int[] freq= new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0;i<26;i++){
            if(freq[i]>(n+1)/2){
                return "";
            }
            if(freq[i]>0){
                pq.add(new int[]{i,freq[i]});
            }
        }

        StringBuilder sb= new StringBuilder();
        while(pq.size()>=2){
            int[]first =pq.poll();
            int[]second=pq.poll();
            
            sb.append((char) (first[0]+'a'));
            sb.append((char) (second[0]+'a'));

            first[1]--;
            second[1]--;
            
            if(first[1]>0) 
            pq.add(first);
            if(second[1]>0)
            pq.add(second);
        }

        if(!pq.isEmpty()){
            int[]last=pq.poll();
            sb.append((char) (last[0] +'a'));
        }
        return sb.toString();
         
        }
    }

```

---

[View on LeetCode](https://leetcode.com/problems/reorganize-string/)