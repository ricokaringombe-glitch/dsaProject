package taskB1;

public class SelectionSort {


    // Counters required for Task B1
    static int comparisons = 0;
    static int swaps = 0;

    // Selection Sort method
    public static void selectionSort(int[] array) {

        // Move through each position of the array
        for (int i = 0; i < array.length - 1; i++) {

            // Assume the current position has the smallest value
            int min = i;

            // Search for the smallest value in the unsorted part
            for (int j = i + 1; j < array.length; j++) {

                // Count only comparisons between data values
                comparisons++;

                if (array[j] < array[min]) {
                    min = j;
                }
            }

            // Swap only if a smaller value was found
            if (min != i) {

                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;

                swaps++;
            }

            //  Display the array after each pass
            System.out.print("Pass " + (i + 1) + ": ");

            for (int value : array) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {

        // Given array from Task B1
        int[] serviceTimes = {
                17, 5, 23, 8, 14,
                3, 11, 20, 6, 9
        };

        System.out.println("TASK B1 - SELECTION SORT");
        System.out.println();

        System.out.println("Original array:");

        for (int value : serviceTimes) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println();

        //  Run Selection Sort
        selectionSort(serviceTimes);

        System.out.println("Final sorted array:");

        for (int value : serviceTimes) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println();

        System.out.println("Total comparisons: " + comparisons);
        System.out.println("Total swaps: " + swaps);
    }

}

