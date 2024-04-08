class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        if (n < 0) {
            double tmp = myPow(x, n / 2 * -1);
            if ((n * -1) % 2 == 0) {
                return 1 / (tmp * tmp);
            } else {
                return 1 / (tmp * tmp * x);
            }
        } else {
            double tmp = myPow(x, n / 2);
            if (n % 2 == 0) {
                return tmp * tmp;
            } else {
                return tmp * tmp * x;
            }
        }
    }
}