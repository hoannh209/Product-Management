/**
 * Generic version of the Stack class.
 */
public class MyStack {
    //Top node contains front node in the stack
    private Node top;

    /**
     * Constructor to create a new Stack
     */
    public MyStack() {
        this.top = null;
    }

    /**
     * Insert at the beginning
     * @param info
     */
    public void push(Product info) {
        Node temp = new Node(info);
        //check if stack is full
        if (temp == null) {
            System.out.print("\nStack Overflow");
            return;
        }
        temp.setNextNode(this.top);
        this.top = temp;
    }

    /**
     * Display the stack on the console
     */
    public void display() {
        if (this.top == null){
            System.out.printf("\nStack Underflow");
            System.exit(1);
        }else {
            Node temp = this.top;
            System.out.println("ID   |Title |Quantity |Price " + "\n" + "-------------------------");
            while (temp != null){
                System.out.println(temp.getInfo());
                temp = temp.getNextNode();
            }
        }
    }
}
