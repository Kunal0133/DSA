# Top K Frequent Words

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of strings `words` and an integer `k`, return  *the* `k` *most frequent strings*.

Return the answer  **sorted**  by  **the frequency**  from highest to lowest. Sort the words with the same frequency by their  **lexicographical order**.

 

 **Example 1:** 

```
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

```

 **Example 2:** 

```
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

```

 

 **Constraints:** 

- 1 <= words.length <= 500
- 1 <= words[i].length <= 10
- words[i] consists of lowercase English letters.
- k is in the range [1, The number of unique words[i]]

 

 **Follow-up:**  Could you solve it in `O(n log(k))` time and `O(n)` extra space?

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 88.89%)  
**Memory:** 46.3 MB (beats 81.19%)  
**Submitted:** 2026-10-26T12:13:24.794Z  

```java
import java.util.*;

class Solution {

    class Pair {
        String word;
        int freq;

        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

       
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return a.freq - b.freq;          
            }
            return b.word.compareTo(a.word);     
        });

       
        for (String word : map.keySet()) {
            int freq = map.get(word);

            if (heap.size() < k) {
                heap.add(new Pair(word, freq));
            } else {
                Pair top = heap.peek();           

                if (freq > top.freq || (freq == top.freq && word.compareTo(top.word) < 0)) {
                    heap.poll();
                    heap.add(new Pair(word, freq));
                }
            }
        }

       
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll().word);
        }
        Collections.reverse(ans);
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/top-k-frequent-words/)