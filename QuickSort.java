package src.main.java.dsaSchool;
// quick sort = moves smaller elements to left of a pivot.
//     recursively divide array in 2 partitions

// run-time complexity = Best case O(n log(n))
//                                        Average case O(n log(n))
//                                        Worst case O(n^2) if already sorted

// space complexity    = O(log(n)) due to recursion

public class QuickSort  {
    public static void main(String[] args) {
        int[] arr = {1,0,9,8,7,6,5,4,3,2};

        for(int i = 0 ; i < 10 ; i++){
            long start = System.nanoTime();
            quickSort(arr,0,arr.length-1);
            long end = System.nanoTime();
            System.out.println("Runtime: " + (end-start));
        }
        for(int i : arr){
            System.out.println(i + " ");
        }

    }

    public static void quickSort(int[] arr, int start, int end){
        if(end <= start){
            return;
        }

        int pivot = part(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    public static int part(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end - 1 ; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}
