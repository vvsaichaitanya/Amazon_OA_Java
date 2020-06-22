import java.util.*;

public class Code {
  public static void main(String[] args) {
	String s = "catsanddog";
    List<String> wordDict = new ArrayList<>();
    wordDict.add("cat");
    wordDict.add("cats");
    wordDict.add("and");
    wordDict.add("sand");
    wordDict.add("dog");
    
  	List<String> res = breakWord(s.length(), s, wordDict, new ArrayList<String>(), new ArrayList<String>());
  	System.out.println(res.size());
    for(String ss: res) {
    	System.out.println(ss);
  	}
  }
  
  public static List<String> breakWord(int n, String sc, List<String> wordDict, List<String> sb, List<String> res) {
        if(String.join("", sb).length() == n) res.add(String.join(", ", sb));
        
        for(String w: wordDict) {
            if(sc.indexOf(w) == 0) {
	            System.out.println(w);
                sb.add(w);
                breakWord(n, sc.substring(w.length()), wordDict, sb, res);
                sb.remove(sb.size()-1);
                    
            }
        }
        return res;
    }
}



// import java.util.*;

// public class Code {
//   public static void main(String[] args) {
//     List<String> sb = new ArrayList<>();
//     sb.add("hello");
//     sb.add("how");
//     sb.add("are");
//     System.out.println(String.join("", sb) + ": " + String.join(", ", sb));
//   }
// }

