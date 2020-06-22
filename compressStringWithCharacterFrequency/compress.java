import java.util.*;

public class Code {
  public static void main(String[] args) {
    String s = "aaabbbccdfg";
    Character c = s.charAt(0);
    int count = 1;
    StringBuilder sb = new StringBuilder();
    
    for(int i = 1; i < s.length(); i++) {
      if(c != s.charAt(i)) {
        sb.append(count);
        sb.append(c);
        count = 0;
        c = s.charAt(i);
      }
      count++;
    }
    sb.append(count);
    sb.append(c);
    System.out.println(sb);
  }
}
