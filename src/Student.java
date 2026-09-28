public class Student {
    String studentNo;
    String name;
    String serviceType;
    int serviceTime;

    public Student(String studentNo, String name, String serviceType, int serviceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return studentNo + " | " + name + " | " + serviceType + " | " + serviceTime + " min";
    }
}
