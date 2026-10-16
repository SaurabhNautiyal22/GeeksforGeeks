class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0) {
            n = -n;
        }

        int original = n;
        int reverse = 0;

        while (n > 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }

        return original == reverse;
    }
}