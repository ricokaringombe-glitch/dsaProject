public class StudentLinkedList {
    private StudentNode head;

    public StudentLinkedList() { this.head = null; }

    public void insertAtBeginning(String no, String name, String type, int time) {
        StudentNode n = new StudentNode(no, name, type, time);
        n.next = head;
        head = n;
    }

    public void insertAtEnd(String no, String name, String type, int time) {
        StudentNode n = new StudentNode(no, name, type, time);
        if (head == null) { head = n; return; }
        StudentNode c = head;
        while (c.next != null) c = c.next;
        c.next = n;
    }

    public void insertAtPosition(String no, String name, String type, int time, int pos) {
        if (pos == 1) { insertAtBeginning(no, name, type, time); return; }
        StudentNode n = new StudentNode(no, name, type, time);
        StudentNode c = head;
        for (int i = 1; i < pos - 1; i++) {
            if (c == null) { System.out.println("Position out of bounds"); return; }
            c = c.next;
        }
        if (c == null) { System.out.println("Position out of bounds"); return; }
        n.next = c.next;
        c.next = n;
    }

    public void deleteStudent(String studentNo) {
        if (head == null) { System.out.println("List is empty"); return; }
        if (head.studentNo.equals(studentNo)) {
            head = head.next;
            System.out.println("Deleted: " + studentNo);
            return;
        }
        StudentNode c = head;
        while (c.next != null && !c.next.studentNo.equals(studentNo)) c = c.next;
        if (c.next == null) System.out.println("Student not found: " + studentNo);
        else {
            c.next = c.next.next;
            System.out.println("Deleted: " + studentNo);
        }
    }

    public StudentNode searchStudent(String studentNo) {
        StudentNode c = head;
        int pos = 1;
        while (c != null) {
            if (c.studentNo.equals(studentNo)) {
                System.out.println("Found at position " + pos + ": " + c.name);
                return c;
            }
            c = c.next;
            pos++;
        }
        System.out.println("Student not found: " + studentNo);
        return null;
    }

    public void displayStudents() {
        if (head == null) { System.out.println("List is empty"); return; }
        System.out.println("=== Student Service Records ===");
        StudentNode c = head;
        while (c != null) { System.out.println(c); c = c.next; }
    }

    public StudentNode getHead() { return head; }
}