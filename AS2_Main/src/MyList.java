public class MyList {
    private Node head, tail;

    /**
     * default constructor
     */
    public MyList() {
    }

    /**
     * Constructor to create a new Linked List
     * @param head
     * @param tail
     */
    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * getter
     * @return head
     */
    public Node getHead() {
        return head;
    }

    /**
     * setter
     * @param head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * getter
     * @return Node tail
     */
    public Node getTail() {
        return tail;
    }

    /**
     * setter
     * @param tail
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Returning the length of this list
     * @return The length of this list
     */
    public int length() {
        int length = 0;
        Node current = this.head;
        while (current != null) {
            current = current.getNextNode();
            length++;
        }
        return length;
    }

    /**
     * Swap the Nodes
     * @param firstNode
     * @param secondNode
     */
    public void swap(Node firstNode, Node secondNode) {
        Product temp;
        temp = firstNode.getInfo();
        firstNode.setInfo(secondNode.getInfo());
        secondNode.setInfo(temp);
    }

    /**
     * Insert an item to the head of this list
     * @param item The item to be inserted
     */
    public void insertAtTail(Product item) {
        Node newNode = new Node(item);

        //If the Linked List is empty, then make the newNode as head
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        //Insert newNode at tail of Linked List
        if (this.tail != null) {
            this.tail.setNextNode(newNode);
            this.tail = newNode;
        }
    }

    @Override
    public String toString() {
        String result = "ID   |Title |Quantity |Price " + "\n" + "-------------------------" + "\n";
        Node current = this.head;
        while (current != null){
            result += current + "\n";
            current = current.getNextNode();
        }
        return result;
    }
}
