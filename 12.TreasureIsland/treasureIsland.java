import java.util.*;

class Code {
    public static void main (String[] args) {
		  Character[][] map = 	{
                              {'O', 'O', 'O', 'O'},
                              {'D', 'O', 'D', 'O'},
                              {'O', 'O', 'O', 'O'},
                              {'X', 'D', 'D', 'O'}
                            };
      int steps = 0, rows = map.length, col = map[0].length;
      Queue<pos> que = new ArrayDeque<>();
      que.add(new pos(0, 0));
	    while(!que.isEmpty()) {
        int i = que.size();
        steps++;
        for(;i > 0; i-- ) {
          pos elem = que.poll();
          if  (map[elem.x][elem.y] == 'X') {
		        System.out.println("Found the treasure in steps: " + (steps-1));
            steps = -1;
            que.clear();
            break;
          }
          map[elem.x][elem.y] = 'D';
          if(elem.x+1 < rows && map[elem.x+1][elem.y]!='D'){que.add(new pos(elem.x+1, elem.y));}
		      if(elem.x-1 >= 0 && map[elem.x-1][elem.y]!='D'){que.add(new pos(elem.x-1, elem.y));}
          if(elem.y+1 < col && map[elem.x][elem.y+1]!='D'){que.add(new pos(elem.x, elem.y+1));}
          if(elem.y-1 >= 0 && map[elem.x][elem.y-1]!='D'){que.add(new pos(elem.x, elem.y-1));}
        }
      }
      if(steps!=-1) System.out.println("Treasure is not present on this map");
    }
  
  public static class pos {
    int x;
    int y;
    
    pos(int i, int j) {
      x = i;
      y = j;
    }
  }
}