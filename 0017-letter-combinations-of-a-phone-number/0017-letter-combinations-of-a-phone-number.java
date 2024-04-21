class Solution {
    
    private static String[] phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public static List<String> ans;
    
    public List<String> letterCombinations(String digits) {
        ans = new LinkedList();
        
        if (digits.equals("")) return ans;
        
        StringBuilder sb = new StringBuilder();
        dfs(0, digits, sb);
        
        return ans;
    }
    
    private void dfs(int depth, String digits, StringBuilder sb) {
        if (depth == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        int pos = digits.charAt(depth) - '2';
        String letter = phone[pos];
        int n = letter.length();
        
        for (int i = 0; i < n; i++) {
            sb.append(letter.charAt(i));
            dfs(depth + 1, digits, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}