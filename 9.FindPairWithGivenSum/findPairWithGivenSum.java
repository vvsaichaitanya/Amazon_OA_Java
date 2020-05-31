import java.util.*;

class Solution {
    public static void main(String[ ] args) {
      int target = 90;
      int newTarget = target-30;
      int[] nums = {20, 50, 40, 25, 30, 10};
      Map<Integer, Integer> resMap = new HashMap<>();
			List<Integer> res = new ArrayList<>();
      
      for(int i=0;i<nums.length;i++){
        int num = nums[i];
        int complement = newTarget-num;

        if(resMap.get(complement)!=null){
          if(res.size()==0){
            res.add(resMap.get(complement));
            res.add(i);
          } else{
            if(num > res.get(0) || num > res.get(1) || (complement)> res.get(0) || (complement) > res.get(1)){
              res.clear();
              res.add(resMap.get(complement));
              res.add(i);
            }
          }
        }else{
          resMap.put(num, i);
        }
      }
      System.out.println(res.get(0));
            System.out.println(res.get(1));
    }
}