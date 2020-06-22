import java.util.*;

public class Code {
  public static void main(String[] args) {
    StringBuilder str = new StringBuilder("1??0?101");
    int count = 0;
    List<Integer> index = new ArrayList<>();
    
    for(int i = 0; i < str.length(); i++)
      if(str.charAt(i) == '?') {index.add(i);count++;}
    
    int pow = (int)Math.pow(2, count);
    for(int j = 0; j < pow; j++) {
      String fill = process(Integer.toBinaryString(j), count);
      for(int k = 0; k < count; k++) {
			str.replace(index.get(k), index.get(k) + 1, Character.toString(fill.charAt(k)));
      }
      System.out.println(str);
    }
  }
  
  public static String process(String fill, int count) {
    StringBuilder sb = new StringBuilder(fill);
    if(fill.length() < count)
      for (int i = 0; i < count - fill.length(); i++)
        sb.insert(0, '0');
    return sb.toString();
  }
}
