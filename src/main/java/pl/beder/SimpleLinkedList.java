package pl.beder;


public class SimpleLinkedList implements Table {
    Node firstNode;
    Node lastNode;
    int size;

    public SimpleLinkedList() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }


    @Override
    public long size() {
        return size;
    }

    @Override
    public long get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        Node tmp = firstNode;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNextNode();
        }
        return tmp.getValue();
    }

    @Override
    public int firstIndexWith(long value) {
        int index = 0;
        Node tmp = firstNode;
        while (tmp != null) {
            if (tmp.getValue() == value)
                return index;
            tmp = tmp.getNextNode();
            index++;
        }
        return -1;

    }

    @Override
    public int firstIndexWithGivenOrHigherValue(long value) {
        int index = 0;
        Node tmp = firstNode;
        while (tmp != null) {
            if (tmp.getValue() >= value)
                return index;
            tmp = tmp.getNextNode();
            index++;
        }
        return -1;
    }

    @Override
    public void insertAt(int index, long value) {
        if (firstNode == null || index == size) {
            insert(value);
        } else {
            Node nodeToInsert = new Node(value);
            Node nodeAtIndex = findNodeWithIndex(index);
            Node nodeBeforeIndex = findNodeWithIndex(index - 1);

            if (index == 0){
                nodeToInsert.setNextNode(firstNode);
                firstNode.setPreviousNode(nodeToInsert);
                firstNode = nodeToInsert;
                size++;
            } else {
                nodeToInsert.setNextNode(nodeAtIndex);
                nodeToInsert.setPreviousNode(nodeBeforeIndex);

                nodeBeforeIndex.setNextNode(nodeToInsert);
                nodeAtIndex.setPreviousNode(nodeToInsert);
                size++;
            }
        }
    }
    public Node findNodeWithIndex(int index) {
        Node nodeAtIndex = firstNode;
        for (int i = 0; i < index; i++) {
            nodeAtIndex = nodeAtIndex.getNextNode();
        }
        return nodeAtIndex;
    }

    @Override
    public void insertSorted(long value) {
        if (size > 0) {
            int index = 0;
            Node tmp = firstNode;
            while (value > tmp.getValue() && index < size) {
                if (tmp.getNextNode() != null){
                    tmp = tmp.getNextNode();
                }
                index++;
            }
            insertAt(index, value);
        } else {
            insert(value);
        }
    }

    @Override
    public long[] getHolderView() {
        long[] longs = new long[size];
        int index = 0;
        Node tmp = firstNode;
        while (tmp != null) {
            longs[index++] = tmp.getValue();
            tmp = tmp.getNextNode();
        }
        return longs;
    }

    @Override
    public void insert(long value) {
        if (firstNode == null) {
            firstNode = new Node(value);
            lastNode = firstNode;
        } else {
            Node next = new Node(value);
            lastNode.setNextNode(next);
            next.setPreviousNode(lastNode);
            lastNode = next;
        }
        size++;
    }


}
