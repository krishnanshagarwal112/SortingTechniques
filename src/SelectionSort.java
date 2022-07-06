import java.util.Arrays;

// We fill find the max index and place it at its right position

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {-1,2,3,-9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i <len - 1 ;i++) {
            // FIND THE INDEX OF MAX ELEMENT IN THE NON-SORTED ARRAY
            int maxIndex = 0;
            for (int j = 0; j < len - i; j++) {
                // WE CHECK IN ONLY NON-SORTED ARRAY
                if(arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            // WE PLACE THE MAX ELEMENT IN NON-SORTED ARRAY AT ITS CORRECT POSITION
            // THEN CHECK AGAIN IN NON-SORTED ARRAY
            swap(arr,maxIndex, len -i - 1);
        }
    }
    static void swap(int[] arr, int ele1, int ele2){
        int temp = arr[ele1];
        arr[ele1] = arr[ele2];
        arr[ele2] = temp;
    }
}
