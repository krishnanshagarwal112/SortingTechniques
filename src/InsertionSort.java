import java.util.Arrays;

public class InsertionSort {
    // FOR EVERY INDEX, PUT THE INDEX ELEMENT AT THE CORRECT PLACE ON LHS


    // Q) WHY INSERTION SORT IS USED ?
    // A) 1) NUMBER OF SWAPS REDUCED AS COMPARED TO BUBBLE SORT
    //    2) IT IS STABLE SORTING ALGO
    //    3) USED FOR SMALLER VALUES OF N
    //    4) WORKS BEST WHEN ARRAY IS PARTIALLY SORTED
    //    5) THEREFORE TAKES PART IN HYBRID-SORTING ALGOs


    public static void main(String[] args) {
        int[] arr = {1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                } else{
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int ele1, int ele2){
        int temp = arr[ele1];
        arr[ele1] = arr[ele2];
        arr[ele2] = temp;
    }
}
