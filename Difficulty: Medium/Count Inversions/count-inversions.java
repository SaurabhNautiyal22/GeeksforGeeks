class Solution {

    static int merge(int[] arr, int left, int mid, int right) {

        ArrayList<Integer> merged = new ArrayList<>();

        int first = left;
        int second = mid + 1;
        int inversionCount = 0;

        while (first <= mid && second <= right) {

            if (arr[first] <= arr[second]) {
                merged.add(arr[first]);
                first++;
            } else {
                merged.add(arr[second]);
                second++;

                inversionCount += (mid - first + 1);
            }
        }

        while (first <= mid) {
            merged.add(arr[first]);
            first++;
        }

        while (second <= right) {
            merged.add(arr[second]);
            second++;
        }

        for (int index = 0; index < merged.size(); index++) {
            arr[left + index] = merged.get(index);
        }

        return inversionCount;
    }

    static int mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int leftInversions = mergeSort(arr, left, mid);
        int rightInversions = mergeSort(arr, mid + 1, right);

        int currentInversions = merge(arr, left, mid, right);

        return leftInversions + rightInversions + currentInversions;
    }

    static int inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}