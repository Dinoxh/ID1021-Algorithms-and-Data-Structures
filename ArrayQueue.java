package src.main.java.dsaSchool;



public class ArrayQueue {
    Integer[] array;
    int elements;
    int startP;
    int size;

    public ArrayQueue(int size) {
        this.size = size;
        this.array = new Integer[size];
        this.elements = 0;
        this.startP = 0;
    }

    public void enqueue(Integer item) {
        if (elements == size) {
            increaseCapacity();

        }
        array[(startP  + elements) % size] = item;
        elements++;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            return null;
        }
        int item = array[startP];
        array[startP] = null;

        startP++;

        if (startP % size == 0) startP = 0;
        elements--;

        return item;
    }
    public boolean isEmpty() {
        if (elements == 0) return true;
        else return false;
    }

    //Double the capacity of the queue
    private void increaseCapacity(){
        int newSize = size* 2;
        Integer[] newArray = new Integer[newSize];

        int counter = 0;
        for (int i = 0; i < elements; i++) {

            newArray[counter] = array[startP++];
            counter++;

            if (startP % size == 0) startP = 0;
        }
        startP = 0;
        this.size = newSize;

        array = newArray;
    }


}
