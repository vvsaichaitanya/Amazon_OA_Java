class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n-1, top = 0, bottom = n-1;
        int count = 0;
        int[][] res = new int[n][n];
        
        while(count < n*n){
            for(int i = left; i <= right && count < n*n; i++) res[top][i] = ++count;
            for(int i = top + 1; i < bottom && count < n*n; i++) res[i][right] = ++count;
            for(int i = right; i >= left && count < n*n; i--) res[bottom][i] = ++count;
            for(int i = bottom - 1; i > top && count < n*n; i--) res[i][left] = ++count;
            left++;right--;top++;bottom--;
        }
        return res;
    }
}
