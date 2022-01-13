package exercise;

public class Solution {

    public static void main(String[] args) {
        DeployQueue deployQueue = new DeployQueue();
        deployQueue.enQueue(4);
        deployQueue.enQueue(6);
        deployQueue.enQueue(5);
        deployQueue.enQueue(1);
        deployQueue.displayQueue();
    }

}
