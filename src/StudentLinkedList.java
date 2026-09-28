public class StudentLinkedList {

    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public StudentLinkedList() {
        head = null;
    }

    // insert a new student at the start of the list
    public void insertAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at BEGINNING -> " + student);
    }

    // insert a new student at the end of the list
    public void insertAtEnd(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted at END -> " + student);
    }

    // insert a new student at a given position (1 = beginning)
    public void insertAtPosition(Student student, int position) {
        if (position <= 1 || head == null) {
            insertAtBeginning(student);
            return;
        }
        Node newNode = new Node(student);
        Node temp = head;
        int i = 1;
        while (i < position - 1 && temp.next != null) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted at POSITION " + position + " -> " + student);
    }

    // delete a student record by student number
    public boolean deleteStudent(String studentNo) {
        if (head == null) {
            System.out.println("List is empty - nothing to delete.");
            return false;
        }
        if (head.data.studentNo.equals(studentNo)) {
            System.out.println("Deleted -> " + head.data);
            head = head.next;
            return true;
        }
        Node prevNode = head;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data.studentNo.equals(studentNo)) {
                prevNode.next = temp.next;
                System.out.println("Deleted -> " + temp.data);
                return true;
            }
            prevNode = temp;
            temp = temp.next;
        }
        System.out.println("Student " + studentNo + " not found - nothing deleted.");
        return false;
    }

    // search for a student record by student number
    public Student searchStudent(String studentNo) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data.studentNo.equals(studentNo)) {
                System.out.println("Found at position " + position + " -> " + temp.data);
                return temp.data;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Student " + studentNo + " not found.");
        return null;
    }

    // display all student records
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        System.out.println("---- Student Service Records (head -> tail) ----");
        Node temp = head;
        int position = 1;
        while (temp != null) {
            System.out.println(position + ". " + temp.data);
            temp = temp.next;
            position++;
        }
        System.out.println("-------------------------------------------------");
    }
}
