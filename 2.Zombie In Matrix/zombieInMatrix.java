import java.util.*;

class Playground {
    public static void main(String[ ] args) {
        int[][] zombieMatrix = {
                                 {0, 1, 1, 0, 1},
                                 {0, 1, 0, 1, 0},
                                 {0, 0, 0, 0, 1},
                                 {0, 1, 0, 0, 0}
                                 };
        int hrs = minimumHours(zombieMatrix);
        System.out.println("the minimum hrs to convert all humans to zombies is: " + hrs);
    }
    
    public static int minimumHours(int[][] grid) {
        Deque<position> que = new ArrayDeque<>();
        int hrs = -1;
        
        // add all 1's to the queue
        for (int i=0; i< grid.length;i++)
            for (int j=0;j<grid[0].length;j++)
                if (grid[i][j]== 1) {
                    que.add(new position(i,j));
                }
                
        // keep adding the next set of 1's if the que is not alreayd empty
        while(!que.isEmpty()){
            int i = que.size();
            for(;i>0;i--){
                position point = que.remove();
            
                if(point.x - 1>=0 && grid[point.x-1][point.y]==0){grid[point.x-1][point.y]=1; que.add(new position(point.x-1, point.y));}
                if(point.x + 1< grid[0].length-1 && grid[point.x+1][point.y]==0){grid[point.x+1][point.y]=1; que.add(new position(point.x+1, point.y));}
                if(point.y-1>=0 && grid[point.x][point.y-1]==0){grid[point.x][point.y-1]=1; que.add(new position(point.x, point.y-1));}
                if(point.y+1 < grid.length-1 && grid[point.x][point.y+1]==0){grid[point.x][point.y+1]=1; que.add(new position(point.x, point.y+1));}
            }
        
            hrs++;
        }
        
        return hrs;
    }
    
    
    static class position {
        int x;
        int y;
        
        position(int xc, int yc){
            x=xc;
            y=yc;
        }
    }
}