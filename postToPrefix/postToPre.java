import java.util.*;

public class Code {
  public static void main(String[] args) {
    String s = "ABC*+D+";
    String res = "";
    Set<Character> operator = new HashSet<>();
    operator.add('+');
    operator.add('-');
    operator.add('*');
    operator.add('/');
    
    ArrayDeque<String> stack = new ArrayDeque<>();
    
    for(int i = 0; i < s.length(); i++) {
      if(operator.contains(s.charAt(i))) {
        String op1 = stack.pop();
        String op2 = stack.pop();
        
        res = s.charAt(i) + op2 + op1;
        stack.push(res);
      } else {
        stack.push(s.charAt(i) + "");
      }
    }
    
    System.out.println(res);
  }
}
