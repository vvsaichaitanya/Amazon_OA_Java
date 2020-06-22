import java.util.*;

public class Code {
  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 3};
    List<List<Integer>> res = new ArrayList();
    perm(0, input, res, new ArrayList<Integer>());
    for(List<Integer> entry: res){
      System.out.println(entry);
    }
  }
  
  public static void perm(int i, int[] inp, List<List<Integer>> res, List<Integer> curr) {
    res.add(new ArrayList<Integer>(curr));
    for(;i < inp.length;i++) {
      curr.add(inp[i]);
      perm(i+1, inp, res, curr);
      curr.remove(curr.size()-1);
    }
  }
}
