class Solution {
    public String minWindow(String s, String t) {
        
        if (t.length() > s.length()) return "";
        
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        
        String minStr = s;
        int lIdx = 0;
        int rIdx = 0;
        int cnt = t.length();
        boolean find = false;
        
        while (rIdx < s.length()) {
            Character end = s.charAt(rIdx);
            if (target.containsKey(end)) {
                target.put(end, target.get(end) - 1);
                if (target.get(end) >= 0) cnt--;
            }
            
            rIdx++;
            if (cnt > 0) continue;
            
            find = true;
            
            while (cnt == 0) {
                Character start = s.charAt(lIdx);
                if (target.containsKey(start)) {
                    target.put(start, target.get(start) + 1);
                    if (target.get(start) > 0) cnt++;
                }
                lIdx++;
            }
            
            if (rIdx - (lIdx - 1) < minStr.length()) {
                minStr = s.substring(lIdx - 1, rIdx);
            }
        }
        
        return find ? minStr : "";
        
    }
}