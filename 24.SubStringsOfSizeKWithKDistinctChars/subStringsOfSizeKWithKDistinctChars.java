import java.util.*;

public class Code {
  public static void main(String[] args) {
    String s = "awaglknagawunagwkwagl";
    int k = 4;
    int length = s.length();
    Set<String> res = new HashSet<>();
    Set<Character> curRes = new HashSet<>();
    int i = 0, j = k;
    for (;j <= length; i++,j++) {
      String subStr = s.substring(i, j);
      boolean flag = false;
      for(Character c: subStr.toCharArray()) {
        if(curRes.contains(c)) {
          flag = true;
          break;
        } else{
          flag = false;
          curRes.add(c);
        }
      }
      curRes.clear();
      if(!flag) res.add(subStr);
    }
    
    System.out.println(res.size());
    for(String resStr: res) {
      System.out.println(resStr);
    }
  }
}


// Example 1:

// Input: s = "abcabc", k = 3
// Output: ["abc", "bca", "cab"]
// Example 2:

// Input: s = "abacab", k = 3
// Output: ["bac", "cab"]
// Example 3:

// Input: s = "awaglknagawunagwkwagl", k = 4
// Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
// Explanation: 
// Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl" 
// "wagl" is repeated twice, but is included in the output once.