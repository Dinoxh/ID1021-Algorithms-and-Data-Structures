package src.main.java.dsaSchool;

// merge sort = recursively divide array in 2, sort, re-combine
// run-time complexity = O(n Log n)
// space complexity    = O(n)


public class MergeSort {
    public static void main(String[] args){
        int[] arr = {1,0,9,8,7,6,5,4,3,2};

        for(int i = 0 ; i < 10 ; i++){
            long start = System.nanoTime();
            mergeSort(arr);
            long end = System.nanoTime();
            System.out.println("Runtime: " + (end-start));
        }


        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] array){
        int length = array.length;
        if(length <= 1){ //base case
            return;
        }
        int middle = length/2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for(;i < length; i++){
            if(i < middle){
                left[i] = array[i];
            }
            else{
                right[j] = array[i];
                j++;
            }

        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] arr){

        int leftSize = arr.length/2;
        int rightSize = arr.length - leftSize;

        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize){
            if(leftArr[l] < rightArr[r]){
                arr[i] = leftArr[l];
                i++;
                l++;
            }
            else{
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            arr[i] = leftArr[l];
            i++;
            l++;
        }
        while(r < rightSize){
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }
}
