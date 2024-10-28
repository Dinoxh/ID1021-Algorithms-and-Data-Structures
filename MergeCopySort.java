package src.main.java.dsaSchool;

public class MergeCopySort {
    public static void main(String[] args){
        int[] arr = {1,0,9,8,7,6,5,4,3,2};

        // Create an auxiliary array to use in the toggling process
        int[] auxArray = arr.clone();

        mergeSort(arr, auxArray, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // The modified mergeSort method that toggles between the original and auxiliary arrays
    private static void mergeSort(int[] original, int[] auxArray, int low, int high) {
        if (low >= high) { // Base case: one element
            return;
        }

        int middle = (low + high) / 2;

        // Sort the first half in auxArray, result placed in original
        mergeSort(auxArray, original, low, middle);

        // Sort the second half in auxArray, result placed in original
        mergeSort(auxArray, original, middle + 1, high);

        // Merge the two halves from auxArray into original
        merge(auxArray, original, low, middle, high);
    }

    // Merge the sorted arrays from the auxiliary array into the original array
    private static void merge(int[] auxArray, int[] original, int low, int middle, int high) {
        int i = low, j = middle + 1, k = low;

        // Merge the two halves from auxArray into original
        while (i <= middle && j <= high) {
            if (auxArray[i] <= auxArray[j]) {
                original[k++] = auxArray[i++];
            } else {
                original[k++] = auxArray[j++];
            }
        }

        // Copy any remaining elements from the left half
        while (i <= middle) {
            original[k++] = auxArray[i++];
        }

        // Copy any remaining elements from the right half
        while (j <= high) {
            original[k++] = auxArray[j++];
        }
    }
}
