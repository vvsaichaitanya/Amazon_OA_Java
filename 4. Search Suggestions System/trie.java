class Trie{
    char c;
    List<String> children;
    Trie next;
    Trie(char c){
     this.c = c;
     children = new ArrayList<>();
     next = null;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
	//sort the strings before hand 
        Arrays.sort(products);
        Trie root = new Trie(searchWord.charAt(0));
        Trie temp = root;
		// form a trie tree(here it would be similar to a linked list) for the search word 
        for(int i = 1; i<searchWord.length();i++){
           temp.next = new Trie(searchWord.charAt(i));
           temp = temp.next;
        }
        for(String product:products){
         temp = root;
		 //checking if "product" word can be added how many nodes in trie tree we formed for search word
            for(int i = 0; i<searchWord.length();i++){
                if(i>=product.length() || searchWord.charAt(i)!=product.charAt(i))
                    break;
                List<String> children = temp.children;
                if(children.size()<3)
                    children.add(product);
                temp = temp.next;
            }
        }
        List<List<String>> results = new ArrayList<>();
        while(root!=null){
            results.add(root.children);
            root=root.next;
        }
        return results;
    }
}