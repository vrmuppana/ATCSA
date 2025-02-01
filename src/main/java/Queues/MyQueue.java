package Queues;

public interface MyQueue {
    public boolean empty();
    public boolean offer(Object item);
    public Object poll();
    public Object peek();
    public String toString();
}
