package src.main.java.dsaSchool;


// move forward one position in array: element = arr[i++];

public class SelectionSort {
    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++){
            long start = System.nanoTime();
            sort();
            long end = System.nanoTime();
            System.out.println("Runtime: " + (end-start));
        }
    }


    public static void sort(){
        int[] arr = {1,0,9,8,7,6,5,4,3,2};
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int min = i;
            for(int j = i ; j < arr.length ; j++){
                if(arr[min]>arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
