import java.util.*;

public class Code {
  public static void main(String[] args) {
    String s = "leaeioutsgosaueueueioaiomewhere";
    int max = Integer.MIN_VALUE;
    String maxString = "";
		int count = 0, start = 0, end = 0;
		
    while(end < s.length()) {
      if(!(s.charAt(end) == 'a' || s.charAt(end) == 'e' || s.charAt(end) == 'i' || s.charAt(end) == 'o' || s.charAt(end) == 'u')){
        if(start < end) start++;
        else end++;
      } else {
        int startIndex = start + 1;
        if (start == 0) startIndex = 0;
        
        if((end - startIndex) > max) {
          max = end - startIndex;
          maxString = s.substring(startIndex, end + 1);
        }
        end++;
      }
    }
    System.out.println(maxString);
    System.out.println(max + 1);
  }
}
