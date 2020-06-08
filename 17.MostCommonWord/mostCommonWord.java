class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.length() == 0) return paragraph;
        String[] converted = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split(" ");
        int max = Integer.MIN_VALUE;
        String maxWord = "";
        Set<String> banSet = new HashSet<>();
        Map<String, Integer> wordCount = new HashMap<>();
        
        for(String word: banned){
            banSet.add(word);
        }
        
        for(String wordUntrim: converted) {
            String word = wordUntrim.trim();
            if(!banSet.contains(word) && word.length() >0) {
                int count = wordCount.getOrDefault(word, 0) + 1;
                if(count > max) {
                    max = count;
                    maxWord = word;
                }
                wordCount.put(word, count);
            }
        }
        
        return maxWord;
    }
}