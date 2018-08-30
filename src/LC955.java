public class LC955 {
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private int[] array;

    public LC955(int n) {
        array = new int[n];
    }
    /**
     * @return:  return true if the array is full
     */
    public boolean isFull() {
        return size == array.length;
    }

    /**
     * @return: return true if there is no element in the array
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    public void enqueue(int element) {
        if (isFull()) {
            throw new RuntimeException("Queue is already full!");
        }

        rear = (front + size) % array.length;
        array[rear] = element;
        size++;
    }

    /**
     * @return: pop an element from the queue
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is already empty!");
        }

        int ele = array[front];

        front = (front + 1) % array.length;
        size--;
        return ele;
    }
}
