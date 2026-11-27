class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if (exp < 0) {
            return 1.0 / fastPow(x, -exp);
        }
        return fastPow(x, exp);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
