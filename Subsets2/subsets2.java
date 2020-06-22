class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        perm(0, nums, res, new ArrayList<Integer>());
        return res;
    }
    
    public static void perm(int start, int[] inp, List<List<Integer>> res, List<Integer> curr) {
    res.add(new ArrayList<Integer>(curr));
    for(int i = start;i < inp.length;i++) {
        if(i > start && inp[i] == inp[i - 1]) continue;
      curr.add(inp[i]);
      perm(i+1, inp, res, curr);
      curr.remove(curr.size()-1);
    }
}}