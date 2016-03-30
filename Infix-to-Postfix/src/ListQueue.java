public class ListQueue extends LinkedList implements Queue {
	LinkedList list = new LinkedList();

	@Override
	public int getSize() {
		return list.getSize();
	}

	@Override
	public boolean isEmpty() {
		return (list.isEmpty());
	}

	@Override
	public Object peek() throws EmptyQueueException {
		if (this.isEmpty()) {
			return new EmptyQueueException("The list queue is empty.");
		}
		return list.getTail().data;
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		Object data = this.peek();
		list.removeBack();
		return data;
	}

	@Override
	public void enqueue(Object item) {
		list.insertFront(item);
	}

}
