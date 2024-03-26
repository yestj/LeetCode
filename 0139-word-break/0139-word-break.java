class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int N = s.length();
        
        HashSet<String> dict = new HashSet<>();
        for (String str : wordDict) dict.add(str);

        boolean[] dp = new boolean[N + 1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; j >= 0; j--){
                 if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                 }
            }
        }

        return dp[N];
    }
}