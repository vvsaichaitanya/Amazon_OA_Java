class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0){
           return logs;
        }
        PriorityQueue<String> stage = new PriorityQueue<>((w1, w2) -> w1.substring(w1.indexOf(" ")+1).equals(w2.substring(w2.indexOf(" ")+1))?w1.compareTo(w2):w1.substring(w1.indexOf(" ")+1).compareTo(w2.substring(w2.indexOf(" ")+1)));
        String[] res = new String[logs.length];
        int j = 0;
        
        for(String log: logs){
            if(!isLogDigit(log)){
                stage.add(log);
            }
        }
        
        while(!stage.isEmpty()) {
            res[j++] = stage.poll();
        }
        
        for(String log: logs){
            if(isLogDigit(log)) {
                res[j++] = log;
            }
        }
        return res;
    }
    
    public boolean isLogDigit(String log) {
        return Character.isDigit(log.charAt(log.indexOf(" ")+1));
    }
}