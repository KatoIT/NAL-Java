package exercise;

public class DeployQueue {
    private Node front;
    private Node rear;
    private int size = 0;

    public void enQueue(int element) {
        Node node = new Node(element);
        if (size == 0) {
            node.setLink(node);
            front = node;
            rear = node;
        } else {
            rear.setLink(node);
            rear = node;
            rear.setLink(front);
        }
        size++;
    }

    public void deQueue() {
        if (size != 0) {
            front = front.getLink();
            rear.setLink(front);
            size--;
        }
    }

    public void displayQueue() {
        System.out.print("Queue: ");
        if (size == 0) {
            System.out.println("Null");
        } else {
            Node curNode = front;
            for (int i = 0; i < size; i++) {
                System.out.print(curNode.toString());
                curNode = curNode.getLink();
            }
//            System.out.println();
        }
    }

}
