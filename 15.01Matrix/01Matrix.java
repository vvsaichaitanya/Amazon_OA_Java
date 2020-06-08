class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0) return matrix;
        int row = matrix.length, col = matrix[0].length;
        Queue<position> que = new ArrayDeque<>();
        
        for(int i = 0;i < row; i++)
            for(int j = 0; j < col; j++)
                if(matrix[i][j] == 1) 
                    matrix[i][j] = Integer.MAX_VALUE;
                else
                    que.add(new position(i, j));
                
        while(!que.isEmpty()) {
            position point = que.poll();
            
                if(point.i + 1 < row && matrix[point.i][point.j] + 1 < matrix[point.i + 1][point.j]){
                    matrix[point.i + 1][point.j] = matrix[point.i][point.j] + 1;
                    que.add(new position(point.i + 1, point.j));
                }
                if(point.i - 1 >= 0 && matrix[point.i][point.j] + 1 < matrix[point.i - 1][point.j]){
                    matrix[point.i - 1][point.j] = matrix[point.i][point.j] + 1;
                    que.add(new position(point.i - 1, point.j));
                }
                if(point.j + 1 < col && matrix[point.i][point.j] + 1 < matrix[point.i][point.j + 1]){
                    matrix[point.i][point.j + 1] = matrix[point.i][point.j] + 1;
                    que.add(new position(point.i, point.j + 1));
                }
                if(point.j - 1 >= 0 && matrix[point.i][point.j] + 1 < matrix[point.i][point.j - 1]){
                    matrix[point.i][point.j - 1] = matrix[point.i][point.j] + 1;
                    que.add(new position(point.i, point.j - 1));
                }
            }
        return matrix;
    }
    
    public class position {
        int i;
        int j;
        
        position(int x, int y){
            i = x;
            j = y;
        }
    }
}