class Solution {
    public int uniquePaths(int m, int n) {
        if(m+n == 0) return 0;
        int[][] mat = new int[m][n];
        
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
            {
                if(i == 0 || j == 0)
                    mat[i][j] = 1;
                else
                    mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
            }
        
        return mat[m-1][n-1];
    }
}