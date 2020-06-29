import java.util.*;

public class Code {
  public static void main(String[] args) {
    String s = "++A*BCD";
    String res = "";
    Set<Character> operator = new HashSet<>();
    operator.add('+');
    operator.add('-');
    operator.add('*');
    operator.add('/');
    
    ArrayDeque<String> stack = new ArrayDeque<>();
    
    for(int i = s.length() - 1; i >= 0;i--) {
      if(operator.contains(s.charAt(i))) {
        String op1 = stack.pop();
        String op2 = stack.pop();
        
        res = op1 + op2 + s.charAt(i);
        stack.push(res);
      }
      else stack.push(s.charAt(i) + "");
    }
    
    System.out.println(res);
  }
}
