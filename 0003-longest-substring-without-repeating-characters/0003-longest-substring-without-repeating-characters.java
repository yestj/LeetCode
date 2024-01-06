class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int maxLength = 0;
        Set<Character> dic = new HashSet<>();

        int st = 0;

        for (int ed = 0; ed < s.length(); ed++) {
            char curr = s.charAt(ed);
            if (!dic.contains(curr)) {
                dic.add(curr);
                maxLength = Math.max(maxLength, ed - st + 1);
            } else {
                while(dic.contains(curr)) {
                    dic.remove(s.charAt(st++));
                }
                dic.add(curr);
            }
        }

        return maxLength;
    
    }
}