import java.util.*;

class Solution {
    public static void main(String[ ] args) {
      int[][] grid = {{5, 1},
                      {4, 5}};
			if(grid.length==0){
				System.out.println("Empty Input");
      }
      int m = grid.length, n = grid[0].length;
      int first = grid[0][0], last = grid[m-1][n-1];
      
      for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++){
	            if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
	            if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
	            if (i != 0 && j != 0) grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
	        }
      }
			System.out.println(grid[m-1][n-1]-first -last);
    }
}