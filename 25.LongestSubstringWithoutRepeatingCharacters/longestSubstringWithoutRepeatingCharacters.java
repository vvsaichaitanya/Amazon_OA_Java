class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        
        while(end < s.length()) {
            if(window.contains(s.charAt(end))) {
                window.remove(s.charAt(start++));
            } else {
                window.add(s.charAt(end++));
                max = Math.max(max, s.substring(start, end).length());
            }
        }
        
        return max;
    }
}