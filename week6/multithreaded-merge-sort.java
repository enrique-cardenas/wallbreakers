import java.util.concurrent.*;
import java.util.Random;

class MultithreadedMergeSort{
    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool();
        

        // create array with random integers
        int size = 100;
        int[] array = new int[size];
        Random rand = new Random();
        System.out.println("Before:");
        for(int i = 0; i < size; i++){
            array[i] = rand.nextInt(1000);
            System.out.print(array[i] + " ");
        }
        
        // Being merge sort
        MergeSort mergeSort = new MergeSort(array, 0, array.length - 1);
        pool.invoke(mergeSort);
    
        System.out.println();
        System.out.println("After:");
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }

    }
}


class MergeSort extends RecursiveAction{
    private int[] array;
    private int left;
    private int right;

    public MergeSort(int[] array, int left, int right){
        this.array = array;
        this.left = left;
        this.right = right;
    }

    protected void compute(){
        if(left < right){
            int mid = (left + right) / 2;
            RecursiveAction leftSort = new MergeSort(array, left, mid);
            RecursiveAction rightSort = new MergeSort(array, mid + 1, right);
            invokeAll(leftSort, rightSort);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        int x = left;
        int y = mid + 1;
        while(x <= mid && y <= right){
            if(array[x] <= array[y]){
                temp[tempIndex++] = array[x++];
            }
            else{
                temp[tempIndex++] = array[y++];
            }
        }

        while(x <= mid) temp[tempIndex++] = array[x++];

        while(y <= right) temp[tempIndex++] = array[y++];

        for(int i = 0; i < temp.length; i++){
            array[left + i] = temp[i];
        }
        
    }

}