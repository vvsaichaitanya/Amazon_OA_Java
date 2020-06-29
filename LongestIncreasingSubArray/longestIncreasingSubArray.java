public class Code {
  public static void main(String[] args) {
    int[] inp = new int[]{12, 13, 1, 5, 4, 7, 8, 10, 10, 11}, res = new int[]{0, 0};
    int start = 0, i = 1, length = 1, max = Integer.MIN_VALUE;
    
    while(i < inp.length) {
      if(inp[i] > inp[i - 1]) {
        length++;
      } else {
        if(length > max) {
          max = length;
          res[0] = start;
          res[1] = i - 1;
        }
          length = 1;
          start = i;
      }
      i++;
    }
    
    System.out.println(res[0] + ", " + res[1]);
    System.out.println(max);
  }
}
