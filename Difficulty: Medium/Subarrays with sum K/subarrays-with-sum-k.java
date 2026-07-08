import java.util.HashMap;

class Solution {

    public int cntSubarrays(int[] arr, int k) {

        int n = arr.length;
        int answer = 0;

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        HashMap<Integer, Integer> prefixFrequency = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (prefixSum[i] == k) {
                answer++;
            }

            int remaining = prefixSum[i] - k;

            if (prefixFrequency.containsKey(remaining)) {
                answer += prefixFrequency.get(remaining);
            }

            prefixFrequency.put(
                prefixSum[i],
                prefixFrequency.getOrDefault(prefixSum[i], 0) + 1
            );
        }

        return answer;
    }
}