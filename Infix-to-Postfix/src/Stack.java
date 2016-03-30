
public interface Stack {
	int getSize();
	boolean isEmpty();
	Object peek() throws EmptyStackException;
	Object pop() throws EmptyStackException;
	void push(Object item );
}
