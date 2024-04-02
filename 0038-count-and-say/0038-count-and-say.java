class Solution {
    public String countAndSay(int n) {

        if (n == 1)
            return "1";

        String say = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int len = say.length();
        for (int i = 0; i < len; i++) {
            int count = 1;
            while (i + 1 < len && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(count).append(say.charAt(i));
        }
        return result.toString();
        
    }
}