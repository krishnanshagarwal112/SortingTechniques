import java.util.Arrays;

public class CycleSort {
    // When given numbers from 1 to N, use CYCLE SORT

    public static void main(String[] args) {
        int[] arr = {4,3,1,2};
        cycleSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//
//        }

        System.out.println(Arrays.toString(arr));
    }
    static void cycleSort(int[] arr){
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swap(arr, i ,correctIndex);
            }
            else {
                i++;
            }
        }
    }
    static void swap(int[] arr, int ele1, int ele2){
        int temp = arr[ele1];
        arr[ele1] = arr[ele2];
        arr[ele2] = temp;
    }
}
