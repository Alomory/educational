package educational.c3013.c3013;
import java.util.Scanner;
// import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] array; 

        // loop that convert next line of input into int array
        boolean lockdown = true; 
        do {
            // input
            System.out.println("Enter sequence of integers:");
            String input = scanner.nextLine(); 

            // split input
            // "\\s+" is regex pattern for multi-space delimiter (e.g. "1  2 3   4")
            String[] chunks = input.split("\\s+"); 

            // declare array size
            array = new int[chunks.length];

            // try converting input into int
            try {
                for (int i = 0; i < chunks.length; i++)
                array[i] = Integer.valueOf(chunks[i]); 
                
                // if code run perfectly until here, the loop will be broken
                lockdown = false; 
            } catch (NumberFormatException e) {
                // Informing user that they has major skill issue
                System.out.println("Check your input\n");
            }
        } while (lockdown); 
        
        /* 
        1 liner version (line 15 - line 30, excluding try-catch clause)
        - pros: saves A LOT of space
        - cons: borderline unreadable, requires Arrays class

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(token -> Integer.parseInt(token)).toArray();
        */

        // perform sort on array
        long startTime = System.nanoTime(); // Start timer in nanoseconds
        selection_sort(array);
        long stopTime = System.nanoTime() - startTime;

        // output sorted result
        System.out.println("Sorted sequence:");
        for (int i : array)
            System.out.print(i + " ");
        System.out.print("\n");

        // output runtime
        System.out.println("Time taken:");
        /* Note
        - nanoTime() return nanoseconds;
        - 1ns = 10E-9s
        - 10E is equivalent to "10 power of"
        */
        System.out.println(((double) stopTime) / 1000000000 + "s"); 

        // cleanup
        scanner.close();
    }

    public static void selection_sort(int[] array) {
        // start a loop starting from first value, array[i] is current value
        for (int i = 0; i < array.length - 1; i++) {
            // start a loop starting from value after current, array[j] is next value
            for (int j = i + 1; j < array.length; j++) {
                // perform sort if current is larger than next(s)
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
