class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        perm(0, target, 0, candidates, res, new ArrayList<Integer>());
        return res;
    }
    
    public static void perm(int start, int target, int sum, int[] inp, List<List<Integer>> res, List<Integer> curr) {
    if(sum > target) return;
    if(sum == target) {res.add(new ArrayList<Integer>(curr));return;}
        for(int i = start;i < inp.length;i++) {
          curr.add(inp[i]);
          perm(i, target, sum + inp[i], inp, res, curr);
          curr.remove(curr.size()-1);
        }
    }
}