class Solution {
    public String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();

        while (num > 0) {
            if (num / 1000 >= 1) {
                num -= 1000;
                ans.append("M");
            } else if (num / 900 == 1) {
                num -= 900;
                ans.append("CM");
            } else if (num / 500 >= 1) {
                num -= 500;
                ans.append("D");
            } else if (num / 400 == 1) {
                num -= 400;
                ans.append("CD");
            } else if (num / 100 >= 1) {
                num -= 100;
                ans.append("C");
            } else if (num / 90 == 1) {
                num -= 90; 
                ans.append("XC");
            } else if (num / 50 >= 1) {
                num -= 50;
                ans.append("L");
            } else if (num / 40 == 1) {
                num -= 40;
                ans.append("XL");
            } else if (num / 10 >= 1){
                num -= 10;
                ans.append("X");
            } else if (num / 9 == 1) {
                num -= 9;
                ans.append("IX");
            } else if (num / 5 >= 1){
                num -= 5;
                ans.append("V");
            } else if (num / 4 == 1) {
                num -= 4;
                ans.append("IV");
            } else {
                num -= 1;
                ans.append("I");
            }
        }

        return ans.toString();
    }
}