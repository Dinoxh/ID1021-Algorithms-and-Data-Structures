package src.main.java.dsaSchool;




public class RecursiveSearching {
    public static void main(String[] args){

        int array[] = new int[1000];
        int target = 700;

        for(int i = 0 ; i < array.length ; i++){
            array[i] = i; //creates a sorted array with elements 0 to 99
        }

        long start = System.nanoTime();
        int index = recursive(array,target, 0, array.length-1); //if target is not in the array, will return -1
        long end = System.nanoTime();



        if(index == -1){
            System.out.println("Target not found");
        }
        else{
            System.out.println("Target found at index " + index);
        }

        System.out.println("Binary Search Time (ms): " + (end - start));

    }



    private static int recursive(int[] array, int target, int low, int high){

        while(low <= high){
            int mid = low + (high - low)/2;
            int value = array[mid];

            System.out.println("middle: " + value);

            if(value < target){
                return recursive(array, target,mid + 1, high );
            }
            else if(value > target){
                return  recursive(array, target, low, mid - 1);
            }
            else{
                return mid;
            }
        }

        return -1;
    }
}


