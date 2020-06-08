import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        Character[][]  matrix = new Character[][]{
                                    {'S', 'O', 'O', 'S', 'S'},
                                    {'D', 'O', 'D', 'O', 'D'},
                                    {'O', 'O', 'O', 'O', 'X'},
                                    {'X', 'D', 'D', 'O', 'O'},
                                    {'X', 'D', 'D', 'D', 'O'}
                                };
        Queue<position> que= new ArrayDeque<>();
        int steps = -1, row = matrix.length, col = matrix[0].length;
        boolean flag = false;
        
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 'S')
                    que.add(new position(i, j));
                    
        while(!que.isEmpty()) {
            int i = que.size();
            steps++;
             for(;i>0;i--) {
                 position point = que.poll();
                 if(matrix[point.x][point.y] == 'X')
                     {
                         System.out.println("X found");
                         flag = true;
                         break;
                     }
                 matrix[point.x][point.y] = 'D';
                 if(point.x + 1 < row && matrix[point.x+1][point.y] != 'D') {
                     que.add(new position(point.x+1, point.y));
                 }
                 if(point.x - 1 >= 0 && matrix[point.x-1][point.y] != 'D') {
                     que.add(new position(point.x-1, point.y));
                 }
                 if(point.y + 1 < col && matrix[point.x][point.y+1] != 'D') {
                     que.add(new position(point.x, point.y+1));
                 }
                 if(point.y - 1 >= 0 && matrix[point.x][point.y-1] != 'D') {
                     que.add(new position(point.x, point.y-1));
                 }
             }
             
                     if (flag) break;
        }
            
        System.out.println(steps);
    }
    
    public static class position {
        int x;
        int y;
        
        position(int i, int j){
            x = i;
            y = j;
        }
    }
}