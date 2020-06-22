public class Code {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder("3[a2[bc]]");
    int count = 0;
    while(sb.indexOf("[") >= 0) {
      int[] indexes = getIndex(sb);
      processString(sb, indexes);
      count++;
    }
    
    System.out.println(sb.toString());
  }
  
  public static int[] getIndex(StringBuilder s) {
    int[] indexes = new int[]{-1, -1};
    
    for(int i =0; i<s.length();i++) {
      Character c = s.charAt(i);
      if (c == '[') indexes[0] = i;
      if (c == ']' && indexes[1] == -1) indexes[1] = i;
    }
    return indexes;
  }
  
  public static void processString(StringBuilder s, int[] indexes) {
		StringBuilder sb = new StringBuilder();
		int count = s.charAt(indexes[0] - 1) - '0';
    for(int i = 0; i < count; i++) {
      sb.append(s.substring(indexes[0] + 1, indexes[1]));
    }
    s.replace(indexes[0] - 1, indexes[1] + 1, sb.toString());
  }
}
