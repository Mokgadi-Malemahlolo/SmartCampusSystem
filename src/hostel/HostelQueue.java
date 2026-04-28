package hostel;

public class HostelQueue {
    private String[] studentNames;
    private String[] studentIDs;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public HostelQueue(int capacity) {
        this.capacity = capacity;
        studentNames = new String[capacity];
        studentIDs = new String[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(String name, String id) {
        if (isFull()) {
            System.out.println("Waiting list is full!");
            return;
        }
        studentNames[rear] = name;
        studentIDs[rear] = id;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println(name + " added to waiting list.");
    }

    public String[] dequeue() {
        if (isEmpty()) {
            System.out.println("No students in waiting list!");
            return null;
        }
        String[] student = {studentNames[front], studentIDs[front]};
        front = (front + 1) % capacity;
        size--;
        return student;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Waiting list is empty.");
            return;
        }
        System.out.println("--- Waiting List ---");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println((i + 1) + ". " + studentNames[index] + " (ID: " + studentIDs[index] + ")");
        }
    }
}