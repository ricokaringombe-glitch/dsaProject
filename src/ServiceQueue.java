public class ServiceQueue {

    // node used inside the queue
    private class QueueNode {
        Student data;
        QueueNode next;

        QueueNode(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public ServiceQueue() {
        front = null;
        rear = null;
    }

    // check if queue is empty
    public boolean isEmpty() {
        return (front == null && rear == null);
    }

    // add student to the back of the queue
    public void enqueue(Student student) {
        QueueNode newNode = new QueueNode(student);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued -> " + student);
    }

    // remove and serve the student at the front
    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty - no student to serve.");
            return null;
        }
        Student served = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println("Served (dequeued) -> " + served);
        return served;
    }

    // look at the front student without removing them
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return front.data;
    }

    // show all students currently in the queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("---- Waiting Queue (front -> rear) ----");
        QueueNode temp = front;
        int position = 1;
        while (temp != null) {
            System.out.println(position + ". " + temp.data);
            temp = temp.next;
            position++;
        }
        System.out.println("----------------------------------------");
    }
}
