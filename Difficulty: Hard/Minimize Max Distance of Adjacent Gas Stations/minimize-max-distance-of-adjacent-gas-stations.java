class Solution {
    public double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = stations[stations.length - 1] - stations[0];

        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2;
            int count = 0;

            for (int i = 1; i < stations.length; i++) {
                count += (int) Math.ceil(
                    (stations[i] - stations[i - 1]) / mid
                ) - 1;
            }

            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }
}