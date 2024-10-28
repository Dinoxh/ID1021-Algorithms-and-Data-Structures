package src.main.java.dsaSchool;
// Insertion sort = after comparing elements to the left,
//    shift elements to the right to make room to insert a value

//     Quadratic time O(n^2)
//     small data set = decent
//     large data set = BAD

//     Less steps than Bubble sort
//     Best case is O(n) compared to Selection sort O(n^2)
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,0,9,8,7,6,5,4,3,2};
        for(int i = 0 ; i < 10 ; i++){
            long start = System.nanoTime();
            insertionSort(arr);
            long end = System.nanoTime();
            System.out.println("Runtime: " + (end-start));
        }
    }

    private static void insertionSort(int[] arr) {

        for(int i = 1 ; i < arr.length ; i++){
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

}
