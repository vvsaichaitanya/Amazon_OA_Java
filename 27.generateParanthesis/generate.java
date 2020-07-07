class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }
    
    public void backtrack(String curr, int open, int close, int max, List<String> res) {
        if(curr.length() == max * 2) {
            res.add(curr);
            return;
        }
        
        if(open < max) backtrack(curr + "(", open + 1, close, max, res);
        if(close < open) backtrack(curr + ")", open, close + 1, max, res);
    }
}