class Solution {
    public int[] sumZero(int n) {
        if (n == 0) return new int[n];
        if (n == 1) return new int[n];
        
        int[] res = new int[n];
        int sum = 0;
        int i = n % 2 == 0 ? 0 : 1;
        if (i == 1) res[0] = 0;
            
        for( ; i < n; i+=2) {
            int resNum = i + 1;
            res[i] = resNum;
            res[resNum] = (resNum) * -1;
        }
        
        return res;
    }
}