/*
Binary search is a method for finding the index of an element in an already-sorted array.
It works by repeatedly halving the array, picking the half that contains our element based
on whether the middle element is lesser or greater than it, until the element is found.
It's one of the simplest examples of a "divide and conquer" algorithm, which is an algorithm
that repeatedly reduces the problem into smaller sub-problems until a solution is found.
*/

public class Binary_Search {
    public static int binary_search_int(int[] arr, int x) {
        // Initialize the variables. start and end define our search space
        int start, end, midpoint;
        start = 0;
        end = arr.length - 1;
        // The main loop. Each iteration we cut our search space in half
        while (start <= end) {
            // Check the midpoint of the search space
            midpoint = start + ((end - start)/2);
            // If the midpoint is what we're looking for, return
            if (arr[midpoint] == x) {
                return midpoint;
            }
            // If the midpoint is too large, search the first half
            if (arr[midpoint] > x) {
                end = midpoint - 1;
            }
            // If the midpoint is too small, search the second half
            else {
                start = midpoint + 1;
            }
        }
        // If we never find the element, it is not in the array. In that case return -1
        return -1;
    }
    
    public static void intTester() {
        int i, x;
        // The sorted array we will search
        int[] sorted_arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        // A list of numbers not in the array, to see if our function correctly returns -1
        int[] extras = {12, -2, 34};
        for (i = 0; i < sorted_arr.length + extras.length; i += 1) {
            if (i < sorted_arr.length) {
                x = sorted_arr[i];
            }
            else {
                x = extras[i - sorted_arr.length];
            }
            System.out.print("Searching for element: " + x + "; ");
            int result = binary_search_int(sorted_arr, x);
            if (result != -1) {
                System.out.println("Element found at index: " + result);
            } else {
                System.out.println("Element not found");
            }
        }
    }
    
    public static void main(String[] args) {
        intTester();
    }
}
