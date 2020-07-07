import java.util.*;

public class Code {
  public static void main(String[] args) {
    int[][] a = new int[][]{{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int[][] b = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int target = 10;
    
    Arrays.sort(a, getComparator());
    Arrays.sort(b, getComparator());
    
    List<List<Integer>> res = optUtil(a, b, target);
    for(List<Integer> r: res)
      System.out.println(r);
  }
  
  public static List<List<Integer>> optUtil(int[][] a, int[][] b, int target) {
    int low = 0, high = b.length - 1, max = Integer.MIN_VALUE;
    List<List<Integer>> res = new ArrayList<>();
    
    while(low < a.length && high >=0) {
		int sum = a[low][1] + b[high][1];
      if(sum > target) high--;
      else {
        if(sum >= max) {
          if(sum > max) {
            max = sum;
            res = new ArrayList<>();
          }
          int currHigh = high;
          while(currHigh >= 0) {
            if(b[currHigh][1] == b[high][1]) {
              res.add(new ArrayList<Integer>(Arrays.asList(a[low][0], b[currHigh][0])));
            }
            currHigh--;
          }
        }
        low++;
      }
    }
    return res;
  }
  
	public static Comparator getComparator() {
    return new Comparator<int[]>(){
      @Override
      public int compare(int[] arr1, int[] arr2) {
        return arr1[1] - arr2[1];
      }
    };
  }
}
