import java.util.*;

public class Code {
  public static void main(String[] args) {
    Queue<String> que = new ArrayDeque<>();
    
    que.add("1??0?101");
    
    while(!que.isEmpty()) {
      String s = que.poll();
      int index = s.indexOf("?");
      if(index >= 0) {
        que.add(s.substring(0, index) + "0" + s.substring(index + 1));
        que.add(s.substring(0, index) + "1" + s.substring(index + 1));
      } else {
        System.out.println(s);
      }
      
    }
  }
}
