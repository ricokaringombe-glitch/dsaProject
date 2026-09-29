public class StudentQueue {
    private Student[] queue;
    private int front, rear, size, capacity;

    public StudentQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Student[capacity];
        this.front = -1; this.rear = -1; this.size = 0;
    }

    public void enqueue(Student student) {
        if (rear == capacity - 1) { System.out.println("Queue is full"); return; }
        if (front == -1) front = 0;
        queue[++rear] = student;
        size++;
        System.out.println("Enqueued: " + student.getName());
    }

    public Student dequeue() {
        if (isEmpty()) { System.out.println("Queue is empty"); return null; }
        Student served = queue[front];
        if (front == rear) { front = -1; rear = -1; }
        else front++;
        size--;
        return served;
    }

    public Student peek() { return isEmpty() ? null : queue[front]; }
    public boolean isEmpty() { return front == -1; }

    public void displayQueue() {
        if (isEmpty()) { System.out.println("Queue is empty"); return; }
        System.out.println("FRONT ->");
        for (int i = front; i <= rear; i++) System.out.println("  " + queue[i]);
        System.out.println("<- REAR");
    }

    public int getSize() { return size; }
}