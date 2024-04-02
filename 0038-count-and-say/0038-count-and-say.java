class Solution {
    public String countAndSay(int n) {
        String res = "1";

        int idx = 1;

        while (idx++ < n) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;

            for (int i = 1; i < res.length(); i++) {
                if (res.charAt(i) == res.charAt(i - 1)) {
                    cnt++;
                } else {
                    sb.append(cnt);
                    sb.append(res.charAt(i - 1));
                    cnt = 1;
                }
            }
            sb.append(cnt);
            sb.append(res.charAt(res.length() - 1));
            res = sb.toString();
        }

        return res;
    }
}