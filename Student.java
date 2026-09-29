public class Student {
    private String studentNo;
    private String name;
    private String serviceType;
    private int estimatedTime;

    public Student(String studentNo, String name, String serviceType, int estimatedTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.estimatedTime = estimatedTime;
    }

    public String getStudentNo() { return studentNo; }
    public String getName() { return name; }
    public String getServiceType() { return serviceType; }
    public int getEstimatedTime() { return estimatedTime; }

    @Override
    public String toString() {
        return String.format("%-12s | %-10s | %-15s | %2d min",
                studentNo, name, serviceType, estimatedTime);
    }
}