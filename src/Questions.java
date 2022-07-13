import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {0,1,2};
        System.out.println(firstMissingPositive(arr));


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
    public static int findDuplicate(int[] arr)  {
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
    
    //Q5    //https://leetcode.com/problems/set-mismatch/
    public static int[] findErrorNums(int[] arr) {
        int ans[] = {-1,-1};
        //First we sort
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

        for (int j = 0; j < arr.length; j++) {
            int correctNumber = j + 1;
            if(arr[j] != correctNumber){
                ans[0] = arr[j];    // Duplicate number
                ans[1] = j + 1;// Missing Number
            }
            break;
        }
        return ans;
    }

    //Q6    //https://leetcode.com/problems/first-missing-positive/
    public static int firstMissingPositive(int[] nums) {
        //FIRST BUBBLE SORT
        boolean swapped;
        // run the steps n - 1 times
        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;
            // for each step. max item will come at the last respective index
            for (int j = 1; j <= nums.length - i -1 ; j++) {
                // swap if item is smaller than previous item
                if (nums[j] < nums[j-1]){
                    //swap
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }
            // if there is no swap for i = 0, then array is sorted
            if(! swapped) {
                break;
            }
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != ans){
                ans = ans;
            }
            else{
                ans++;
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
