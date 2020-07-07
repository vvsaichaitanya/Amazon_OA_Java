import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        int k = 2;
        String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = {"I love anacell Best services; Best services provided by anacell", "betacellular has great services", "deltacellular provides much better services than betacellular",
                    "cetracular is worse than anacell", "Betacellular is better than deltacellular."};
        
        List<String> words = topKFrequent(keywords, reviews, k);
            
        for(String word: words) System.out.println(word);
    }
    
    public static List<String> topKFrequent(String[] keys, String[] reviews, int k) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        Set<String> keywords = new HashSet<>(Arrays.asList(keys));
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> wordFrequency.get(s1) == wordFrequency.get(s2)? s2.compareTo(s1): wordFrequency.get(s1) - wordFrequency.get(s2));
        List<String> ans = new ArrayList();
        
        for(int i=0; i < reviews.length; i++){
            Map<String, Integer> currentFrequency = new HashMap<>();
            // TODO: add logc to remove special characters from the words
            String[] words = reviews[i].split(" ");
            
            for (int j = 0; j < words.length; j++) {
                String word = words[j].toLowerCase();
                if (currentFrequency.get(word)==null && keywords.contains(word)) {
                    currentFrequency.put(word, 1);
                }
            }
            
            for (String key: currentFrequency.keySet()) {
                wordFrequency.put(key, wordFrequency.getOrDefault(key, 0) + 1);
            }
        }

        // if the keywords list is not provided put all the word frequencies into the heap.
        // for (String word: wordFrequency.keySet()) {
        //     minHeap.offer(word);
        //     if (minHeap.size() > k) minHeap.poll();
        // }

        // fetch the word counts of the keywords provided from the wordFrequency map.
        for(String key: wordFrequency.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        Collections.reverse(ans);
        return ans;
    }
}