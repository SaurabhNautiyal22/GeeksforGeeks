import java.util.ArrayList;

class Solution {

    static int merge(int[] arr, int left, int mid, int right) {

        ArrayList<Integer> merged = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        int inversionCount = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                merged.add(arr[i]);
                i++;
            } else {
                merged.add(arr[j]);
                j++;

                inversionCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            merged.add(arr[i]);
            i++;
        }

        while (j <= right) {
            merged.add(arr[j]);
            j++;
        }

        for (int k = left; k <= right; k++) {
            arr[k] = merged.get(k - left);
        }

        return inversionCount;
    }

    static int mergeSort(int[] arr, int left, int right) {

        if (left >= right)
            return 0;

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