public class Node {
    private Product info;
    private Node nextNode;

    /**
     * Constructor to create a new node
     * @param info
     */
    public Node(Product info) {
        this.info = info;
        this.nextNode = null;
    }


    /**
     * getter
     * @return info
     */
    public Product getInfo() {
        return info;
    }

    /**
     * getter
     * @return nextNode
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * setter
     * @param info
     */
    public void setInfo(Product info) {
        this.info = info;
    }

    /**
     * setter
     * @param nextNode
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "" + info;
    }
}
