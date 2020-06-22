class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        perm(nums, res, new ArrayList<Integer>());
        return res;
    }
    
    public static void perm(int[] inp, List<List<Integer>> res, List<Integer> curr) {
    if(curr.size() == inp.length) res.add(new ArrayList<Integer>(curr));
        for(int i = 0;i < inp.length;i++) {
          if(curr.contains(inp[i])) continue;
          curr.add(inp[i]);
          perm(inp, res, curr);
          curr.remove(curr.size()-1);
        }
    }
}