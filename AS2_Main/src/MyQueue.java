/**
 * Generic version of the Queue class.
 *
 */
public class MyQueue {
    private Node front;
    private Node rear;

    /**
     * Constructor to create a new Queue
     */
    public MyQueue() {
        this.front = null;
        this.rear = null;
    }

    /**
     * Add newNode to the Queue
     * @param info
     */
    public void enqueue(Product info) {
        Node temp = new Node(info);
        //If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = temp;
            this.rear = temp;
            return;
        }
        //Add the new node at the end of queue and change rear
        this.rear.setNextNode(temp);
        this.rear = temp;
    }

    /**
     * Display the Queue on the console
     */
    public void display() {
        if (this.rear == null){
            System.out.printf("\nQueue is Empty");
            System.exit(1);
        }else {
            Node temp = this.front;
            System.out.println("ID   |Title |Quantity |Price " + "\n" + "-------------------------");
            while (temp != null){
                System.out.println(temp.getInfo());
                temp = temp.getNextNode();
            }
        }
    }

}
