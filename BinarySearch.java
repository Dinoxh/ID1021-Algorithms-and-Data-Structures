package src.main.java.dsaSchool;




public class BinarySearch {
    public static void main(String[] args){

        int array[] = new int[1000];
        int target = 700;

        for(int i = 0 ; i < array.length ; i++){
            array[i] = i; //creates a sorted array with elements 0 to 99
        }

        long start = System.nanoTime();
        int index = binarySearch(array,target); //if target is not in the array, will return -1
        long end = System.nanoTime();



        if(index == -1){
            System.out.println("Target not found");
        }
        else{
            System.out.println("Target found at index " + index);
        }

        System.out.println("Binary Search Time (ms): " + (end - start));

    }



    public static int binarySearch(int[] array, int target){
        int low = 0 ;
        int high = array.length -1 ;

        while(low <= high){
            int mid = low + (high - low)/2;
            int value = array[mid];

            System.out.println("middle: " + value);

            if(value < target){
                low = mid + 1;
            }
            else if(value > target){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}


