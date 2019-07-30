package pl.beder;

public class Node {
    private long value;
    Node nextNode;
    Node previousNode;

    public Node(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node forwardReference) {
        this.nextNode = forwardReference;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
}
