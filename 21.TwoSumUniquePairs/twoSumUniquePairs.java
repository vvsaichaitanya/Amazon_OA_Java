import java.util.*;

public class Code {
    public static void main(String[] args) {
      int[] nums = {1, 1, 2, 45, 46, 46};
      int target = 47, count = 0;
      
      Map<Integer, Integer> seen = new HashMap<>();
      
      for(int num: nums) {
        int diff = target - num;
        if(seen.get(diff) == null)
          seen.put(num, -1);
        else
          seen.put(diff, num);
      }
      
      for(int num: seen.keySet())
        if(seen.get(num) != -1)
          count++;
      
    	System.out.println(count);
	}
}
