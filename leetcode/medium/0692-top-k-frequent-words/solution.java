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