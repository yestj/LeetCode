class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = Integer.valueOf(num1.charAt(i) - '0');
                int n2 = Integer.valueOf(num2.charAt(j) - '0');
                
                res[i + j + 1] += n1 * n2;
            }
        }
        
        for (int i = res.length - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }
        
        boolean check = false;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0 && !check) {
                check = true;
            }
            if (check) sb.append(res[i]);
        }
        
        if (sb.toString().length() == 0) {
            return "0";
        }
        
        return sb.toString();
    }
}