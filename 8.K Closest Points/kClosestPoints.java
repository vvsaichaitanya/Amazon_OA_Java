class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points.length == 0) return points;              
        PriorityQueue<position> kPoints = new PriorityQueue<position>((w1, w2) -> (int)(w2.distance - w1.distance));   
        
        for(int i=0;i < points.length; i++){
            kPoints.offer(new position(i, calculateDist(points[i][0], points[i][1])));
            if(kPoints.size()>K){
                kPoints.poll();
            }
        }
        
        int[][] res = new int[K][2];
        int i= 0;
        
        while(!kPoints.isEmpty()){
            position point = kPoints.poll();
            res[i][0] = points[point.index][0];
            res[i++][1] = points[point.index][1];
        }
        return res;
    }
    
    public int calculateDist(int x, int y){
        return (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    class position {
        int index;
        int distance;
        
        position(int idx, int dst){
            index = idx;
            distance = dst;
        }
    }
}