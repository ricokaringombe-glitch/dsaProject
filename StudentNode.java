public class StudentNode {
    String studentNo;
    String name;
    String serviceType;
    int estimatedTime;
    StudentNode next;

    public StudentNode(String studentNo, String name, String serviceType, int estimatedTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.estimatedTime = estimatedTime;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-10s | %-15s | %2d min",
                studentNo, name, serviceType, estimatedTime);
    }
}