package exercise;

public class Node {
    private int data;
    private Node link;

    public Node(int data) {
        this.data = data;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Node getLink() {
        return link;
    }

    @Override
    public String toString() {
        return " " + data;
    }

}
