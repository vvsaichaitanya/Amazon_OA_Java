class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> words = new PriorityQueue<>((w1, w2)-> w2.compareTo(w1));
        for(int i=0;i<searchWord.length();i++){
            List<String> currentList = new ArrayList<>();
            String typeString = searchWord.substring(0, i+1);
            for(String product: products){
                if(product.indexOf(typeString)==0){
                    words.offer(product);
                    if(words.size()>3) words.poll();
                }
            }
            while(!words.isEmpty()) currentList.add(words.poll());
            Collections.reverse(currentList);
            result.add(currentList);
        }
        return result;
    }
}