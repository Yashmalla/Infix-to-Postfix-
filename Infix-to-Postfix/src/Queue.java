
public interface Queue {
	int getSize();
	boolean isEmpty();
	Object peek() throws EmptyQueueException;
	Object dequeue() throws EmptyQueueException;
	void enqueue(Object item );
}
