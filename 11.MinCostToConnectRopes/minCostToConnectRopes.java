import java.util.*;

class Solution {
    public static void main (String[] args) {
        int[] ropes = {8, 4, 6, 12};
        int cost = 0, totalCost = 0;

        if(ropes.length == 0){
            System.out.println("-1");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((num1,num2) -> num1-num2);
        
        for(int rope: ropes){
            minHeap.add(rope);
        }
        
        while(minHeap.size()>1) {
          cost = minHeap.poll() + minHeap.poll();
          minHeap.add(cost);
	        totalCost += cost;
        }

        System.out.println(totalCost);
    }
}