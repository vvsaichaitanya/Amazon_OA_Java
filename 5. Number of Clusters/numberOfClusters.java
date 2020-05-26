class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        
        int count = 0, rows = grid.length, cols = grid[0].length;
        for(int i=0;i < rows;i++)
            for(int j=0; j < cols;j++){
                if(grid[i][j] == '1'){
                    count++;
                    merge(grid, i, j);
                }
            }
    return count;
    }
    
    public void merge(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        
        grid[i][j] = 'x';
        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}