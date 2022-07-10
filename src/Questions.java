import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        findDuplicates(arr);
        System.out.println(findDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
    //Q1    // https://leetcode.com/problems/missing-number/
    public static int missingNumber(int[] arr){
        //FIRST WE WILL DO CYCLE SORT
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] ;
            if(correctIndex < arr.length && arr[i] != arr[correctIndex] ){
                swap(arr, i ,correctIndex);
            }
            else {
                i++;
            }
        }
        // THEN SEARCH FOR FIRST MISSING NUMBER
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index){
                return index;
            }
        }
        return arr.length;
    }

    //Q2    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    public static ArrayList<Integer> findDisappearedNumbers(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        //FIRST WE WILL DO CYCLE SORT
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] - 1 ;
            if(correctIndex < arr.length && arr[i] != arr[correctIndex] ){
                swap(arr, i ,correctIndex);
            }
            else {
                i++;
            }
        }
        // ADD THE MISSING ELEMENTS IN NEW ARRAYLIST
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index + 1){
                ans.add(index + 1);
            }
        }
        return ans;
    }

    //Q3    //https://leetcode.com/problems/find-the-duplicate-number/
    public static int findDuplicate(int[] arr) {
        //FIRST WE WILL DO CYCLE SORT
        int i = 0;
        while( i < arr.length){
            // We check that element is equal to {index + 1} or not
            // If it is then go ahead
            // If it is not then find the correct position for that element
            if(arr[i] != i + 1){
                int correctIndex = arr[i] - 1 ;
                // After finding the correct position for the elements
                // now check whether the element is equal to the element at the correct position or not
                // if not then swap
                // if yes then it is duplicate
                if(correctIndex < arr.length && arr[i] != arr[correctIndex] ){
                    swap(arr, i ,correctIndex);
                }
                else {
                    return arr[i];
                }
            }
            else {
                i++;
            }
        }

        return  -1;
    }

    //Q4    //https://leetcode.com/problems/find-all-duplicates-in-an-array/
    public static List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        //FIRST WE WILL DO CYCLE SORT
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] - 1 ;
            if(correctIndex < arr.length && arr[i] != arr[correctIndex] ){
                swap(arr, i ,correctIndex);
            }
            else {
                i++;
            }
        }
        // ADD THE DUPLICATING ELEMENTS IN NEW ARRAYLIST
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index + 1){
                ans.add(arr[index]);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int ele1, int ele2){
        int temp = arr[ele1];
        arr[ele1] = arr[ele2];
        arr[ele2] = temp;
    }
}
