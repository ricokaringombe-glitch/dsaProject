import java.util.Scanner;

public class ServiceCentreSystem {

    private StudentQueue queue;
    private StudentLinkedList records;
    private int[] serviceTimes;
    private int servedCount;
    private Scanner scanner;

    public ServiceCentreSystem() {
        queue = new StudentQueue(100);
        records = new StudentLinkedList();
        serviceTimes = new int[1000];
        servedCount = 0;
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            printMenu();
            System.out.print("Select option: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:  addStudentToQueue(); break;
                case 2:  serveNextStudent(); break;
                case 3:  queue.displayQueue(); break;
                case 4:  addStudentRecord(); break;
                case 5:  records.displayStudents(); break;
                case 6:  searchStudentRecord(); break;
                case 7:  removeStudentRecord(); break;
                case 8:  DailyStatistics.calculate(serviceTimes, servedCount); break;
                case 9:  sortServiceTimes(); break;
                case 10: SortingExperiment.run(); break;
                case 11: System.out.println("Goodbye."); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 11);
    }

    private void printMenu() {
        System.out.println("\n===== CAMPUS SERVICE CENTRE =====");
        System.out.println("1.  Add student to waiting queue");
        System.out.println("2.  Serve next student");
        System.out.println("3.  Display waiting students");
        System.out.println("4.  Add student service record");
        System.out.println("5.  Display student service records");
        System.out.println("6.  Search for student record");
        System.out.println("7.  Remove student record");
        System.out.println("8.  Display daily statistics");
        System.out.println("9.  Sort service times");
        System.out.println("10. Run sorting experiment");
        System.out.println("11. Exit");
    }

    private void addStudentToQueue() {
        System.out.print("Student No: "); String no = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Service Type: "); String type = scanner.nextLine();
        System.out.print("Estimated Time (min): "); int t = scanner.nextInt(); scanner.nextLine();
        queue.enqueue(new Student(no, name, type, t));
    }

    private void serveNextStudent() {
        Student s = queue.dequeue();
        if (s != null) {
            System.out.println("Served: " + s.getName());
            if (servedCount < serviceTimes.length)
                serviceTimes[servedCount++] = s.getEstimatedTime();
        }
    }

    private void addStudentRecord() {
        System.out.print("Student No: "); String no = scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Service Type: "); String type = scanner.nextLine();
        System.out.print("Estimated Time (min): "); int t = scanner.nextInt(); scanner.nextLine();
        records.insertAtEnd(no, name, type, t);
        System.out.println("Record added.");
    }

    private void searchStudentRecord() {
        System.out.print("Enter Student No to search: ");
        records.searchStudent(scanner.nextLine());
    }

    private void removeStudentRecord() {
        System.out.print("Enter Student No to remove: ");
        records.deleteStudent(scanner.nextLine());
    }

    private void sortServiceTimes() {
        if (servedCount == 0) { System.out.println("No service times to sort."); return; }
        int[] copy = new int[servedCount];
        System.arraycopy(serviceTimes, 0, copy, 0, servedCount);
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Choice: ");
        int choice = scanner.nextInt(); scanner.nextLine();
        switch (choice) {
            case 1: SortingAlgorithms.selectionSort(copy); break;
            case 2: SortingAlgorithms.insertionSort(copy); break;
            case 3: SortingAlgorithms.mergeSort(copy, 0, copy.length - 1); break;
            case 4: SortingAlgorithms.quickSort(copy, 0, copy.length - 1); break;
            default: System.out.println("Invalid choice"); return;
        }
        System.out.println("Sorted service times: " + SortingAlgorithms.arrayToString(copy));
    }
}