package dsa521s;

public class DailyStatistics {

    public static void displayStatistics() {

        // Service times of students served during the day
        int[] serviceTimes = {12, 5, 8, 4, 15, 11};

        int totalStudents = serviceTimes.length;
        int totalTime = 0;
        int highest = serviceTimes[0];
        int lowest = serviceTimes[0];
        int longerThan10 = 0;

        // Traverse the array
        for (int i = 0; i < serviceTimes.length; i++) {

            // Calculate total service time
            totalTime = totalTime + serviceTimes[i];

            // Find highest service time
            if (serviceTimes[i] > highest) {
                highest = serviceTimes[i];
            }

            // Find lowest service time
            if (serviceTimes[i] < lowest) {
                lowest = serviceTimes[i];
            }

            // Count services longer than 10 minutes
            if (serviceTimes[i] > 10) {
                longerThan10++;
            }
        }

        // Calculate average service time
        double averageTime = (double) totalTime / totalStudents;

        System.out.println();
        System.out.println("===== A4 DAILY SERVICE STATISTICS =====");
        System.out.println("Service times: 12, 5, 8, 4, 15, 11");
        System.out.println("Total students served: " + totalStudents);
        System.out.println("Total service time: " + totalTime + " minutes");
        System.out.printf("Average service time: %.2f minutes%n", averageTime);
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Services longer than 10 minutes: " + longerThan10);
    }
}