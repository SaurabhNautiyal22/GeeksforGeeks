class Solution {

    int maxSubarraySum(int[] arr) {

        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        for (int number : arr) {

            currentSum += number;

            maximumSum = Math.max(maximumSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maximumSum;
    }
}