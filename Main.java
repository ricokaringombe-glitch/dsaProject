public class Main {
    public static void main(String[] args) {

        // ============ TASK A1: QUEUE DEMO ============
        System.out.println("########## TASK A1: QUEUE DEMO ##########");
        StudentQueue demoQueue = new StudentQueue(10);
        demoQueue.enqueue(new Student("221045678", "Maria",   "Registration", 12));
        demoQueue.enqueue(new Student("222034512", "Tomas",   "Student Card",  5));
        demoQueue.enqueue(new Student("223041876", "Ndapewa", "Fees",          8));
        demoQueue.enqueue(new Student("221067341", "Simon",   "Documents",     4));
        demoQueue.enqueue(new Student("224012345", "Anna",    "Academic",     15));
        demoQueue.enqueue(new Student("225023456", "Peter",   "Registration", 10));

        System.out.println("\n--- After 6 arrivals ---");
        demoQueue.displayQueue();

        System.out.println("\n--- Serving 3 students ---");
        for (int i = 0; i < 3; i++) {
            Student s = demoQueue.dequeue();
            System.out.println("Served: " + s.getName());
        }

        System.out.println("\n--- After 3 services ---");
        demoQueue.displayQueue();

        // ============ TASK A2: LINKED LIST DEMO ============
        System.out.println("\n########## TASK A2: LINKED LIST DEMO ##########");
        StudentLinkedList list = new StudentLinkedList();
        list.insertAtBeginning("221045678", "Maria",   "Registration", 12);
        list.insertAtEnd      ("222034512", "Tomas",   "Student Card",  5);
        list.insertAtEnd      ("223041876", "Ndapewa", "Fees",          8);
        list.insertAtPosition ("221067341", "Simon",   "Documents",     4, 3);

        System.out.println("\n--- After insertions ---");
        list.displayStudents();

        System.out.println("\n--- Search Tomas ---");
        list.searchStudent("222034512");

        System.out.println("\n--- Delete Tomas ---");
        list.deleteStudent("222034512");

        System.out.println("\n--- After deletion ---");
        list.displayStudents();

        // ============ TASK A3: POSTFIX ============
        System.out.println("\n########## TASK A3: POSTFIX EVALUATION ##########");
        PostfixEvaluator pe = new PostfixEvaluator(20);
        String expr = "5 3 + 2 *";
        System.out.println("Expression: " + expr);
        int result = pe.evaluate(expr);
        System.out.println("Final Result: " + result);

        // ============ TASK A4: STATISTICS ============
        System.out.println("\n########## TASK A4: DAILY STATISTICS ##########");
        int[] times = {12, 5, 8, 4, 15, 10, 7, 20, 6, 9};
        DailyStatistics.calculate(times, times.length);

        // ============ TASKS B1-B4: SORTING ============
        int[] original = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        System.out.println("\n########## TASK B1: SELECTION SORT ##########");
        SortingAlgorithms.selectionSort(original.clone());

        System.out.println("\n########## TASK B2: INSERTION SORT ##########");
        SortingAlgorithms.insertionSort(original.clone());

        System.out.println("\n########## TASK B3: MERGE SORT ##########");
        int[] mergeArr = original.clone();
        SortingAlgorithms.mergeSort(mergeArr, 0, mergeArr.length - 1);
        System.out.println("Sorted: " + SortingAlgorithms.arrayToString(mergeArr));

        System.out.println("\n########## TASK B4: QUICK SORT ##########");
        int[] quickArr = original.clone();
        SortingAlgorithms.quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("Sorted: " + SortingAlgorithms.arrayToString(quickArr));

        // ============ PART D: INTEGRATED SYSTEM ============
        System.out.println("\n########## PART D: INTEGRATED SYSTEM ##########");
        ServiceCentreSystem system = new ServiceCentreSystem();
        system.run();
    }
}