//arrayManipulation.java
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
//        Create an int array with exactly 5 elements
        int[] arr= new int[5];

        //Create Scanner and read exactly 5 integers with input validation
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter %d integers: ".formatted(arr.length));
        for (int i=0; i <arr.length; i++){
            System.out.print("Value %d: ".formatted(i+1)); // prompt appears before reading the rest of the code
            while (!scanner.hasNextInt()){ //input validation: ensure next token is an integer
                String notInt=scanner.next(); // consume invalid token
                System.out.println("%s is not an integer. Try again: ".formatted(notInt)); // validation statement
            }
            arr[i]=scanner.nextInt(); // store valid integer at index i (0-based)
        }
//        Print the original array inputted by the user
        System.out.printf("You entered:\n");
        for (int i = 0; i< arr.length; i++){
            if (i>0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println();

//Reverse in place (3-step swap from the ends inward)
        reverseInPlace(arr);

//        Print the reversed array
        System.out.println("Reversed array: ");
        for (int i= 0; i< arr.length; i++){
            if (i>0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println();

//        Find minimum and maximum value by scanning the array
        int max = arr[0]; //start with the first element
        int min = arr [0]; // start with the first element
        for (int i=1; i< arr.length; i++){ // check/loop/scan the elements of the array
            if (arr[i]>  max){
                max= arr[i]; // if a greater value is found it replaces the previously held value
            }if (arr[i]< min) {
                min = arr[i]; // if a smaller value is found it replaces the previously held value
            }
        }
        System.out.printf("The largest value in the array is %d and the smallest value in the array is %d.%n", max, min);

        // Sum of all values in the array
        int sum= 0;
        for (int i=0; i<arr.length; i++){
            sum += arr[i]; //adds each element to the running total
        }

        System.out.print("Sum of all values in the array: %d.%n".formatted(sum));

//        Check if array contains any even numbers
        boolean hasEven=false;
        for (int i=0; i<arr.length; i++){
            if (arr[i] % 2==0){ //value is even if remainder is zero when divided by two
                hasEven=true;
                break; // stop the loop as soon as an even number is detected in the array
            }
        }
        if (hasEven){
            System.out.println("The array contains at least one even number.");
        } else{
            System.out.println("The array does not contain any even numbers.");
        }
//close scanner after all I/O are completed (best practice to close scanner after opening)
        scanner.close();
    }
//    Swaps symettric elements to reverse the array in place
//    Example: [1,2,3,4,5] --> [5,4,3,2,1]
    private static void reverseInPlace(int[] a) {
        for (int i=0; i<a.length/2; i++){ //we only go halfway so we don't undo our changes
            int j = a.length-1-i; // index is mirrored from the right side
            int temp = a[i]; //assigning variable to remember left value
            a[i]=a[j]; // move right value to the left
            a[j]=temp; // put remembered left value to the right
        }
    }
}
