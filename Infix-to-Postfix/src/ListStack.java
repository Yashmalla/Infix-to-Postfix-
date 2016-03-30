
public class ListStack extends LinkedList implements Stack {
	LinkedList list = new LinkedList();
	@Override
	public int getSize() {
		return list.getSize();
	}
	@Override
	public boolean isEmpty() {
		return(list.isEmpty());
	}

	@Override
	public Object peek() throws EmptyStackException {
		if (this.isEmpty()) {
		}
		return list.getHead().data;
	}

	@Override
	public Object pop() throws EmptyStackException {
		Object data = this.peek();
		list.removeFront();
		return data;
	}

	@Override
	public void push(Object item) {
		list.insertFront(item);
	}

}
