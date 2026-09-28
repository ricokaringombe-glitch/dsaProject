import java.util.Random;

public class SortingExperiment {

    public static void run() {
        int[] sizes = {20, 50, 100, 500};
        Random rand = new Random(42);

        System.out.printf("%-12s %-6s %-15s %-15s%n",
                "Algorithm", "Size", "Comparisons", "Time (ns)");
        System.out.println("----------------------------------------------------------");

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) {
                original[i] = rand.nextInt(1000) + 1;
            }
            runOne("Selection", original.clone(), size, "selection");
            runOne("Insertion", original.clone(), size, "insertion");
            runOne("Merge",     original.clone(), size, "merge");
            runOne("Quick",     original.clone(), size, "quick");
            System.out.println();
        }
    }

    private static void runOne(String name, int[] arr, int size, String type) {
        SortingAlgorithms.comparisons = 0;
        long start = System.nanoTime();
        switch (type) {
            case "selection": SortingAlgorithms.selectionSort(arr); break;
            case "insertion": SortingAlgorithms.insertionSort(arr); break;
            case "merge":     SortingAlgorithms.mergeSort(arr, 0, arr.length - 1); break;
            case "quick":     SortingAlgorithms.quickSort(arr, 0, arr.length - 1); break;
        }
        long end = System.nanoTime();
        System.out.printf("%-12s %-6d %-15d %-15d%n",
                name, size, SortingAlgorithms.comparisons, (end - start));
    }
}