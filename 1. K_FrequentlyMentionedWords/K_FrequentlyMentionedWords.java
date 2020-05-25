import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        int k = 2;
        String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = {"I love anacell Best services; Best services provided by anacell", "betacellular has great services", "deltacellular provides much better services than betacellular",
                    "cetracular is worse than anacell", "Betacellular is better than deltacellular."};
        
        List<String> words = topKFrequent(keywords, reviews, k);
            
        for(String word: words){
            System.out.println(word);
        }
    }
    
    public static List<String> topKFrequent(String[] keys, String[] reviews, int k) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        
        for(int i=0; i < reviews.length; i++){
            Map<String, Integer> currentFrequency = new HashMap<>();
            // TODO: add logc to remove special characters from the words
            String[] words = reviews[i].split(" ");
            
            for (int j = 0; j < words.length; j++) {
                if (currentFrequency.get(words[j].toLowerCase())==null) {
                    currentFrequency.put(words[j].toLowerCase(), 1);
                }
            }
            
            for (String key: currentFrequency.keySet()) {
                wordFrequency.put(key, wordFrequency.getOrDefault(key, 0) + 1);
            }
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<String>((w1, w2) -> wordFrequency.get(w1).equals(wordFrequency.get(w2)) ? w2.compareTo(w1) : wordFrequency.get(w1) - wordFrequency.get(w2));

        // if the keywords list is not provided put all the word frequencies into the heap.
        // for (String word: wordFrequency.keySet()) {
        //     minHeap.offer(word);
        //     if (minHeap.size() > k) minHeap.poll();
        // }

        // fetch the word counts of the keywords provided from the wordFrequency map.
        for(String key: keys){
            if(wordFrequency.get(key) != null){
                minHeap.offer(key);
                if(minHeap.size() > k) minHeap.poll();
            }
        }
        
        List<String> ans = new ArrayList();
        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        Collections.reverse(ans);
        return ans;
    }
}